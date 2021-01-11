package com.clean.common

import java.text.DecimalFormat
import java.text.NumberFormat

object Utils {

    fun priceFormatter(price: Long?): String {
        val formatter: NumberFormat = DecimalFormat("#,###")
        price?.let {
            return formatter.format(price)
        } ?: return ""
    }
}