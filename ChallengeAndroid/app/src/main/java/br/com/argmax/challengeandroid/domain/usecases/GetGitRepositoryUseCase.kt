package br.com.argmax.challengeandroid.domain.usecases

import br.com.argmax.challengeandroid.domain.entities.GitRepositoryApiResponse
import br.com.argmax.challengeandroid.service.BaseRemoteDataSourceCallback.RemoteDataSourceCallback
import br.com.argmax.challengeandroid.service.gitrepository.GitRepositoryRemoteDataSource

class GetGitRepositoryUseCase(private val mGitRepositoryRemoteDataSource: GitRepositoryRemoteDataSource) {

    fun getGitRepositoryPage(
        page: Int,
        callback: RemoteDataSourceCallback<GitRepositoryApiResponse>
    ) {
        mGitRepositoryRemoteDataSource.getGitRepositories(page = page, callback = callback)
    }

}