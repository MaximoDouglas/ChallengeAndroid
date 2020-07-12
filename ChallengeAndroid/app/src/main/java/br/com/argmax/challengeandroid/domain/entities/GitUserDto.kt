package br.com.argmax.challengeandroid.domain.entities

import java.io.Serializable

data class GitUserDto(
    val avatar_url: String,
    val login: String
) : Serializable