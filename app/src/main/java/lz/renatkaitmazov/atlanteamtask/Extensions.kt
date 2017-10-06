package lz.renatkaitmazov.atlanteamtask

import android.annotation.SuppressLint
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN
import android.support.v7.app.AppCompatActivity

/**
 *
 * @author Renat Kaitmazov
 */

/*------------------------------------------------------------------------*/
// Activity Extensions
/*------------------------------------------------------------------------*/

@SuppressLint("CommitTransaction")
fun AppCompatActivity.addFragment(fragment: Fragment, @IdRes containerId: Int) {
    val fragmentManager = supportFragmentManager
    val currentFragment = fragmentManager.findFragmentById(containerId)
    if (currentFragment == null) {
        // The container was empty.
        fragmentManager.beginTransaction()
                .add(containerId, fragment)
                .commitNow()
    }
}

@SuppressLint("CommitTransaction")
fun AppCompatActivity.replaceFragment(fragment: Fragment, @IdRes containerId: Int) {
    supportFragmentManager.beginTransaction()
            .replace(containerId, fragment)
            .setTransition(TRANSIT_FRAGMENT_OPEN)
            .commitNow()
}