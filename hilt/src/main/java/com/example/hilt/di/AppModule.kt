package com.example.hilt.di

import android.app.Application
import com.example.hilt.Const
import com.example.hilt.data.RepositoryImp
import com.example.hilt.http.HttpApi
import com.example.hilt.repository.IRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**
 *company：成都标学科技有限公司
 *date：2021/10/14 下午2:36
 *coder：gzq
 *email：guozhiqiang@zlketang.com
 *description:
 */
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(app: Application): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Const.HTTP_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideRepository(retrofit: Retrofit): IRepository {
        return RepositoryImp(retrofit.create(HttpApi::class.java))
    }
}