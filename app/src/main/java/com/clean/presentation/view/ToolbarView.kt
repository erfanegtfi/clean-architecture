package com.clean.presentation.view

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.clean.R
import kotlinx.android.synthetic.main.toolbar_view.view.*


class ToolbarView : Toolbar, View.OnClickListener {

    private var showBack = false
    private var showSearch = false
    private var showCart = false
    private var title: String? = null
    private var isAddedOffsetListener = false
    var alphaForActionBar = true

    constructor(context: Context) : super(context) {
        init(context, null, 0)
    }

    constructor(
        context: Context, attrs: AttributeSet
    ) : super(context, attrs) {
        init(context, attrs, 0)
    }

    constructor(
        context: Context, attrs: AttributeSet, defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
        init(context, attrs, defStyleAttr)
    }

    private fun init(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {
        View.inflate(context, R.layout.toolbar_view, this)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            elevation = 10f
        }
        setPadding(0, 0, 0, 0)
        setBackgroundColor(ContextCompat.getColor(context, R.color.white))
        setContentInsetsAbsolute(0, 0)
        setContentInsetsRelative(0, 0)

        // Load attributes
        val ta = getContext().obtainStyledAttributes(attrs, R.styleable.ToolbarView, defStyleAttr, 0)
        title = ta.getString(R.styleable.ToolbarView_tv_title)
        showBack = ta.getBoolean(R.styleable.ToolbarView_tv_show_back, false)
        showSearch = ta.getBoolean(R.styleable.ToolbarView_tv_show_search, false)
        showCart = ta.getBoolean(R.styleable.ToolbarView_tv_show_cart, false)
        ta.recycle()
        //-----------------------------------
        img_back.visibility = if (showBack) VISIBLE else GONE
        ic_search.visibility = if (showSearch) VISIBLE else GONE
        ic_cart.visibility = if (showCart) VISIBLE else GONE

        img_back.setOnClickListener(this)
        ic_search.setOnClickListener(this)
        ic_cart.setOnClickListener(this)
        setTitle(title);
    }

    fun setTitle(title: String?) {
        title?.let {
            txt_title.text = it
            txt_title.visibility = if (it.isNotBlank()) VISIBLE else INVISIBLE
        }
    }


    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {

                R.id.img_back -> {
                    scanForActivity(context)?.finish()
                }

            }
        }
    }

    private fun scanForActivity(cont: Context?): Activity? {
        return when (cont) {
            null -> null
            is Activity -> cont
            is ContextWrapper -> scanForActivity(
                cont.baseContext
            )
            else -> null
        }
    }

}