package com.example.weatherforecast.util

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

inline fun Fragment.repeatOnLifecycleProvider(crossinline fn: CoroutineScope.() -> Unit){
    this.viewLifecycleOwner.lifecycleScope.launch{
        viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED){
            fn()
        }
    }
}