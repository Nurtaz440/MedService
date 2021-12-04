package mening.dasturim.medservice.ui.main.user.enginerDetails

import androidx.lifecycle.ViewModelProvider
import mening.dasturim.medservice.R
import mening.dasturim.medservice.databinding.FragmentCertificateBinding
import mening.dasturim.medservice.ui.base.BaseFragment

class CertificateFragment : BaseFragment<FragmentCertificateBinding, CertificateVM>() {
    private lateinit var certificateAdapter: CertificateAdapter

    override fun onBound() {
       setUp()

    }
    fun setUp()
    {

    }
    override fun getLayoutResId() = R.layout.fragment_certificate
    override val vm: CertificateVM
        get() = ViewModelProvider(this).get(CertificateVM::class.java)

}