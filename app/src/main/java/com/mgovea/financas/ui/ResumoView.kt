package com.mgovea.financas.ui

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import com.mgovea.financas.R
import com.mgovea.financas.extension.formataParaReais
import com.mgovea.financas.model.Tipo
import com.mgovea.financas.model.Transacao
import kotlinx.android.synthetic.main.resumo_card.view.*
import java.math.BigDecimal

class ResumoView(private val view: View, transacoes: List<Transacao>, private val context: Context) {


    var totalReceita: BigDecimal = BigDecimal.ZERO
    var totalDespesa: BigDecimal = BigDecimal.ZERO
    var total: BigDecimal = BigDecimal.ZERO


    init {
        for (transacao in transacoes) {
            if (transacao.tipo == Tipo.RECEITA) {
                totalReceita = totalReceita.plus(transacao.valor)
            } else {
                totalDespesa = totalDespesa.plus(transacao.valor)
            }
        }

        total = totalReceita.subtract(totalDespesa)
    }

    private val corReceita = ContextCompat.getColor(context, R.color.receita)
    private val corDespesa = ContextCompat.getColor(context, R.color.despesa)

    fun adicionaReceita() {
        with(view.resumo_card_receita) {
            setTextColor(corReceita)
            text = totalReceita.formataParaReais()
        }
    }


    fun adicionaDespesa() {
        with(view.resumo_card_despesa) {
            setTextColor(corDespesa)
            text = totalDespesa.formataParaReais()
        }
    }

    fun adicionaTotal() {
        with(view.resumo_card_total) {
            text = total.formataParaReais()
            setTextColor(if (total >= BigDecimal.ZERO) corReceita else corDespesa)
        }

    }

}
