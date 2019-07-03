package com.mgovea.financas.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat
import com.mgovea.financas.R
import com.mgovea.financas.extension.formataPadraoBR
import com.mgovea.financas.extension.formataParaReais
import com.mgovea.financas.extension.limitaEm
import com.mgovea.financas.model.Tipo
import com.mgovea.financas.model.Transacao
import kotlinx.android.synthetic.main.transacao_item.view.*

class ListaTransacoesAdapter(
    private val listaTransacoes: List<Transacao>,
    private val context: Context
) : BaseAdapter() {


    override fun getView(posicao: Int, view: View?, parent: ViewGroup?): View {
        val viewCriada = LayoutInflater.from(context).inflate(R.layout.transacao_item, parent, false)

        val transacao = listaTransacoes[posicao]

        if (transacao.tipo == Tipo.RECEITA) {
            viewCriada.transacao_icone.setBackgroundResource(R.drawable.icone_transacao_item_receita)
            viewCriada.transacao_valor.setTextColor(ContextCompat.getColor(context, R.color.receita))
        } else {
            viewCriada.transacao_icone.setBackgroundResource(R.drawable.icone_transacao_item_despesa)
            viewCriada.transacao_valor.setTextColor(ContextCompat.getColor(context, R.color.despesa))
        }

        viewCriada.transacao_valor.text = transacao.valor.formataParaReais()
        viewCriada.transacao_categoria.text = transacao.categoria.limitaEm(14)
        viewCriada.transacao_data.text = transacao.data.formataPadraoBR()

        return viewCriada
    }

    override fun getItem(position: Int): Transacao {
        return listaTransacoes[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return listaTransacoes.size
    }
}