package com.example.gamecards.view.factionhorde

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamecards.data.arq.Event
import com.example.gamecards.data.domain.model.Card
import com.example.gamecards.data.domain.repository.CardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * Igor Santos
 * 24/10/2022
 */

@HiltViewModel
class FactionHordeViewModel @Inject constructor(
    private val repository: CardRepository
) : ViewModel(), DefaultLifecycleObserver{

    private val _factionHorde = MutableLiveData<List<Card>>()
    val factionHorde: LiveData<List<Card>> = _factionHorde

    private val _loading = MutableLiveData(true)
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData(false)
    val error: LiveData<Boolean> = _error

    private val _onSelectCard = MutableLiveData<Event<String>>()
    val onSelectCard: LiveData<Event<String>> = _onSelectCard

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        getHorde()
    }

    fun getHorde() = viewModelScope.launch {
        try {
            val horde = repository.getHorde()
            _factionHorde.value = horde
            _loading.value = false
        }catch (e: Exception) {
            _error.value = true
            _loading.value = false
            Timber.e(e)
        }
    }

    fun onClickSelectCard(cardId: String) {
        _onSelectCard.value = Event(cardId)
    }

}