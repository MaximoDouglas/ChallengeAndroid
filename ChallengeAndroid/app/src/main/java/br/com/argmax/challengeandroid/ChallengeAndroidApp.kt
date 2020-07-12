package br.com.argmax.challengeandroid

import android.app.Application
import br.com.argmax.challengeandroid.di.ApplicationComponent
import br.com.argmax.challengeandroid.di.DaggerApplicationComponent

class ChallengeAndroidApp : Application() {

    lateinit var mAppComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        mAppComponent = DaggerApplicationComponent.factory().create(this)
    }
}