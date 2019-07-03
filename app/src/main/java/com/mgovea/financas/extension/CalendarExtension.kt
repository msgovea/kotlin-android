package com.mgovea.financas.extension

import java.text.SimpleDateFormat
import java.util.Calendar

fun Calendar.formataPadraoBR () : String {
    return SimpleDateFormat("dd/MM/yyyy").format(this.time)
}