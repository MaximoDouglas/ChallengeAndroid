package br.com.argmax.challengeandroid.components.repositorycard

import br.com.argmax.challengeandroid.components.repositorycard.context.*
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    RepositoryCardRepositoryNameTest::class,
    RepositoryCardRepositoryDescriptionTest::class,
    RepositoryCardRepositoryStarsTest::class,
    RepositoryCardRepositoryForksTest::class,
    RepositoryCardUserImageTest::class,
    RepositoryCardUserNameTest::class,
    RepositoryCardUserFullNameTest::class
)
class RepositoryCardSuiteTest