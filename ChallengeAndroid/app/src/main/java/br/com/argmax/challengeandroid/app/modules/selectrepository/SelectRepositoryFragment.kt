package br.com.argmax.challengeandroid.app.modules.selectrepository

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import br.com.argmax.challengeandroid.R
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

}