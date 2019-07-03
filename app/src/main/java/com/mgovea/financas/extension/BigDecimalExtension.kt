package com.mgovea.financas.extension

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.Locale

fun BigDecimal.formataParaReais() : String {
    val formatoBR = DecimalFormat .getCurrencyInstance(Locale("pt", "br"))
    return formatoBR.format(this).replace("R$", "R$ ").replace("-R$ ", "R$ -")
}

