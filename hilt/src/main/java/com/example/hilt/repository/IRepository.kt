package com.example.hilt.repository

/**
 *company：成都标学科技有限公司
 *date：2021/10/14 下午2:50
 *coder：gzq
 *email：guozhiqiang@zlketang.com
 *description:
 */

interface IRepository {
    /**
     * 获取百度资讯
     */
    suspend fun getContent(): String?
}