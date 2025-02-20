package br.com.alura.orgs.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.R
import br.com.alura.orgs.dao.ProdutoDAO
import br.com.alura.orgs.model.Produto
import java.math.BigDecimal

class FormProdutoActivity : AppCompatActivity(R.layout.activity_form_produto) {

    val dao = ProdutoDAO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configBotaoSalvar()
    }

    private fun configBotaoSalvar(){
        val btSalvar = findViewById<Button>(R.id.btSalvar)
        btSalvar.setOnClickListener {
            val novoProduto = createProduto()
            dao.add(novoProduto)
            finish()
        }
    }

    private fun createProduto(): Produto {
        val etNome = findViewById<EditText>(R.id.etNome).text.toString()
        val etDesc = findViewById<EditText>(R.id.etDesc).text.toString()
        val etValor = findViewById<EditText>(R.id.etValor).text.toString()
        val valor = if (etValor.isBlank()) {
            BigDecimal.ZERO
        } else
            BigDecimal(etValor)

        return Produto(
            nome = etNome,
            desc = etDesc,
            valor = valor
        )
    }


}