package com.clean.data.utils

import java.io.IOException

class NoConnectivityException : IOException() {
    override val message: String
        get() = "Network Connection exceptionnnn"
}