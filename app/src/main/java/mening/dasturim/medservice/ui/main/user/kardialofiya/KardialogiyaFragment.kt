package mening.dasturim.medservice.ui.main.user.kardialofiya

import androidx.lifecycle.ViewModelProvider
import mening.dasturim.medservice.R
import mening.dasturim.medservice.databinding.FragmentKardialogiyaBinding
import mening.dasturim.medservice.ui.base.BaseFragment


class KardialogiyaFragment : BaseFragment<FragmentKardialogiyaBinding,KardialogiyaVM>() {


    override fun getLayoutResId()=R.layout.fragment_kardialogiya

    override fun onBound() {
        setUp()
    }

    fun setUp(){

    }

    override val vm: KardialogiyaVM
    get() = ViewModelProvider(this).get(KardialogiyaVM::class.java)

}
