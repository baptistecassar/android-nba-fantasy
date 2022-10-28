package com.bcassar.nbafantasy.gamelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bcassar.nbafantasy.databinding.FragmentGameListBinding
import com.bcassar.nbafantasy.utils.argument
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

/**
 * Created by bcassar on 28/10/2022
 * This fragment is used to display the list of games happening in a day
 */
class GameListFragment : Fragment() {

    private var _binding: FragmentGameListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // Lazy inject ViewModel
    private var date: String by argument()
    val gameListViewModel: GameListViewModel by viewModel { parametersOf(date) }


    private val gameAdapter = GameAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLayout()
        initObservers()
    }

    private fun initLayout() {
        binding.retryButton.setOnClickListener {
            gameListViewModel.fetchGameList()
        }
        binding.gameList.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = gameAdapter
        }
    }

    private fun initObservers() {
        gameListViewModel.gameListEvent.observe(viewLifecycleOwner) { event ->
            event.consume()?.let {
                when (val gameListEvent = it.data) {
                    GameListEvent.GameListFetching -> {
                        binding.gameList.isVisible = false
                        binding.retryButton.isVisible = false
                        binding.progress.isVisible = true
                    }
                    is GameListEvent.GameListFetched -> {
                        binding.gameList.isVisible = true
                        binding.progress.isVisible = false
                        gameAdapter.submitList(gameListEvent.games)
                    }
                    is GameListEvent.GameListFetchingFailed -> {
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
        fun newInstance(date: String): GameListFragment {
            return GameListFragment().apply {
                this.date = date
            }
        }
    }
}