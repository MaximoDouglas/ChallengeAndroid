package br.com.argmax.challengeandroid.app.modules.selectrepository.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.argmax.challengeandroid.domain.entities.RepositoryDto
import br.com.argmax.challengeandroid.service.repository.RepositoryRepository
import br.com.argmax.challengeandroid.utils.viewmodels.CoroutineContextProvider
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SelectRepositoryViewModel @Inject constructor(
    private val repositoryRepository: RepositoryRepository,
    private val contextProvider: CoroutineContextProvider
) : ViewModel() {

    private val handler = CoroutineExceptionHandler { _, throwable ->
        _stateLiveData.value = SelectRepositoryViewState.Error(throwable)
    }

    private val _stateLiveData = MutableLiveData<SelectRepositoryViewState>()

    val stateLiveData: LiveData<SelectRepositoryViewState> get() = _stateLiveData

    fun getData() {
        _stateLiveData.value = SelectRepositoryViewState.Loading
        viewModelScope.launch(handler) {
            val data = withContext(contextProvider.IO) {
                repositoryRepository.fetchFromServer()
            }

            _stateLiveData.value = SelectRepositoryViewState.Success(data)
        }
    }

}

sealed class SelectRepositoryViewState {

    object Loading : SelectRepositoryViewState()
    data class Error(val throwable: Throwable) : SelectRepositoryViewState()
    data class Success(val data: List<RepositoryDto>) : SelectRepositoryViewState()

}
