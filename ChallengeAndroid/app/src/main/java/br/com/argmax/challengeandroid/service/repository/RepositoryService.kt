package br.com.argmax.challengeandroid.service.repository

import br.com.argmax.challengeandroid.domain.entities.RepositoryApiResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RepositoryService {

    @GET("search/repositories")
    fun getAll(
        @Query("q") q: String = "language:Java",
        @Query("sort") sort: String = "stars",
        @Query("page") page: Int
    ): Observable<RepositoryApiResponse>

}
