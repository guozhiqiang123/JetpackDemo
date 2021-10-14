package com.example.hilt.domain

import androidx.lifecycle.*
import com.example.hilt.repository.IRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

/**
 *company：成都标学科技有限公司
 *date：2021/10/14 下午3:05
 *coder：gzq
 *email：guozhiqiang@zlketang.com
 *description:
 */

@HiltViewModel
class MainVM @Inject constructor(
    private val handle: SavedStateHandle,
    private val repository: IRepository
) : ViewModel() {
    private val _content = MutableLiveData<String>()
    val content: LiveData<String> get() = _content

    fun fetchBaiduContent() {
        viewModelScope.launch {
            flow {
                try {
                    val baiduContent = repository.getContent()
                    _content.value = baiduContent ?: ""
                    emit(Result.success(baiduContent))
                } catch (e: Exception) {
                    Timber.e(e)
                    emit(Result.failure(e))
                }

            }.flowOn(Dispatchers.IO).collectLatest { result ->
                _content.value = result.getOrDefault("")
            }
        }
    }
}