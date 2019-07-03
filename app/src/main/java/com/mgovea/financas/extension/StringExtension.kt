package com.mgovea.financas.extension

fun String.limitaEm(caracteres: Int): String {
    if (this.length > caracteres) {
        return "${this.substring(0, caracteres)}..."
    }
    return this
}