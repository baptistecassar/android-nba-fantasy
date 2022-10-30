package com.bcassar.nbafantasy.fantasy

import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bcassar.nbafantasy.DayPagerFragment

/**
 * Created by bcassar on 29/10/2022
 */
class FantasyFragment : DayPagerFragment() {

    override fun getDayPagerAdapter(): FragmentStateAdapter = PlayerGameStatsListPagerAdapter(this)

}