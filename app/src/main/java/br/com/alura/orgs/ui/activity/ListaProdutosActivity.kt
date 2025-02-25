package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.dao.ProdutoDAO
import br.com.alura.orgs.databinding.ActivityListaProdutosBinding
import br.com.alura.orgs.ui.recyclerview.adapter.ListaProdutosAdapter

class ListaProdutosActivity : AppCompatActivity() {

        private lateinit var binding: ActivityListaProdutosBinding
        private val dao = ProdutoDAO()
        private val adapter by lazy { ListaProdutosAdapter(context = this, produtos = dao.listAll()) }

        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                binding = ActivityListaProdutosBinding.inflate(layoutInflater)
                setContentView(binding.root)
                configRecyclerView()
                configFab()
        }

        override fun onResume() {
                super.onResume()
                adapter.update(dao.listAll())
        }

        private fun configFab() {
                binding.floatingActionButton.setOnClickListener {
                        val intent = Intent(this, FormProdutoActivity::class.java)
                        startActivity(intent)
                }
        }

        private fun configRecyclerView() {
                binding.recyclerView.adapter = adapter
        }
}
