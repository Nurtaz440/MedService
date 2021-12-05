package mening.dasturim.medservice.ui.main.user.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
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

        adapter = HomeAdapter { item->

  //              findNavController().navigate(R.id.lorFragment)
//                1 -> findNavController().navigate(R.id.lorFragment)
//                2 -> findNavController().navigate(R.id.lorFragment)
//                3 -> findNavController().navigate(R.id.lorFragment)
//                4 -> findNavController().navigate(R.id.lorFragment)
//                5 -> findNavController().navigate(R.id.kardialogiyaFragment)

        }

        adapter.setData(Constants.getHomeItems())
        binding.list.enableViewScaling(true)
        binding.list.adapter = adapter

        newsAdapter.setData(Constants.getNewsItems())
        binding.rvNews.layoutManager=LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)
        binding.rvNews.adapter=newsAdapter
    }

    @LayoutRes
    override fun getLayoutResId(): Int = R.layout.fragment_home
    override val vm: HomeVM
        get() = ViewModelProvider(this).get(HomeVM::class.java)



}