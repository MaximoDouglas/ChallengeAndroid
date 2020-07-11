package br.com.argmax.challengeandroid.app.components.repositorycard.dto

import br.com.argmax.challengeandroid.utils.stringutils.compactStringWithDots

class RepositoryCardDto(
    val repositoryName: String,
    private val repositoryDescription: String,
    val forkQuantity: String,
    val starsQuantity: String,
    val userImageUrl: String,
    val userName: String,
    val userFullName: String
) {
    fun getRepositoryDescription(): String {
        return compactStringWithDots(repositoryDescription, 60)
    }
}