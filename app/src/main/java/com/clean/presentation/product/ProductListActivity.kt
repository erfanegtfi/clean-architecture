package com.clean.presentation.product

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.clean.R
import com.clean.data.utils.GeneralError
import com.clean.data.utils.ResponseResult
import com.clean.domain.model.output.ProductSearchOut
import com.clean.presentation.base.BaseActivity
import com.clean.presentation.di.component.DaggerAppComponent
import com.clean.presentation.di.viewModel.AppViewModelFactory
import com.clean.presentation.model.Product
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject


@ExperimentalCoroutinesApi
class ProductListActivity : BaseActivity<ProductViewModel>() {

    override val layoutRes: Int = R.layout.activity_main
    override val viewModelClass: Class<ProductViewModel> = ProductViewModel::class.java
    private var productList = arrayListOf<Product>()
    private lateinit var categoryAdapter: ProductAdapter

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerAppComponent.factory().create(application).inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        obtainViewModel(viewModelFactory)
        setupView()
        viewModel.productsLiveData.observe(this, Observer {
            when (it) {
                is ResponseResult.Success -> {
                    hideLoading()
                    refreshAdapter(it.response)
                }
                is ResponseResult.Error -> {
                    hideLoading()
                    onError(it.error)
                }
                is ResponseResult.Loading -> showLoading()
            }
        })

        viewModel.getProductList(ProductSearchOut(query = ""))
    }

    private fun onItemClick(i: Int, view: View) {

    }

    private fun setupView() {
        (rvProductList.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
        categoryAdapter = ProductAdapter(this, productList, ::onItemClick)
        rvProductList.adapter = categoryAdapter
        rvProductList.layoutManager = GridLayoutManager(this, 2)
    }


    private fun refreshAdapter(response: List<Product>) {
        with(productList) {
            clear()
            addAll(response)
        }

        categoryAdapter.notifyDataSetChanged()
    }

    override fun showLoading() {
        super.showLoading()
        progressWheel.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        super.hideLoading()
        progressWheel.visibility = View.GONE
    }

    override fun onError(error: GeneralError?) {
        super.onError(error)
        txtMessage.visibility = View.VISIBLE
        error?.let {
            txtMessage.text = error.message
        }
    }
}