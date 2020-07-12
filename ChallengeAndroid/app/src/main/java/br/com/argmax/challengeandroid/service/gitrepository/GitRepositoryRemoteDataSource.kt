package br.com.argmax.challengeandroid.service.gitrepository

import br.com.argmax.challengeandroid.domain.entities.GitRepositoryApiResponse
import br.com.argmax.challengeandroid.service.BaseRemoteDataSourceCallback.RemoteDataSourceCallback

interface GitRepositoryRemoteDataSource {

    fun getGitRepositories(
        page: Int,
        callback: RemoteDataSourceCallback<GitRepositoryApiResponse>
    )

}
