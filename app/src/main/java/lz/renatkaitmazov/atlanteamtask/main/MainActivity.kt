package lz.renatkaitmazov.atlanteamtask.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import lz.renatkaitmazov.atlanteamtask.R
import lz.renatkaitmazov.atlanteamtask.app.AtlanApp
import lz.renatkaitmazov.atlanteamtask.databinding.ActivityMainBinding

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
    }
}