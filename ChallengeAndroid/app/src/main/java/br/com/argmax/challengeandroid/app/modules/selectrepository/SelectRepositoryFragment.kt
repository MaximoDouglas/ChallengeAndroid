package br.com.argmax.challengeandroid.app.modules.selectrepository

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.argmax.challengeandroid.MainActivity
import br.com.argmax.challengeandroid.R
import br.com.argmax.challengeandroid.app.modules.selectrepository.adapters.SelectRepositoryAdapter
import br.com.argmax.challengeandroid.app.modules.selectrepository.viewmodels.SelectRepositoryViewModel
import br.com.argmax.challengeandroid.app.modules.selectrepository.viewmodels.SelectRepositoryViewState
import br.com.argmax.challengeandroid.databinding.SelectRepositoryFragmentBinding
import javax.inject.Inject

class SelectRepositoryFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val mViewModel by viewModels<SelectRepositoryViewModel> { viewModelFactory }

    private var mBinding: SelectRepositoryFragmentBinding? = null
    private var mAdapter: SelectRepositoryAdapter? = SelectRepositoryAdapter()

    private val navController: NavController by lazy {
        findNavController()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity() as MainActivity).mainComponent.inject(this)
    }

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

        setupRecyclerView()
        listenToStateLiveDataEvent()
        mViewModel.getData()
    }

    private fun setupRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        mBinding?.selectRepositoryFragmentRecyclerView?.layoutManager = linearLayoutManager

        mBinding?.selectRepositoryFragmentRecyclerView?.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )

        mBinding?.selectRepositoryFragmentRecyclerView?.adapter = mAdapter
    }

    private fun listenToStateLiveDataEvent() {
        mViewModel.stateLiveData.observe(viewLifecycleOwner, Observer { registrationState ->
            when (registrationState) {
                is SelectRepositoryViewState.Loading -> {

                }
                is SelectRepositoryViewState.Success -> {
                    val data = registrationState.data
                }
                is SelectRepositoryViewState.Error -> {

                }
            }
        })
    }

}