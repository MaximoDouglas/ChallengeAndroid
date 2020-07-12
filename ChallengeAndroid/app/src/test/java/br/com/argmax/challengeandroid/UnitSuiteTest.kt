package br.com.argmax.challengeandroid

import br.com.argmax.challengeandroid.components.ComponentSuiteTest
import br.com.argmax.challengeandroid.viewmodels.ViewModelSuiteTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.runner.RunWith
import org.junit.runners.Suite

@ExperimentalCoroutinesApi
@RunWith(Suite::class)
@Suite.SuiteClasses(
    ComponentSuiteTest::class,
    ViewModelSuiteTest::class
)
class UnitSuiteTest