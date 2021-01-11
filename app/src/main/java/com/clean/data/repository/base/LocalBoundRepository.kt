package com.clean.data.repository.base

import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import com.clean.data.dataSourse.api.response.ApiBaseResponse
import com.clean.data.utils.ResponseResult
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*

@ExperimentalCoroutinesApi
abstract class LocalBoundRepository<RESULT, REQUEST : ApiBaseResponse> : BaseRepository() {

//    fun asFlow() = flow<ResponseResult<RESULT>> {
//
//        // Emit Loading State
////        emit(ResponseResult.Loading)
//
//        // Emit Database content first
//        emit(ResponseResult.Success(response = fetchFromLocal().first()))
//
//        // Fetch latest posts from remote
//        val apiResponse = fetchFromRemote()
//
//        // Parse body
//        val responseBody = apiResponse.body()
//
//        // Check for response validation
//        if (apiResponse.isSuccessful && responseBody != null) {
//
//            // Save posts into the persistence storage
//            if(responseBody.success == true)
//                saveRemoteData(responseBody)
//            else
//                emit(onErrorResponse(responseBody))
//        } else {
//            // Something went wrong! Emit Error state.
//            emit(unSuccessResponse(apiResponse.errorBody(), apiResponse.code()))
//        }
//
//        // Retrieve posts from persistence storage and emit
//        emitAll(fetchFromLocal().map {
//            ResponseResult.Success(response = it)
//        })
//
//    }.catch { e ->
//        emit(errorResponse(e))
//    }


    fun getFlow() = flow<ResponseResult<RESULT>> {

        // Emit Loading State
//        emit(ResponseResult.Loading)

        emit(ResponseResult.Success(response = fetchFromLocal().first()))

        val responseBody = fetchFromRemote()

        if (responseBody.errors == null)
            saveRemoteData(responseBody)
        else
            emit(unSuccessResponse2(responseBody))


        emitAll(fetchFromLocal().map {
            ResponseResult.Success(response = it)
        })

    }.catch { e ->
        e.printStackTrace()
        emit(errorResponse(e))
    }


    @WorkerThread
    protected abstract suspend fun saveRemoteData(response: REQUEST)

    @MainThread
    protected abstract fun fetchFromLocal(): Flow<RESULT>

    @MainThread
    protected abstract suspend fun fetchFromRemote():  REQUEST //Response<REQUEST>
}