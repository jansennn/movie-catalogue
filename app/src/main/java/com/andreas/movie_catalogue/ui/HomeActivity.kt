package com.andreas.movie_catalogue.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import com.andreas.movie_catalogue.R
import com.andreas.movie_catalogue.ui.movie.MovieFragment
import com.andreas.movie_catalogue.ui.tvshow.TvShowFragment
import com.andreas.movie_catalogue.utils.BottomBarBehavior
import com.gauravk.bubblenavigation.BubbleNavigationLinearView

class HomeActivity : AppCompatActivity() {

    var fragment: Fragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val navigationBar =
            findViewById<BubbleNavigationLinearView>(R.id.navigationBar)

        val layoutParams =
            navigationBar.layoutParams as CoordinatorLayout.LayoutParams
        layoutParams.behavior = BottomBarBehavior()

        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, MovieFragment())
            .commit()

        navigationBar.setNavigationChangeListener { view, position ->
            when (position) {
                0 -> fragment = MovieFragment()
                1 -> fragment = TvShowFragment()
            }
            supportFragmentManager.beginTransaction().replace(
                R.id.frameLayout,
                fragment!!
            )
                .commit()
        }
    }
}