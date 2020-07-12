package br.com.argmax.challengeandroid.service

class BaseRemoteDataSourceCallback {

    interface RemoteDataSourceCallback<T> {
        fun onSuccess(response: T)
        fun onError(errorMessage: String)
        fun isLoading(isLoading: Boolean)
    }

    interface VoidRemoteDataSourceCallback {
        fun onSuccess()
        fun onError(errorMessage: String)
        fun isLoading(isLoading: Boolean)
    }
}