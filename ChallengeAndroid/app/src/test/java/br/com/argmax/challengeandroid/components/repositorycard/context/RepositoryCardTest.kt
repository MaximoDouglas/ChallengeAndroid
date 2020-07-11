package br.com.argmax.challengeandroid.components.repositorycard.context

import android.app.Activity
import br.com.argmax.challengeandroid.app.components.repositorycard.RepositoryCardComponent
import br.com.argmax.challengeandroid.app.components.repositorycard.dto.RepositoryCardDto
import br.com.argmax.challengeandroid.components.BaseComponentTest

class RepositoryCardTest : BaseComponentTest() {

    companion object {

        private const val REPOSITORY_NAME =
            "Lorem Ipsum is simply dummy text of the printing and typesetting"

        private const val SHORT_REPOSITORY_DESCRIPTION = "industry. Lorem Ipsum has been the"

        private const val LONG_REPOSITORY_DESCRIPTION = "Lorem Ipsum is simply dummy text of the " +
                "printing and typesetting industry. Lorem Ipsum has been the industry's standard " +
                "dummy text ever since the 1500s, when an unknown printer took a galley"

        private const val FORKS_QUANTITY = 640

        private const val STARS_QUANTITY = 98

        private const val USER_IMAGE_URL = "https://picsum.photos/200"

        private const val USER_NAME =
            "survived not only five centuries, but also the leap into electronic"

        private const val USER_FULL_NAME =
            "typesetting, remaining essentially unchanged. It was popularised in"

    }

    private var mRepositoryCardComponent: RepositoryCardComponent? = null

    override fun setupComponent(activity: Activity) {
        mRepositoryCardComponent = RepositoryCardComponent(activity)
    }

    fun `when it has short description`() {
        val forksQuantityAsString = FORKS_QUANTITY.toString()
        val starsQuantityAsString = STARS_QUANTITY.toString()

        val repositoryCardDto = RepositoryCardDto(
            repositoryName = REPOSITORY_NAME,
            repositoryDescription = SHORT_REPOSITORY_DESCRIPTION,
            forkQuantity = forksQuantityAsString,
            starsQuantity = starsQuantityAsString,
            userImageUrl = USER_IMAGE_URL,
            userName = USER_NAME,
            userFullName = USER_FULL_NAME
        )
        mRepositoryCardComponent?.setRepositoryCardDto(repositoryCardDto)
    }

    fun `when it has long description`() {
        val forksQuantityAsString = FORKS_QUANTITY.toString()
        val starsQuantityAsString = STARS_QUANTITY.toString()

        val repositoryCardDto = RepositoryCardDto(
            repositoryName = REPOSITORY_NAME,
            repositoryDescription = LONG_REPOSITORY_DESCRIPTION,
            forkQuantity = forksQuantityAsString,
            starsQuantity = starsQuantityAsString,
            userImageUrl = USER_IMAGE_URL,
            userName = USER_NAME,
            userFullName = USER_FULL_NAME
        )
        mRepositoryCardComponent?.setRepositoryCardDto(repositoryCardDto)
    }

}