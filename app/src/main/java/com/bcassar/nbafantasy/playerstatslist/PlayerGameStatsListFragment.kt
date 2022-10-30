package com.bcassar.nbafantasy.playerstatslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bcassar.nbafantasy.databinding.FragmentPlayerGameStatsListBinding
import com.bcassar.nbafantasy.utils.argument
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

/**
 * Created by bcassar on 30/10/2022
 */
class PlayerGameStatsListFragment : Fragment() {

    private var _binding: FragmentPlayerGameStatsListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // Lazy inject ViewModel
    private var date: String by argument()
    val viewModel: PlayerGameStatsListViewModel by viewModel { parametersOf(date) }

    private val playerGameStatsAdapter = PlayerGameStatsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayerGameStatsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchPlayerGameStatsList()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLayout()
        initObservers()
    }

    private fun initLayout() {
        binding.retryButton.setOnClickListener {
            viewModel.fetchPlayerGameStatsList()
        }
        binding.playerGameStatsList.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = playerGameStatsAdapter
        }
    }

    private fun initObservers() {
        viewModel.playerGameStatsListEvent.observe(viewLifecycleOwner) { event ->
            event.consume()?.let {
                when (val playerGameStatsListEvent = it.data) {
                    PlayerGameStatsListEvent.PlayerGameStatsListFetching -> {
                        binding.playerGameStatsList.isVisible = false
                        binding.retryButton.isVisible = false
                        binding.progress.isVisible = true
                    }
                    is PlayerGameStatsListEvent.PlayerGameStatsListFetched -> {
                        binding.playerGameStatsList.isVisible = true
                        binding.progress.isVisible = false
                        playerGameStatsAdapter.submitList(playerGameStatsListEvent.playerGameStatsList.sortedByDescending { it.fantasyPoints })
                    }
                    is PlayerGameStatsListEvent.PlayerGameStatsListFetchingFailed -> {
                        binding.retryButton.isVisible = true
                        binding.progress.isVisible = false
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(date: String): PlayerGameStatsListFragment {
            return PlayerGameStatsListFragment().apply {
                this.date = date
            }
        }
    }


}