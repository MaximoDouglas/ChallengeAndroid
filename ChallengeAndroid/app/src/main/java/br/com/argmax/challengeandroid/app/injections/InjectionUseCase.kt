package br.com.argmax.challengeandroid.app.injections

import br.com.argmax.challengeandroid.app.injections.InjectionRemoteDataSource.provideRepositoryRemoteDataSource
import br.com.argmax.challengeandroid.domain.usecases.GetGitRepositoryUseCase

object InjectionUseCase {

    fun provideGetRepositoryUseCase(): GetGitRepositoryUseCase {
        return GetGitRepositoryUseCase(provideRepositoryRemoteDataSource())
    }


}