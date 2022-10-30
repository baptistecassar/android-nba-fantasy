package com.bcassar.nbafantasy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.bcassar.nbafantasy.databinding.FragmentDayPagerBinding
import com.bcassar.nbafantasy.utils.DateUtils

/**
 * Created by bcassar on 29/10/2022
 */
abstract class DayPagerFragment : Fragment() {

    private var _binding: FragmentDayPagerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    protected val binding get() = _binding!!

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
        _binding = FragmentDayPagerBinding.inflate(inflater, container, false)
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
        binding.pager.apply {
            adapter = getDayPagerAdapter()
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

    abstract fun getDayPagerAdapter(): FragmentStateAdapter

}