package com.clean.presentation.product;

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.clean.domain.usecase.ProductListUseCase
import com.clean.data.utils.ResponseResult
import com.clean.domain.model.output.ProductSearchOut
import com.clean.presentation.base.BaseViewModel
import com.clean.presentation.mapper.ProductPresentationToDomainMapper
import com.clean.presentation.model.Product
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
class ProductViewModel @Inject constructor(private val productListUseCase: ProductListUseCase) :
    BaseViewModel() {

    private val _productsLiveData = MutableLiveData<ResponseResult<List<Product>>>()
    val productsLiveData: LiveData<ResponseResult<List<Product>>>
        get() = _productsLiveData


    fun getProductList(query: ProductSearchOut) {
        viewModelScope.launch {

            productListUseCase.execute(query).onStart {
                _productsLiveData.value = ResponseResult.Loading
            }.collect { result ->
                when (result) {
                    is ResponseResult.Success -> {
                        _productsLiveData.value = ResponseResult.Success(response = result.response.map {
                            ProductPresentationToDomainMapper.toPresenterModel(it)
                        })
                    }
                    is ResponseResult.Error -> {
                        _productsLiveData.value = ResponseResult.Error(error = result.error)
                    }
                    is ResponseResult.Loading -> {
                        _productsLiveData.value = ResponseResult.Loading
                    }
                    else -> {
                    }
                }
            }


        }
    }

}