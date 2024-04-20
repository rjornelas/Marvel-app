package com.rjornelas.core.usecase

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.rjornelas.core.domain.data.repository.CharactersRepository
import com.rjornelas.core.domain.data.repository.StorageRepository
import com.rjornelas.core.domain.usecase.GetCharactersUseCase
import com.rjornelas.core.domain.usecase.GetCharactersUseCaseImpl
import com.rjornelas.testing.MainCoroutineRule
import com.rjornelas.testing.model.CharacterFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class GetCharactersUseCaseImplTest {

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Mock
    lateinit var repository: CharactersRepository

    @Mock
    lateinit var storageRepository: StorageRepository

    private lateinit var getCharactersUseCase: GetCharactersUseCase

    private val hero = CharacterFactory().create(CharacterFactory.Hero.ThreeDMan)

    private val fakePagingData = PagingData.from(listOf(hero))

    @Before
    fun setUp() {
        getCharactersUseCase = GetCharactersUseCaseImpl(repository, storageRepository)
    }

    @Test
    fun `should validate flow paging data creation when invoke from use case is called`() =
        runTest {
            val pagingConfig = PagingConfig(20)
            val orderBy = "ascending"
            val query = "spider"
            whenever(repository.getCachedCharacters(query, orderBy, pagingConfig))
                .thenReturn(flowOf(fakePagingData))

            whenever(storageRepository.sorting)
                .thenReturn(flowOf(orderBy))

            val result = getCharactersUseCase
                .invoke(GetCharactersUseCase.GetCharactersParams(query, pagingConfig))

            verify(repository).getCachedCharacters(query, orderBy, pagingConfig)

            assertNotNull(result.first())
        }
}