package com.ejemlo.tp_mercadolibre

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuItemCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ejemlo.tp_mercadolibre.io.API
import com.ejemlo.tp_mercadolibre.io.ProductClickedListener
import com.ejemlo.tp_mercadolibre.io.ProductosAdapter
import com.ejemlo.tp_mercadolibre.model.Productos
import com.ejemlo.tp_mercadolibre.model.SearchResult
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var apiService : API
    private lateinit var productosAdapter: ProductosAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        injectDependencies()
        setupRecyclerview()



    }

    private fun injectDependencies(){
        apiService = API()
        productosAdapter = ProductosAdapter()
    }

    private fun setupRecyclerview() {
        val reciclerView :RecyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        reciclerView.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        reciclerView.adapter=productosAdapter
        productosAdapter.setProductoClickeListener(object: ProductClickedListener{
            override fun onProductClicked(producto: Productos) {
                val intent = Intent(this@MainActivity, Products::class.java)
                intent.putExtra("idProduct", producto.id)
                startActivity(intent)
            }
        })

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val menuItem = menu!!.findItem(R.id.search_menu)
        val viewSearch= MenuItemCompat.getActionView(menuItem) as SearchView
        viewSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                searchTo(query)
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item!!.itemId)
        {
            R.id.cart -> Toast.makeText(this@MainActivity, "No ha nada en el carri", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun searchTo(query: String?){
        query?.run {
            apiService.search(query).enqueue(object :Callback<SearchResult> {
                    override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                        showError(t)
                    }

                    override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>)
                    {
                        if(response.isSuccessful){
                            val respuesta :SearchResult = response.body()!!
                            productosAdapter.UpdateProductos(respuesta.results)
                            Toast.makeText(this@MainActivity, "hubo "+respuesta.paging.total+" de Resultados", Toast.LENGTH_SHORT).show()
                            productosAdapter.notifyDataSetChanged()
                        }else{
                            Toast.makeText(this@MainActivity, "no funca", Toast.LENGTH_SHORT).show()

                        }
                    }
            })
        }
    }


    private fun showError(t:Throwable) {
        Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
    }



}
