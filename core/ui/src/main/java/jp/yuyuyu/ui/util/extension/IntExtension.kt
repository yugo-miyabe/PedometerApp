package jp.yuyuyu.ui.util.extension

import java.text.DecimalFormat

fun Int.toCommaSeparated(): String {
    return try {
        DecimalFormat("#,###").format(this)
    } catch (e: NumberFormatException) {
        "0"
    }
}
