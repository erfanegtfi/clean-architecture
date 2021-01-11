package com.clean.presentation.product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.clean.R
import com.clean.databinding.ItemProductBinding
import com.clean.presentation.model.Product

class ProductAdapter(
    var context: Context,
    private var properties: List<Product>,
    val  selectItemCallBack: (position: Int, view: View) -> Unit) : RecyclerView.Adapter<ProductAdapter.PropertiesViewHolder>() {

    private var layout: Int = R.layout.item_product
    private var index: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropertiesViewHolder {
        return PropertiesViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), layout, parent, false));
    }


    override fun onBindViewHolder(holder: PropertiesViewHolder, position: Int) {
//        holder.binding.setCategory(properties.get(position));
        holder.binding.product = properties[position]
    }


    override fun getItemCount(): Int {
        return properties.size;
    }

    inner class PropertiesViewHolder(var binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            itemView.setOnClickListener(this);
        }


        override fun onClick(v: View) {
            val position: Int = adapterPosition;
            selectItemCallBack(position, v)

        }
    }

}
