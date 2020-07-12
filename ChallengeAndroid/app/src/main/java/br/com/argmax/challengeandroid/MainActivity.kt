package br.com.argmax.challengeandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import br.com.argmax.challengeandroid.app.di.MainComponent

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    lateinit var mainComponent: MainComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        mainComponent =
            (applicationContext as ChallengeAndroidApp).mAppComponent.mainComponent().create()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.navHostFragment)
    }
}