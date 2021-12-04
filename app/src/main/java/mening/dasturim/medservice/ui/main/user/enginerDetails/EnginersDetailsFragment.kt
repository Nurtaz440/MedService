package mening.dasturim.medservice.ui.main.user.enginerDetails

import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.annotation.LayoutRes
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.medservice.R
import mening.dasturim.medservice.data.constants.Constants
import mening.dasturim.medservice.data.model.EnginerssDetailItems
import mening.dasturim.medservice.databinding.FragmentEnginersDetailsBinding
import mening.dasturim.medservice.ui.base.BaseFragment
import java.util.*

class EnginersDetailsFragment : BaseFragment<FragmentEnginersDetailsBinding, DetailsVM>() {
    private lateinit var enginersAdapter: EnginersAdapter
    private lateinit var workerAdapter: WorkerAdapter
    private lateinit var workerAdapterPast: WorkerAdapter
    private lateinit var certificateAdapter: CertificateAdapter
    private lateinit var data: ArrayList<EnginerssDetailItems>


    override fun onBound() {
        setUp()
    }

    fun setUp() {

        data = Constants.getEnginersDetailItems()
        enginersAdapter = EnginersAdapter { position, lastPosition ->
            if (position != lastPosition) {
                data[position] =
                    EnginerssDetailItems(
                        data[position].categoryName,
                        R.color.nile_blue_900,
                        R.color.white
                    )
                data[lastPosition] = EnginerssDetailItems(
                    data[lastPosition].categoryName,
                    R.color.solitude_50,
                    R.color.tangaroa_900
                )
                enginersAdapter.setData(data)
                when (position) {
                    0 -> {
                        binding.clAboutDoctor.visibility = View.VISIBLE
                        binding.clComment.visibility = View.GONE
                        binding.clWork.visibility = View.GONE
                        binding.clSertificate.visibility = View.GONE
                    }
                    1 -> {
                        loadWork()
                        binding.clAboutDoctor.visibility = View.GONE
                        binding.clWork.visibility = View.VISIBLE
                        binding.clComment.visibility = View.GONE
                        binding.clSertificate.visibility = View.GONE
                    }

                    2 -> {
                        loadCertificate()
                        binding.clAboutDoctor.visibility = View.GONE
                        binding.clWork.visibility = View.GONE
                        binding.clComment.visibility = View.GONE
                        binding.clSertificate.visibility = View.VISIBLE
                    }
                }
            }

            binding.rvDoctorAboutDetails.adapter = enginersAdapter
            binding.rvDoctorAboutDetails.layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)


        }


        binding.ivCall.setOnClickListener {
            val number = "+998936285220"
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = (Uri.fromParts("tel", number, null))
            startActivity(intent)
        }
    }


    private fun loadWork() {
        //workCurrent
        workerAdapter = WorkerAdapter()
        workerAdapter.setData(Constants.getCurrentWork())
        binding.rvWorkCurrent.adapter = workerAdapter
        binding.rvWorkCurrent.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)

        //workPast
        workerAdapterPast = WorkerAdapter()
        workerAdapterPast.setData(Constants.getPastWork())
        binding.rvWorkPast.adapter = workerAdapterPast
        binding.rvWorkPast.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)

    }

    private fun loadCertificate() {
        //certificate
        certificateAdapter = CertificateAdapter {
//            findNavController().navigate(
//
//            )
        }
        certificateAdapter.setData(Constants.getSertificate())
        binding.rvSertificate.adapter = certificateAdapter
        binding.rvSertificate.layoutManager = GridLayoutManager(requireContext(), 2)

    }

@LayoutRes
override fun getLayoutResId(): Int = R.layout.fragment_enginers_details
override val vm: DetailsVM
    get() = ViewModelProvider(this).get(DetailsVM::class.java)

}