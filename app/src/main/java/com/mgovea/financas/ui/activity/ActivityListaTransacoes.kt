package com.mgovea.financas.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mgovea.financas.R
import com.mgovea.financas.extension.formataParaReais
import com.mgovea.financas.model.Tipo
import com.mgovea.financas.model.Transacao
import com.mgovea.financas.ui.ResumoView
import com.mgovea.financas.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import kotlinx.android.synthetic.main.resumo_card.*
import java.math.BigDecimal

class ActivityListaTransacoes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val listaItens = transacoesExemplo()

        lista_transacoes_listview.adapter = ListaTransacoesAdapter(listaItens, this)

        configuraResumo(listaItens)

    }

    private fun configuraResumo(transacoes: List<Transacao>) {
        val view: View = window.decorView
        val resumoView = ResumoView(view, transacoes, this)
        resumoView.adicionaReceita()
        resumoView.adicionaDespesa()
        resumoView.adicionaTotal()
    }


    private fun transacoesExemplo(): List<Transacao> {
        val transacao = Transacao(valor = BigDecimal(300), tipo = Tipo.RECEITA)
        val transacao1 = Transacao(BigDecimal(35), "Teste2", Tipo.DESPESA)
        val transacao2 = Transacao(BigDecimal(45), "Almoco de final de semana foda", Tipo.DESPESA)

        val listaItens = listOf(transacao, transacao1, transacao, transacao2)
        return listaItens
    }
}
