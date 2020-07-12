package br.com.argmax.challengeandroid.service.repository

import br.com.argmax.challengeandroid.service.CoroutineScopeContext
import kotlinx.coroutines.launch
import retrofit2.await
import javax.inject.Inject

class RepositoryRepository @Inject constructor(
    private val mRepositoryService: RepositoryService
) : CoroutineScopeContext() {

    suspend fun fetchFromServer() {
       launch {
            val data = mRepositoryService.getAll(page = 1).await().items ?: listOf()

        }
    }
}
