package com.example.hilt.data

import com.example.hilt.http.HttpApi
import com.example.hilt.repository.IRepository
import timber.log.Timber

/**
 *company：成都标学科技有限公司
 *date：2021/10/14 下午2:53
 *coder：gzq
 *email：guozhiqiang@zlketang.com
 *description:
 */

class RepositoryImp(private val httpApi: HttpApi) : IRepository {
    override suspend fun getContent(): String? {
        Timber.d("当前进程：%s", Thread.currentThread().name)
        return httpApi.fetchBaidu().string()
    }
}