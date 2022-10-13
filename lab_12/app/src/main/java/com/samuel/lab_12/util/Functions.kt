package com.samuel.lab_12.util

import android.view.View

fun View.visibleIf(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}