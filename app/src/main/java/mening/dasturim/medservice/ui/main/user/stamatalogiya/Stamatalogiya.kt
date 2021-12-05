package mening.dasturim.medservice.ui.main.user.stamatalogiya

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import mening.dasturim.medservice.R
import mening.dasturim.medservice.databinding.FragmentKardialogiyaBinding
import mening.dasturim.medservice.databinding.FragmentLorBinding
import mening.dasturim.medservice.ui.base.BaseFragment
import mening.dasturim.medservice.ui.main.user.kardialofiya.KardialogiyaVM

class Stamatalogiya : BaseFragment<FragmentLorBinding, StamVM>() {


    override fun onBound() {
        setUp()
    }

    fun setUp(){

    }

    override fun getLayoutResId()=R.layout.fragment_stamatolog

    override val vm: StamVM
        get() = ViewModelProvider(this).get(StamVM::class.java)

}
