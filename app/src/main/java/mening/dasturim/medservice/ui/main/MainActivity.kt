package mening.dasturim.medservice.ui.main

import android.view.View
import androidx.activity.viewModels
import androidx.annotation.LayoutRes
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import mening.dasturim.medservice.R
import mening.dasturim.medservice.databinding.ActivityMainBinding
import mening.dasturim.medservice.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding, MainVM>() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var bottomNavController: BottomNavController
    private lateinit var navController: NavController

    override fun onBound() {
        setUp()
    }

    private fun setUp() {

        val navHost = supportFragmentManager.findFragmentById(R.id.main_nav_controller)
        if (navHost != null) {
            navController = navHost.findNavController()
        }
        bottomNavController =
            BottomNavController(binding, binding.partialBottomNav, this, navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
        }

        binding.nvNavigationDrawer.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> navController.navigate(R.id.homeFragment)
                R.id.enginer -> navController.navigate(R.id.ourEnginerFragment)
                R.id.nav_personal_account -> navController.navigate(R.id.myProflle)
                R.id.old_equip -> navController.navigate(R.id.oldEquipmentFragment)
                R.id.location -> navController.navigate(R.id.locationAndContact)
                R.id.new_equip -> navController.navigate(R.id.newEquipmentFragment)
            }
            binding.dlMenu.closeDrawer(GravityCompat.START)
            true
        }
    }

    @LayoutRes
    override fun getLayoutResId() = R.layout.activity_main
    override val vm: MainVM by viewModels()

    override fun setStatusBarBackgroundHeight(statusBarBackground: View) {}

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        if (binding.dlMenu.isDrawerOpen(GravityCompat.START)) {
            binding.dlMenu.closeDrawer(GravityCompat.START)
        } else if (!bottomNavController.onBackPressed())
            bottomNavController.onBackPressed()
        super.onBackPressed()
    }
}