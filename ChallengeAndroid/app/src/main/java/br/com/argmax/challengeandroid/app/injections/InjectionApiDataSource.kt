package br.com.argmax.challengeandroid.app.injections

import br.com.argmax.challengeandroid.service.ApiDataSource.Companion.createService
import br.com.argmax.challengeandroid.service.gitrepository.GitRepositoryApiDataSource

object InjectionApiDataSource {

    fun provideRepositoryApiDataSource(): GitRepositoryApiDataSource {
        return createService(GitRepositoryApiDataSource::class.java)
    }


}