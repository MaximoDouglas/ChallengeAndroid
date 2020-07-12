package br.com.argmax.challengeandroid.app.modules.selectrepository.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.argmax.challengeandroid.app.injections.InjectionUseCase.provideGetRepositoryUseCase
import br.com.argmax.challengeandroid.domain.entities.GitRepositoryDto
import br.com.argmax.challengeandroid.domain.usecases.GetGitRepositoryUseCase

class SelectRepositoryViewModel(
    private val getRepositoryUseCase: GetGitRepositoryUseCase = provideGetRepositoryUseCase()
) : ViewModel() {
    fun getGitRepository() {

    }
}

sealed class SelectRepositoryViewState {

    object Loading : SelectRepositoryViewState()
    data class Error(val errorMessage: String) : SelectRepositoryViewState()
    data class Success(val data: List<GitRepositoryDto>) : SelectRepositoryViewState()

}

/*class SelectRepositoryViewModelFactory(private val context: Context) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SelectRepositoryViewModel(context) as T
    }
}*/


