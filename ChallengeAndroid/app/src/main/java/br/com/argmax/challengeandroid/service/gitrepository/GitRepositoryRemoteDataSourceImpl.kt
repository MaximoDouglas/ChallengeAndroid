package br.com.argmax.challengeandroid.service.gitrepository

import android.annotation.SuppressLint
import androidx.annotation.NonNull
import br.com.argmax.challengeandroid.domain.entities.GitRepositoryApiResponse
import br.com.argmax.challengeandroid.service.BaseRemoteDataSourceCallback.RemoteDataSourceCallback
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GitRepositoryRemoteDataSourceImpl(
    private val mGitRepositoryApiDataSource: GitRepositoryApiDataSource
) : GitRepositoryRemoteDataSource {

    companion object {

        @Volatile
        private var INSTANCE: GitRepositoryRemoteDataSourceImpl? = null

        fun getInstance(@NonNull repositoryApiDataSource: GitRepositoryApiDataSource): GitRepositoryRemoteDataSourceImpl =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: GitRepositoryRemoteDataSourceImpl(repositoryApiDataSource).also {
                    INSTANCE = it
                }
            }
    }

    @SuppressLint("CheckResult")
    override fun getGitRepositories(
        page: Int,
        callback: RemoteDataSourceCallback<GitRepositoryApiResponse>
    ) {
        mGitRepositoryApiDataSource.getGitRepositories(
            page = page
        ).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { callback.isLoading(true) }
            .doAfterTerminate { callback.isLoading(false) }
            .subscribe(
                { response ->
                    callback.onSuccess(response)
                },
                { throwable ->
                    callback.onError(throwable.localizedMessage)
                }
            )
    }


}