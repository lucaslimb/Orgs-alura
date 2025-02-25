package br.com.alura.orgs.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.dao.ProdutoDAO
import br.com.alura.orgs.databinding.ActivityFormProdutoBinding
import br.com.alura.orgs.model.Produto
import java.math.BigDecimal

class FormProdutoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormProdutoBinding
    private val dao = ProdutoDAO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormProdutoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configBotaoSalvar()
    }

    private fun configBotaoSalvar() {
        binding.btSalvar.setOnClickListener {
            val novoProduto = createProduto()
            dao.add(novoProduto)
            finish()
        }
    }

    private fun createProduto(): Produto {
        val etNome = binding.etNome.text.toString()
        val etDesc = binding.etDesc.text.toString()
        val etValor = binding.etValor.text.toString()
        val valor = if (etValor.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(etValor)
        }

        return Produto(
            nome = etNome,
            desc = etDesc,
            valor = valor
        )
    }
}
