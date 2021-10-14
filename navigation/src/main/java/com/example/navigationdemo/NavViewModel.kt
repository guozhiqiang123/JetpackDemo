package com.example.navigationdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 *company：成都标学科技有限公司
 *date：2021/10/14 上午9:28
 *coder：gzq
 *email：guozhiqiang@zlketang.com
 *description:
 */

class NavViewModel : ViewModel() {
    val exampleLiveData: MutableLiveData<Int> = MutableLiveData()
}