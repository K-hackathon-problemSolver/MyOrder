package com.problemsolver.myorder.app.domain.util

import android.util.Log

fun String.log(header: String = "D/VIDE") {
    Log.d(header, this)
}