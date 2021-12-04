package mening.dasturim.medservice.ui.main.user.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModelProvider
import mening.dasturim.medservice.R
import mening.dasturim.medservice.data.constants.Constants
import mening.dasturim.medservice.databinding.FragmentHomeBinding
import mening.dasturim.medservice.ui.base.BaseFragment


class HomeFragment : BaseFragment<FragmentHomeBinding,HomeVM>() {
    private lateinit var adapter: HomeAdapter

    override fun onBound() {
        setUp()
    }

    fun setUp(){

//        adapter = HomeAdapter {
//            when (it) {
//                it -> findNavController().navigate(R.id.ourDoctorsFragment)
//            }
//        }

        adapter=HomeAdapter {  }
        adapter.setData(Constants.getHomeItems())
        binding.list.adapter = adapter
    }

    @LayoutRes
    override fun getLayoutResId(): Int = R.layout.fragment_home
    override val vm: HomeVM
        get() = ViewModelProvider(this).get(HomeVM::class.java)



}