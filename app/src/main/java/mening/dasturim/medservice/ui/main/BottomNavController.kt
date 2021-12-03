package mening.dasturim.medservice.ui.main

import android.annotation.SuppressLint
import android.util.Log
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import mening.dasturim.medservice.R
import mening.dasturim.medservice.databinding.ActivityMainBinding
import mening.dasturim.medservice.databinding.PartialBottomNavigationBinding
import mening.dasturim.medservice.utils.ViewUtils
import mening.dasturim.medservice.utils.showToast

class BottomNavController(
    private val bindingActivity: ActivityMainBinding,
    private val binding: PartialBottomNavigationBinding,
    private val activity: AppCompatActivity,
    private val navController: NavController
    ){

        private var oldClickedItemPos = 0
        private var lastClickedItemPos = 0
        private lateinit var navOptions: NavOptions
        private var lastBackClickTime = 0L


        init {
            controlBottomNav()
        }

        private fun controlBottomNav() {
            binding.apply {
                cl1.setOnClickListener {

                    lastClickedItemPos = 0
                    handleClick()

                }
                cl2.setOnClickListener {

                    lastClickedItemPos = 1
                    handleClick()

                }
                cl3.setOnClickListener {

                    lastClickedItemPos = 2
                    handleClick()

                }
            }
        }

        private fun handleClick() {
            makeDefaultItem()
            highlightItem()
        }

        private fun makeDefaultItem() {
            binding.apply {
                when (oldClickedItemPos) {
                    0 -> {
                        ViewUtils.fadeOut(view1, 200)
                    }
                    1 -> {
                        ViewUtils.fadeOut(view2, 200)
                    }
                    2 -> {
                        ViewUtils.fadeOut(view3, 200)
                    }
                }
            }

        }

        @SuppressLint("RtlHardcoded")
        private fun highlightItem() {
            binding.apply {
                when (lastClickedItemPos) {
                    0 -> {
                        navOptions = NavOptions.Builder()
                            .setLaunchSingleTop(true)
                            .setPopUpTo(R.id.homeFragment, true)
                            .build()
                        ViewUtils.fadeIn(view1, 200)
//                    navController.popBackStack(R.id.homeFragment, false)
                        navController.navigate(R.id.homeFragment, bundleOf(), navOptions)
                        return@apply
                    }
                    1 -> {
                        navOptions = NavOptions.Builder()
                            .setLaunchSingleTop(true)
//                        .setPopUpTo(R.id.ratingFragment, true)
                            .build()
                        ViewUtils.fadeIn(view2, 200)
//                    navController.popBackStack(R.id.ratingFragment, false)
//                    navController.navigate(R.id.ratingFragment, bundleOf(), navOptions)
   //                     navController.navigate(R.id.searchViewFragment, bundleOf(),navOptions)
                        return@apply
                    }
                    2 -> {
                        navOptions = NavOptions.Builder()
                            .setLaunchSingleTop(true)
                            .setPopUpTo(R.id.nv_navigation_drawer, true)
                            .build()
                        ViewUtils.fadeIn(view3, 200)
                        if(!bindingActivity.dlMenu.isDrawerOpen(Gravity.LEFT)) bindingActivity.dlMenu.openDrawer(
                            Gravity.LEFT)
                        else bindingActivity.dlMenu.closeDrawer(Gravity.RIGHT)
                        return@apply
                    }
                }
            }
            oldClickedItemPos = lastClickedItemPos
        }

        fun onBackPressed(): Boolean {
            val currentDest = navController.currentDestination?.id
            if (currentDest == R.id.homeFragment) {
                Log.d("--------------", "onBackPerssed: called")
                val currentTime = System.currentTimeMillis()

                if (lastBackClickTime + 2000 > currentTime) {
                    activity.finish()
                } else {
                    activity.showToast(activity.getString(R.string.on_back_pressed))
                    lastBackClickTime = currentTime
                }
                return true
            }
            return false
        }


    }