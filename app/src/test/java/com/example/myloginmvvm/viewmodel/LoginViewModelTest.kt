package com.example.myloginmvvm.viewmodel

import com.example.myloginmvvm.CoroutineTestRule
import com.example.myloginmvvm.login.LoginViewModel
import com.example.myloginmvvm.remote.interfaces.Api
import com.example.myloginmvvm.remote.repository.DataListSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class LoginViewModelTest {


    @get:Rule
    val testCoroutineRule = CoroutineTestRule()


    @Mock
    private lateinit var apiClient: Api

    @Mock
    private lateinit var listDataSource: DataListSource

    private lateinit var viewModel: LoginViewModel

    @Before
    fun setup() {
        viewModel = LoginViewModel(listDataSource, apiClient)
    }

    @Test
    fun `viewModel should not null`() {
        Assert.assertNotNull(viewModel)
        Assert.assertEquals(apiClient, viewModel.api)
        Assert.assertEquals(viewModel.listSource, viewModel.listSource)
    }

}