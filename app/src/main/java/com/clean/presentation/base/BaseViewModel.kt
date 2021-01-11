package com.clean.presentation.base;

import androidx.lifecycle.ViewModel


open class BaseViewModel() : ViewModel() {


    open fun onDestroy() {
//        compositeDisposable.clear()
    }

}
