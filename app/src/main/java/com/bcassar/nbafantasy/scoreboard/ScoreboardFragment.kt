package com.bcassar.nbafantasy.scoreboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.bcassar.nbafantasy.databinding.FragmentScoreboardBinding
import com.bcassar.nbafantasy.utils.DateUtils

/**
 * Created by bcassar on 28/10/2022
 */
class ScoreboardFragment : Fragment() {

    private var _binding: FragmentScoreboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var pagerAdapter: GameListPagerAdapter

    private val dateChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            binding.dateText.text = DateUtils.getDayDateWithCalendar(position)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScoreboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLayout()
    }

    private fun initLayout() {
        pagerAdapter = GameListPagerAdapter(this)
        binding.pager.apply {
            adapter = pagerAdapter
            registerOnPageChangeCallback(dateChangeCallback)
            currentItem = DateUtils.getDayAfterSeasonStart()
        }
        binding.backArrow.setOnClickListener {
            binding.pager.currentItem = binding.pager.currentItem - 1
        }
        binding.forwardArrow.setOnClickListener {
            binding.pager.currentItem = binding.pager.currentItem + 1
        }
    }

}