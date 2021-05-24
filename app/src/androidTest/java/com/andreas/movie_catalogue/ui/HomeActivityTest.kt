package com.andreas.movie_catalogue.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.andreas.movie_catalogue.R
import com.andreas.movie_catalogue.utils.DataDummyMovie
import com.andreas.movie_catalogue.utils.DataDummyTvShow
import org.junit.Rule
import org.junit.Test


class HomeActivityTest{
    private val dummyMovie = DataDummyMovie.getMovies()
    private val dummyTv = DataDummyTvShow.getTvShow()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovies(){
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }


    @Test
    fun loadDetailMovie(){
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitle)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.tvCat)).check(matches(isDisplayed()))
        onView(withId(R.id.tvCat)).check(matches(withText("Action, Science Fiction, Adventure")))
        onView(withId(R.id.tvName)).check(matches(isDisplayed()))
        onView(withId(R.id.tvName)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.tvDesc)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDesc)).check(matches(withText(dummyMovie[0].description)))
        onView(withId(R.id.tvDur)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDur)).check(matches(withText(dummyMovie[0].duration)))
    }

    @Test
    fun loadTvShow(){
        onView(withId(R.id.tabTV)).perform(click())
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTv.size))
    }

    @Test
    fun loadDetailTv(){
        onView(withId(R.id.tabTV)).perform(click())
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitle)).check(matches(withText(dummyTv[0].title)))
        onView(withId(R.id.tvFirstAir)).check(matches(isDisplayed()))
        onView(withId(R.id.tvFirstAir)).check(matches(withText("2021-03-19")))
        onView(withId(R.id.tvName)).check(matches(isDisplayed()))
        onView(withId(R.id.tvName)).check(matches(withText(dummyTv[0].title)))
        onView(withId(R.id.tvDeskripsi)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDeskripsi)).check(matches(withText(dummyTv[0].description)))
    }
}