package br.com.argmax.challengeandroid.app.components.repositorycard

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import br.com.argmax.challengeandroid.R
import br.com.argmax.challengeandroid.app.components.repositorycard.dto.RepositoryCardDto
import br.com.argmax.challengeandroid.databinding.RepositoryCardComponentBinding

class RepositoryCardComponent @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private var mBinding: RepositoryCardComponentBinding? =
        DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.repository_card_component,
            this,
            true
        )

    fun setRepositoryCardDto(
        repositoryCardDto: RepositoryCardDto
    ) {
        mBinding?.repositoryCardDto = repositoryCardDto
        mBinding?.executePendingBindings()
    }

}