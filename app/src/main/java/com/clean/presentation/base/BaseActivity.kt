package com.clean.presentation.base;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.LayoutRes


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.*
import com.clean.data.dataSourse.api.response.ApiBaseResponse
import com.clean.data.utils.GeneralError
import com.clean.presentation.di.viewModel.AppViewModelFactory


abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity(),
    BaseView {

    protected lateinit var viewModel: VM

    @get:LayoutRes
    protected abstract val layoutRes: Int
    protected abstract val viewModelClass: Class<VM>


    protected fun obtainViewModel(viewModelFactory: AppViewModelFactory) =
        ViewModelProvider(this, viewModelFactory).get(viewModelClass).apply {
            viewModel = this
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

    }


    override fun showLoading(message: String?) {
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun unauthorizedUser(response: ApiBaseResponse?) {
    }

    override fun onTimeout(throwable: Throwable?) {
    }

    override fun onNetworkError(throwable: Throwable?) {
    }

    override fun onError(error: GeneralError?) {
    }

    override fun onResponseMessage(message: ApiBaseResponse?) {
    }


    override fun onDestroy() {
        super.onDestroy();
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    override fun onBackPressed() {
        super.onBackPressed();
    }

}
