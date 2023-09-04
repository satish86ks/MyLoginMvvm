package com.example.myloginmvvm.remote.repository

import com.example.myloginmvvm.BuildConfig
import com.example.myloginmvvm.remote.interfaces.Api
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Collections
import java.util.concurrent.TimeUnit

open class ApiClient {

companion object{

  private var interceptor= intercept()

 private fun intercept(): HttpLoggingInterceptor{
     var interceptors= HttpLoggingInterceptor()
     interceptors.level=HttpLoggingInterceptor.Level.BODY
     interceptor =interceptors
     return interceptor
 }

    private val okHttpClient=OkHttpClient.Builder()
        .connectTimeout(10,TimeUnit.SECONDS)
        .readTimeout(10,TimeUnit.SECONDS)
        .protocols(Collections.singletonList(Protocol.HTTP_1_1))

    fun buildService(): Api {

          if(BuildConfig.DEBUG){
              okHttpClient.addInterceptor(interceptor)
          }


       okHttpClient.addInterceptor(interceptor)
        val client= okHttpClient.build()
        val  retrofit=Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(Api::class.java)
        interceptor.level=HttpLoggingInterceptor.Level.BODY
        return retrofit
    }

}


}