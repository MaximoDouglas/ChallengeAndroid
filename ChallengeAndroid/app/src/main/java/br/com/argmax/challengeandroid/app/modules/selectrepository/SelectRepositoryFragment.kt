package br.com.argmax.challengeandroid.app.modules.selectrepository

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.argmax.challengeandroid.R
import br.com.argmax.challengeandroid.app.modules.selectrepository.adapters.SelectRepositoryAdapter
import br.com.argmax.challengeandroid.app.modules.selectrepository.viewmodels.SelectRepositoryViewModel
import br.com.argmax.challengeandroid.app.modules.selectrepository.viewmodels.SelectRepositoryViewModelFactory
import br.com.argmax.challengeandroid.app.modules.selectrepository.viewmodels.SelectRepositoryViewState
import br.com.argmax.challengeandroid.databinding.SelectRepositoryFragmentBinding
import br.com.argmax.challengeandroid.domain.entities.GitRepositoryDto

class SelectRepositoryFragment : Fragment() {

    private var mViewModel: SelectRepositoryViewModel? = null
    private var mBinding: SelectRepositoryFragmentBinding? = null
    private var mAdapter: SelectRepositoryAdapter? = SelectRepositoryAdapter()

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

        context?.let {
            mViewModel =
                ViewModelProvider(
                    this,
                    SelectRepositoryViewModelFactory(it)
                ).get(
                    SelectRepositoryViewModel::class.java
                )
        }

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        mBinding?.selectRepositoryFragmentRecyclerView?.layoutManager = linearLayoutManager

        mBinding?.selectRepositoryFragmentRecyclerView?.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )

        mBinding?.selectRepositoryFragmentRecyclerView?.adapter = mAdapter
    }

}