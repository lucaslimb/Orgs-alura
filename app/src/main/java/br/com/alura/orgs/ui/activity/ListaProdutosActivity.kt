package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.dao.ProdutoDAO
import br.com.alura.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaProdutosActivity : AppCompatActivity(R.layout.activity_lista_produtos) {

        val dao = ProdutoDAO()

        private val adapter = ListaProdutosAdapter(context = this, produtos = dao.listAll())

        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                configRecyclerView()
        }

        override fun onResume() {
                super.onResume()
                adapter.update(dao.listAll())
                configFab()

        }

        private fun configFab() {
                val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
                fab.setOnClickListener {
                        val intent = Intent(this, FormProdutoActivity::class.java)
                        startActivity(intent)
                }
        }

        private fun configRecyclerView() {
                val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                recyclerView.adapter = adapter
        }
}