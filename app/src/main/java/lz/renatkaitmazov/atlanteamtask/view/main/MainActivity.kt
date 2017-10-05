package lz.renatkaitmazov.atlanteamtask.view.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import lz.renatkaitmazov.atlanteamtask.R
import lz.renatkaitmazov.atlanteamtask.addFragment
import lz.renatkaitmazov.atlanteamtask.databinding.ActivityMainBinding
import lz.renatkaitmazov.atlanteamtask.view.main.cardlist.CardListFragment

/**
 *
 * @author Renat Kaitmazov
 */

class MainActivity : AppCompatActivity() {

    /*------------------------------------------------------------------------*/
    // Properties
    /*------------------------------------------------------------------------*/

    private lateinit var binding: ActivityMainBinding

    /*------------------------------------------------------------------------*/
    // Lifecycle Events
    /*------------------------------------------------------------------------*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initBottomNavView(binding.bottomView)
        if (savedInstanceState == null) {
            addFragment(CardListFragment.newInstance(), R.id.fragment_container)
        }
    }

    private fun initBottomNavView(navView: BottomNavigationView) {
        navView.selectedItemId = R.id.menu_cards
        navView.setOnNavigationItemSelectedListener listener@ { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_cards -> println("Clicked " + menuItem.title)
                R.id.menu_my_contacts -> println("Clicked " + menuItem.title)
            }
            return@listener true
        }
    }
}