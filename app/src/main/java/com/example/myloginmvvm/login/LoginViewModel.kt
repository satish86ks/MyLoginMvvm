package com.example.myloginmvvm.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myloginmvvm.data.UserRes
import com.example.myloginmvvm.data.UserResponse
import com.example.myloginmvvm.remote.interfaces.Api
import com.example.myloginmvvm.remote.repository.DataListSource
import com.example.myloginmvvm.remote.repository.NavState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import java.io.IOException
import java.net.SocketException
import java.net.SocketTimeoutException
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    val listSource: DataListSource,
    val api: Api
) : ViewModel() {

    private val _navigation = MutableLiveData<NavState>(NavState.Loading)
    val navigation: LiveData<NavState> = _navigation

    private val _user = MutableLiveData<UserRes>()
    val user: LiveData<UserRes> = _user

    var token="dds"

    fun getLoginDetails(userId:String,password:String) {

        viewModelScope.launch {
            try {
                listSource.getLoginDetails(token, userId, password)
                    .catch {
                        _navigation.postValue(NavState.Failed(message = it.message))
                    }.collect {
                        it.data.let {
                            _user.postValue(it)
                        }
                    }

            }catch (e:SocketException){
             _navigation.postValue(NavState.Failed(message = "Socket"))
             e.printStackTrace()
            }catch (e: SocketTimeoutException) {
                _navigation.postValue(NavState.Failed(message = "Socket"))
                e.printStackTrace()
            } catch (e: IOException) {
                _navigation.postValue(NavState.Failed(message = e.message))
                e.printStackTrace()
            } catch (e: Exception) {
                _navigation.postValue(NavState.Failed(message = e.message))
                e.printStackTrace()
            }
        }
    }

}