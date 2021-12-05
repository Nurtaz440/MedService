package mening.dasturim.medservice.ui.main.user.travmatolofiya

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

class Trav : BaseFragment<FragmentLorBinding, TravVM>() {


    override fun onBound() {
        setUp()
    }

    fun setUp(){

    }

    override fun getLayoutResId()=R.layout.fragment_lor

    override val vm: TravVM
        get() = ViewModelProvider(this).get(TravVM::class.java)

}
