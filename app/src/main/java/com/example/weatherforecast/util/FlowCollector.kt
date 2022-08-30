package com.example.weatherforecast.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

fun <T> CoroutineScope.flowCollector(flow: Flow<T?>, fn: (value: T) -> Unit){
    launch {
        flow.collect{
            if (it != null) fn(it)
        }
    }
}