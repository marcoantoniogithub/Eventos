package com.example.eventos.features.eventsList.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.eventos.features.eventsList.domain.usecase.EventsListUseCase
import com.example.eventos.features.eventsList.domain.model.Event
import com.example.eventos.features.eventsList.domain.model.EventsListState
import io.reactivex.disposables.CompositeDisposable

class EventsListViewModel(
    private val useCase: EventsListUseCase
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    val action = MutableLiveData<ViewAction>()
    val state = MutableLiveData<ViewState>()
    private var isLoadMoreLocked = false

    init {
        loadEvents()
    }


    private fun loadEvents() {
        if (isLoadMoreLocked)
            return

        val disposable = useCase.loadEvents()
            .doOnSubscribe { showLoading() }
            .doFinally { hideLoading() }
            .doOnError { onLoadEventsFailure() }
            .subscribe(this::onLoadEventsSuccess)
        compositeDisposable.add(disposable)
    }

    private fun onLoadEventsSuccess(eventState: EventsListState) {
        state.value = when (eventState) {
            is EventsListState.SuccessLoadEvents -> ViewState.LoadEventsSuccess(eventState.events)
            else -> ViewState.LoadEventsFail
        }
    }


    private fun onLoadEventsFailure() {
        ViewAction.ShowSnackBarError
    }

    private fun showLoading() {
        isLoadMoreLocked = true
        action.value = ViewAction.ShowLoading
    }

    private fun hideLoading() {
        isLoadMoreLocked = false
        action.value = ViewAction.HideLoading
    }


    sealed class ViewState {
        class LoadEventsSuccess(val events: List<Event>) : ViewState()
        object LoadEventsFail : ViewState()
    }

    sealed class ViewAction {
        object ShowLoading : ViewAction()
        object HideLoading : ViewAction()
        object CloseKeyboard : ViewAction()
        object ShowSnackBarError : ViewAction()
    }
}