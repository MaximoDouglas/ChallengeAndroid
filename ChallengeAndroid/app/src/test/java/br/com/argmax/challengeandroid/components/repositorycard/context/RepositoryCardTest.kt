package br.com.argmax.challengeandroid.components.repositorycard.context

import android.app.Activity
import br.com.argmax.challengeandroid.app.components.repositorycard.RepositoryCardComponent
import br.com.argmax.challengeandroid.components.BaseComponentTest

class RepositoryCardTest : BaseComponentTest() {

    companion object {

        private const val REPOSITORY_NAME =
            "Lorem Ipsum is simply dummy text of the printing and typesetting"

        private const val SHORT_REPOSITORY_DESCRIPTION = "industry. Lorem Ipsum has been the"

        private const val LONG_REPOSITORY_DESCRIPTION = "Lorem Ipsum is simply dummy text of the " +
                "printing and typesetting industry. Lorem Ipsum has been the industry's standard " +
                "dummy text ever since the 1500s, when an unknown printer took a galley"

        private const val FORKS_QUANTITY =
            "text ever since the 1500s, when an unknown printer took a galley"

        private const val STARS_QUANTITY =
            "of type and scrambled it to make a type specimen book. It has"

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


}