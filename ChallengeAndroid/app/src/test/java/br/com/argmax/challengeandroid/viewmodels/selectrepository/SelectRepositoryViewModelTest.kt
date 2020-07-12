package br.com.argmax.challengeandroid.viewmodels.selectrepository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import br.com.argmax.challengeandroid.app.modules.selectrepository.viewmodels.SelectRepositoryViewModel
import br.com.argmax.challengeandroid.app.modules.selectrepository.viewmodels.SelectRepositoryViewState
import br.com.argmax.challengeandroid.viewmodels.utils.TestContextProvider
import br.com.argmax.challengeandroid.viewmodels.utils.TestCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class SelectRepositoryViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule =
        TestCoroutineRule()

    @Mock
    private lateinit var repositoryRepository: RepositoryRepository

    @Mock
    private lateinit var viewStateObserver: Observer<SelectRepositoryViewState>

    private lateinit var selectRepositoryViewModel: SelectRepositoryViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        selectRepositoryViewModel = SelectRepositoryViewModel(
            repositoryRepository = repositoryRepository,
            contextProvider = TestContextProvider()
        ).apply {
            getStateLiveData().observeForever(viewStateObserver)
        }
    }

    @Test
    fun `should success when fetchFromServer returns proper data`() =
        testCoroutineRule.runBlockingTest {
            //Given
            val data = Any()
            `when`(repositoryRepository.fetchFromServer()).thenReturn(data)

            //When
            selectRepositoryViewModel.getData()

            //Then
            verify(viewStateObserver).onChanged(SelectRepositoryViewState.Loading)
            verify(viewStateObserver).onChanged(SelectRepositoryViewState.Success(data))
        }

}