package br.com.argmax.challengeandroid.components.repositorycard.context

import android.app.Activity
import android.view.View
import br.com.argmax.challengeandroid.app.components.repositorycard.RepositoryCardComponent
import br.com.argmax.challengeandroid.app.components.repositorycard.dto.RepositoryCardDto
import br.com.argmax.challengeandroid.components.BaseComponentTest
import br.com.argmax.challengeandroid.utils.stringutils.compactStringWithDots
import kotlinx.android.synthetic.main.repository_card_component.view.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue

open class RepositoryCardTest : BaseComponentTest() {

    companion object {

        private const val REPOSITORY_NAME =
            "Lorem Ipsum is simply dummy text of the printing and typesetting"

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

    fun `when repository card has all data`() {
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

    fun `assert that repository name is visible`() {
        assertTrue(mRepositoryCardComponent?.repository_card_repository_name_text_view?.visibility == View.VISIBLE)
    }

    fun `assert that repository name is set correctly`() {
        assertEquals(
            REPOSITORY_NAME,
            mRepositoryCardComponent?.repository_card_repository_name_text_view?.text.toString()
        )
    }

    fun `assert that repository description is visible`() {
        assertTrue(mRepositoryCardComponent?.repository_card_repository_description_text_view?.visibility == View.VISIBLE)
    }

    fun `assert that repository description is set correctly`() {
        val maxLengthDescription = 60
        val shortString = compactStringWithDots(LONG_REPOSITORY_DESCRIPTION, maxLengthDescription)

        assertEquals(
            shortString,
            mRepositoryCardComponent?.repository_card_repository_name_text_view?.text.toString()
        )
    }

    fun `assert that repository stars quantity label is visible`() {
        assertTrue(mRepositoryCardComponent?.repository_card_repository_stars_text_view?.visibility == View.VISIBLE)
    }

    fun `assert that repository stars quantity label is set correctly`() {
        assertEquals(
            STARS_QUANTITY,
            mRepositoryCardComponent?.repository_card_repository_stars_text_view?.text.toString()
        )
    }

    fun `assert that repository forks quantity label is visible`() {
        assertTrue(mRepositoryCardComponent?.repository_card_repository_forks_text_view?.visibility == View.VISIBLE)
    }

    fun `assert that repository forks quantity label is set correctly`() {
        assertEquals(
            STARS_QUANTITY,
            mRepositoryCardComponent?.repository_card_repository_forks_text_view?.text.toString()
        )
    }

    fun `assert that user image is visible`() {
        assertTrue(mRepositoryCardComponent?.repository_card_user_image_image_view?.visibility == View.VISIBLE)
    }

    fun `assert that user name is visible`() {
        assertTrue(mRepositoryCardComponent?.repository_card_user_name_text_view?.visibility == View.VISIBLE)
    }

    fun `assert that user name is set correctly`() {
        assertEquals(
            USER_NAME,
            mRepositoryCardComponent?.repository_card_user_name_text_view?.text.toString()
        )
    }

    fun `assert that user full name is visible`() {
        assertTrue(mRepositoryCardComponent?.repository_card_user_full_name_text_view?.visibility == View.VISIBLE)
    }

    fun `assert that user full name is set correctly`() {
        assertEquals(
            USER_FULL_NAME,
            mRepositoryCardComponent?.repository_card_user_full_name_text_view?.text.toString()
        )
    }

}