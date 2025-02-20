package br.com.alura.orgs.dao

import br.com.alura.orgs.model.Produto

class ProdutoDAO {

    fun add(produto : Produto){
        produtos.add(produto)
    }

    fun listAll() : List<Produto>{
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>()
    }

}