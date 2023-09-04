package com.example.myloginmvvm.remote.repository

import com.example.myloginmvvm.data.UserListResponse
import com.example.myloginmvvm.data.UserRes
import com.example.myloginmvvm.data.UserResponse
import com.example.myloginmvvm.remote.interfaces.Api
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Header
import java.io.IOException
import java.net.SocketException
import java.net.SocketTimeoutException
import javax.inject.Inject


class DataListSource @Inject constructor(
   val service: Api
) {

   companion object {
      const val CONTENT_TYPE = "application/json"
   }


   fun getLoginDetails(token:String,
                       userId: String,
                       password: String
   ): Flow<ResultApiState<UserRes>> {

      return flow {

         try {
            val mresponse = service.getProfileDetails("Bearer $token", userId, password)
            if (mresponse.isSuccessful) {
               val response = mresponse.body()!!
               emit(ResultApiState.success(response))
            } else {
               val errorMsg = mresponse.errorBody()?.string()
               mresponse.errorBody()?.close()
               throw Error(errorMsg)
            }
         } catch (e: SocketException) {
            throw Error("Socket")
         } catch (e: SocketTimeoutException) {
            throw Error("Socket")
         } catch (e: IOException) {
            throw Error(e.message)
         } catch (e: Exception) {
            throw Error(e.message)
         }

      }.flowOn(Dispatchers.IO)

   }

   fun getUserDetails(token: String): Flow<ResultApiState<UserListResponse>>{

      return  flow<ResultApiState<UserListResponse>> {
         try {

            val mresponse=service.getUserDetails("Bearer $token")
            if(mresponse.isSuccessful){
               val response=mresponse.body()!!
               emit(ResultApiState.success(response))
            }else{
               val errorMsg = mresponse.errorBody()?.string()
               mresponse.errorBody()?.close()
               throw Error(errorMsg)
            }

         }catch (e:SocketException){
            throw  Error("Socket")
         }catch (e:SocketTimeoutException){
            throw  Error("Socket")
         }catch (e:IOException){
            throw  Error(e.message)
         }catch (e:java.lang.Exception){
            throw  Error(e.message)
         }

      }.flowOn(Dispatchers.IO)
   }




}

