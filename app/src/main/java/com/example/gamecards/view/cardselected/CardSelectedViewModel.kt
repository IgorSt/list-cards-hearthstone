package com.example.gamecards.view.cardselected


import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamecards.data.domain.model.Card
import com.example.gamecards.data.domain.usescase.CardUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * Igor Santos
 * 25/10/2022
 */

@HiltViewModel
class CardSelectedViewModel @Inject constructor(
    private val useCase: CardUseCase
) : ViewModel(), DefaultLifecycleObserver{

    private val _cardInfos = MutableLiveData<List<Card>>()
    val cardInfos: LiveData<List<Card>> = _cardInfos

    private val _loading = MutableLiveData(true)
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData(false)
    val error: LiveData<Boolean> = _error

    fun getSelectedCard(cardId: String) {
        viewModelScope.launch {
            try {
                val card = useCase.getCardInfos(cardId)
                _cardInfos.value = card
                _loading.value = false
            } catch (e: Exception) {
                _error.value = true
                _loading.value = false
                Timber.e(e)
            }
        }
    }
}