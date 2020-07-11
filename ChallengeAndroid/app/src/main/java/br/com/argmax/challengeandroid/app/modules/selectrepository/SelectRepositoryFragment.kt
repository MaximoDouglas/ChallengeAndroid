package br.com.argmax.challengeandroid.app.modules.selectrepository

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import br.com.argmax.challengeandroid.R
import br.com.argmax.challengeandroid.app.components.dto.RepositoryCardDto
import br.com.argmax.challengeandroid.databinding.SelectRepositoryFragmentBinding

class SelectRepositoryFragment : Fragment() {

    private var mBinding: SelectRepositoryFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.select_repository_fragment,
            container,
            false
        )

        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRepositoryCard()
    }

    private fun setupRepositoryCard() {
        val fakeRepositoryCardDto =
            RepositoryCardDto(
                repositoryName = "Nome repositório",
                repositoryDescription = "Lorem Ipsum is simply dummy text of the printing and " +
                        "typesetting industry. Lorem Ipsum has been the industry's standard dummy " +
                        "text ever since the 1500s, when an unknown printer took a galley of type " +
                        "and scrambled it to make a type specimen book. It has",
                forkQuantity = 640.toString(),
                starsQuantity = 98.toString(),
                userImageUrl = "https://picsum.photos/200",
                userName = "username",
                userFullName = "Nome Sobrenome"
            )

        mBinding?.fakeRepositoryCardComponent?.setRepositoryCardDto(fakeRepositoryCardDto)
    }

}