package com.bcassar.nbafantasy.scoreboard

import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bcassar.nbafantasy.DayPagerFragment

/**
 * Created by bcassar on 28/10/2022
 */
class ScoreboardFragment : DayPagerFragment() {

    override fun getDayPagerAdapter(): FragmentStateAdapter = GameListPagerAdapter(this)

}