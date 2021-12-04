package mening.dasturim.medservice.ui.main.user.enginer

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.medservice.R
import mening.dasturim.medservice.data.constants.Constants
import mening.dasturim.medservice.databinding.FragmentOurEnginerBinding
import mening.dasturim.medservice.ui.base.BaseFragment

class OurEnginerFragment : BaseFragment<FragmentOurEnginerBinding, OurEnginerVM>() {

    private lateinit var ourEnginerAdapter: OurEnginerAdapter

    override fun onBound() {
        setUp()
    }

    fun setUp() {

        ourEnginerAdapter= OurEnginerAdapter { item->
            findNavController().navigate(R.id.enginersDetailsFragment)
        }
        ourEnginerAdapter.setData(Constants.getOurEnginersItems())
        binding.rvEnginers.layoutManager=LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)
        binding.rvEnginers.adapter=ourEnginerAdapter
    }

    override fun getLayoutResId() = R.layout.fragment_our_enginer
    override val vm: OurEnginerVM
        get() = ViewModelProvider(this).get(OurEnginerVM::class.java)

}