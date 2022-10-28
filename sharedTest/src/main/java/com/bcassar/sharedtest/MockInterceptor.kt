package com.bcassar.sharedtest

import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

/**
 * Created by bcassar on 27/10/2022
 */
class MockInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if (chain.request().url.toUri().toString().contains("scoreboardv3")) {
            val responseString = scoreboardResponse
            return Response.Builder()
                .request(chain.request())
                .protocol(Protocol.HTTP_2)
                .code(200)
                .message(responseString)
                .body(
                    responseString
                        .toByteArray()
                        .toResponseBody(
                            "application/json".toMediaTypeOrNull()
                        )
                )
                .build()
        } else {
            //Skip the interception.
            return chain.proceed(chain.request())
        }
    }
}