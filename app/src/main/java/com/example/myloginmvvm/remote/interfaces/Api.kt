package com.example.myloginmvvm.remote.interfaces

import com.example.myloginmvvm.data.UserListResponse
import com.example.myloginmvvm.data.UserRes
import com.example.myloginmvvm.data.UserResponse
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.Header
import retrofit2.http.Query

interface Api {

    @GET("api/login/2")
    suspend fun getProfileDetails(
        @Header("Authorization") code: String,
        @Query("email") email: String,
        @Query("password") password: String
    ): Response<UserRes>

    @GET("api/unknown")
    suspend fun getUserDetails(
        @Header("Authorization") code: String
    ): Response<UserListResponse>



    @HTTP(method = "DELETE", path = "agenda/digitalinventory/api/v1/images/upload", hasBody = true)
    fun deleteImage(
        @Header("Authorization") code: String,
        @Body requestBody: RequestBody?
    ): Call<ResponseBody>?


}