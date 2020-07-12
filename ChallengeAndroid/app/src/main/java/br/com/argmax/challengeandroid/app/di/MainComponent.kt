package br.com.argmax.challengeandroid.app.di

import br.com.argmax.challengeandroid.MainActivity
import br.com.argmax.challengeandroid.app.modules.selectrepository.SelectRepositoryFragment
import dagger.Subcomponent

@Subcomponent(modules = [MainModule::class])
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainComponent
    }

    fun inject(mainActivity: MainActivity)
    fun inject(selectRepositoryFragment: SelectRepositoryFragment)

}