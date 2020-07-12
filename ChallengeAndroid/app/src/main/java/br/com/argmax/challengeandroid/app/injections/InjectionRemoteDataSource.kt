package br.com.argmax.challengeandroid.app.injections

import br.com.argmax.challengeandroid.app.injections.InjectionApiDataSource.provideRepositoryApiDataSource
import br.com.argmax.challengeandroid.service.gitrepository.GitRepositoryRemoteDataSource
import br.com.argmax.challengeandroid.service.gitrepository.GitRepositoryRemoteDataSourceImpl

object InjectionRemoteDataSource {

    fun provideRepositoryRemoteDataSource(): GitRepositoryRemoteDataSource {
        return GitRepositoryRemoteDataSourceImpl.getInstance(provideRepositoryApiDataSource())
    }


}