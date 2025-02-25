package br.com.alura.orgs.dao

import br.com.alura.orgs.model.Produto
import java.math.BigDecimal

class ProdutoDAO {

    fun add(produto : Produto){
        produtos.add(produto)
    }

    fun listAll() : List<Produto>{
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>(
            Produto(nome = "Produto 1", desc = "Descricao do Produto 1", valor = BigDecimal("19.90"))
        )
    }

}