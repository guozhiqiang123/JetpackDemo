package com.example.hilt.http

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

/**
 *company：成都标学科技有限公司
 *date：2021/10/14 下午2:44
 *coder：gzq
 *email：guozhiqiang@zlketang.com
 *description:
 */

interface HttpApi {
    @GET("/wxarticle/chapters/json")
    suspend fun fetchBaidu(): ResponseBody
}