package com.example.marvelapp.presentation.characters

import androidx.paging.PagingData
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import com.rjornelas.core.domain.model.Character
import com.rjornelas.core.usecase.GetCharactersUseCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CharactersViewModelTest {

    @ExperimentalCoroutinesApi
    val testDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()

    private lateinit var charactersViewModel: CharactersViewModel

    @Mock
    lateinit var getCharactersUseCase: GetCharactersUseCase

    private val pagingDataCharacters = PagingData.from(
        listOf(
            Character(
                "3-D Man",
                "image.jpg"
            ),
            Character(
                "A-Bomb (HAS)",
                "image2.jpg"
            )
        )
    )

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        charactersViewModel = CharactersViewModel(getCharactersUseCase)
    }

    @Test
    @ExperimentalCoroutinesApi
    fun `should validate the paging data object values when calling charactersPagingData`() =
        runBlockingTest {
            whenever(
                getCharactersUseCase.invoke(any())
            ).thenReturn(
                flowOf(pagingDataCharacters)
            )

            val result = charactersViewModel.charactersPagingData("")
            assertEquals(1, result.count())
        }

    @Test(expected = RuntimeException::class)
    @ExperimentalCoroutinesApi
    fun `should throw an exception when the calling to the use case return an exception`() =
        runBlockingTest {
            whenever(getCharactersUseCase.invoke(any())).thenThrow(RuntimeException())
            charactersViewModel.charactersPagingData("")
        }

    @Test
    @ExperimentalCoroutinesApi
    fun tearDownDispatcher() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}