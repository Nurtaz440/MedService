package mening.dasturim.medservice.ui.main.user.uralogiya

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

class Urolog : BaseFragment<FragmentLorBinding, UrologVM>() {


    override fun onBound() {
        setUp()
    }

    fun setUp(){

    }

    override fun getLayoutResId()=R.layout.fragment_lor

    override val vm: UrologVM
        get() = ViewModelProvider(this).get(UrologVM::class.java)

}
