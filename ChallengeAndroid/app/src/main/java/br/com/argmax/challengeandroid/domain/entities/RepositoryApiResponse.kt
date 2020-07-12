package br.com.argmax.challengeandroid.domain.entities

import java.io.Serializable

class RepositoryApiResponse(
    val items: List<RepositoryDto>?
) : Serializable

class RepositoryDto(
    val name: String?,
    val description: String?,
    val forks_count: Int?,
    val stargazers_count: Int?,
    val owner: UserDto?
) : Serializable

class UserDto(
    val avatar_url: String?,
    val login: String?
) : Serializable