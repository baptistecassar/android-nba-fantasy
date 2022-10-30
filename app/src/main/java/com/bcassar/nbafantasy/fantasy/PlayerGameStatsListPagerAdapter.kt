package com.bcassar.nbafantasy.fantasy

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bcassar.nbafantasy.playerstatslist.PlayerGameStatsListFragment
import com.bcassar.nbafantasy.utils.DateUtils

/**
 * Created by bcassar on 28/10/2022
 */
class PlayerGameStatsListPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = DateUtils.getSeasonTotalDays()

    override fun createFragment(position: Int): Fragment {
        val date = DateUtils.getDayDateWithCalendar(position)
        return PlayerGameStatsListFragment.newInstance(date)
    }

}