package mening.dasturim.medservice.ui.main.user.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.medservice.R
import mening.dasturim.medservice.data.constants.Constants
import mening.dasturim.medservice.databinding.FragmentHomeBinding
import mening.dasturim.medservice.ui.base.BaseFragment
import mening.dasturim.medservice.ui.main.user.news.NewsAdapter


class HomeFragment : BaseFragment<FragmentHomeBinding,HomeVM>() {
    private lateinit var adapter: HomeAdapter
    private lateinit var newsAdapter: NewsAdapter

    override fun onBound() {
        setUp()
    }

    fun setUp(){

//        adapter = HomeAdapter {
//            when (it) {
//                it -> findNavController().navigate(R.id.ourDoctorsFragment)
//            }
//        }

        adapter= HomeAdapter {  }
        adapter.setData(Constants.getHomeItems())
        binding.list.enableViewScaling(true)
        binding.list.adapter = adapter

        newsAdapter= NewsAdapter {  }
        newsAdapter.setData(Constants.getNewsItems())
        binding.rvNews.layoutManager=LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)
        binding.rvNews.adapter=newsAdapter
    }

    @LayoutRes
    override fun getLayoutResId(): Int = R.layout.fragment_home
    override val vm: HomeVM
        get() = ViewModelProvider(this).get(HomeVM::class.java)



}