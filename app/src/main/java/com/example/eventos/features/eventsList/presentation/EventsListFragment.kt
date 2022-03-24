package com.example.eventos.features.eventsList.presentation

import android.widget.Toast
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import com.example.eventos.features.eventsList.domain.model.Event
import com.example.eventos.features.eventsList.presentation.di.EventsListPresentationFactory
import com.example.eventos.common.base.BaseFragment
import com.example.eventos.R
import com.example.eventos.databinding.FragmentEventsListBinding
import com.google.android.material.snackbar.Snackbar

class EventsListFragment : BaseFragment<FragmentEventsListBinding>() {

    private val viewModelEvents: EventsListViewModel =
        EventsListPresentationFactory.provideListEventsViewModel() // TODO usar o ViewModelProviders depois
    private lateinit var eventsAdapter: EventAdapter

    override fun getLayout() = R.layout.fragment_events_list

    override fun initBinding() {
        binding.viewModel = viewModelEvents

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
        viewModelEvents.action.observe(viewLifecycleOwner) {
            when (it) {
                EventsListViewModel.ViewAction.CloseKeyboard -> showToast("Fechar teclado")
                EventsListViewModel.ViewAction.HideLoading -> showToast("Remover loading")
                EventsListViewModel.ViewAction.ShowLoading -> showToast("Mostrar loading")
                EventsListViewModel.ViewAction.ShowSnackBarError -> showSnackBar("Ops... Houve um erro!")
            }
        }

        viewModelEvents.state.observe(viewLifecycleOwner) {
            when (it) {
                is EventsListViewModel.ViewState.LoadEventsSuccess -> eventsAdapter.clearAndAdd(it.events)
                EventsListViewModel.ViewState.LoadEventsFail -> { }
            }
        }
    }

    private fun showToast(text: String) {
        Toast.makeText(requireContext(),text,Toast.LENGTH_SHORT).show()
    }

    private fun showSnackBar(text: String) {
        Snackbar.make(requireView(), text, Snackbar.LENGTH_SHORT).show()
    }
}