package com.rjornelas.marvelapp.presentation.characters

import androidx.paging.PagingData
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import com.rjornelas.core.usecase.GetCharactersUseCase
import com.rjornelas.testing.MainCoroutineRule
import com.rjornelas.testing.model.CharacterFactory
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CharactersViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutinesRule = MainCoroutineRule()

    private lateinit var charactersViewModel: CharactersViewModel

    private val charactersFactory = CharacterFactory()

    @Mock
    lateinit var getCharactersUseCase: GetCharactersUseCase

    private val pagingDataCharacters = PagingData.from(
        listOf(
            charactersFactory.create(CharacterFactory.Hero.ABomb),
            charactersFactory.create(CharacterFactory.Hero.ThreeDMan)
        )
    )

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
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
}