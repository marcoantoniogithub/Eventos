package com.example.eventos.features.eventsList.presentation

import android.widget.Toast
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import com.example.eventos.R
import com.example.eventos.common.base.BaseFragment
import com.example.eventos.databinding.FragmentEventsListBinding
import com.example.eventos.features.eventsList.domain.model.Event
import com.example.eventos.features.eventsList.presentation.EventsListViewModel.ViewAction.CloseKeyboard
import com.example.eventos.features.eventsList.presentation.EventsListViewModel.ViewAction.HideLoading
import com.example.eventos.features.eventsList.presentation.EventsListViewModel.ViewAction.ShowLoading
import com.example.eventos.features.eventsList.presentation.EventsListViewModel.ViewAction.ShowSnackBarError
import com.example.eventos.features.eventsList.presentation.EventsListViewModel.ViewState.LoadEventsFail
import com.example.eventos.features.eventsList.presentation.EventsListViewModel.ViewState.LoadEventsSuccess
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventsListFragment(
) : BaseFragment<FragmentEventsListBinding>() {

    private lateinit var eventsAdapter: EventAdapter

    val EventsListViewModel: EventsListViewModel by viewModel()

    override fun getLayout() = R.layout.fragment_events_list

    override fun initBinding() {
        binding.viewModel = EventsListViewModel

        eventsAdapter = EventAdapter { event: Event ->
            navigationForDetails(event)
        }

        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.listEventRecycleview.apply {
            this.layoutManager = layoutManager
            adapter = eventsAdapter
        }
    }


    private fun navigationForDetails(model: Event) {
//        val action = ListMovieFragmentDirections.actionListFilmToDetailsFilm(model.id)
//        view?.findNavController()?.navigate(action)
    }

    override fun observers() {
        EventsListViewModel.action.observe(viewLifecycleOwner) {
            when (it) {
                CloseKeyboard -> showToast("Fechar teclado")
                HideLoading -> showToast("Remover loading")
                ShowLoading -> showToast("Mostrar loading")
                ShowSnackBarError -> showSnackBar("Ops... Houve um erro!")
            }
        }

        EventsListViewModel.state.observe(viewLifecycleOwner) {
            when (it) {
                is LoadEventsSuccess -> eventsAdapter.clearAndAdd(it.events)
                LoadEventsFail -> {
                }
            }
        }
    }

    private fun showToast(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
    }

    private fun showSnackBar(text: String) {
        Snackbar.make(requireView(), text, Snackbar.LENGTH_SHORT).show()
    }
}