package br.com.argmax.challengeandroid.app.di

import androidx.lifecycle.ViewModel
import br.com.argmax.challengeandroid.app.modules.selectrepository.viewmodels.SelectRepositoryViewModel
import br.com.argmax.challengeandroid.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(SelectRepositoryViewModel::class)
    fun bindSelectRepositoryViewModel(viewModel: SelectRepositoryViewModel): ViewModel

}