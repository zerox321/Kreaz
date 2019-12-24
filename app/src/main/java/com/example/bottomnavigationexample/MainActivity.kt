package com.example.bottomnavigationexample

import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import com.example.bottomnavigationexample.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )
    }
    private val navController: NavController by lazy {
        findNavController(R.id.nav_host_fragment)
    }
    private val appBarConfiguration: AppBarConfiguration by lazy {
        AppBarConfiguration(
            setOf(
                R.id.fragment_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications
            )
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(binding.toolbar)

        setupActionBarWithNavController(navController, appBarConfiguration)

        nav_view.setupWithNavController(navController)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}
