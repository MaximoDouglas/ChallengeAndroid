package br.com.argmax.challengeandroid.domain.entities

import java.io.Serializable

data class GitRepositoryApiResponse(
    val items: List<GitRepositoryDto>
) : Serializable