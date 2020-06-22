package com.ejemlo.tp_mercadolibre

import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ejemlo.tp_mercadolibre.io.API
import com.ejemlo.tp_mercadolibre.io.ProductosAdapter
import com.ejemlo.tp_mercadolibre.model.Item
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Products : AppCompatActivity() {
    private lateinit var apiService : API
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)
        setSupportActionBar(toolbar)
        injectDependencies()
        val bundle = intent.extras
        getProducto(bundle?.getString("idProduct"))


    }
    private fun injectDependencies(){
        apiService = API()

    }

    private fun getProducto(idProduct: String?) {
        idProduct?.run {
            apiService.getItem(idProduct).enqueue(object : Callback<Item> {
                    override fun onFailure(call: Call<Item>, t: Throwable) {
                        showError(t)
                    }

                    override fun onResponse(call: Call<Item>, response: Response<Item>
                    ) {
                        if(response.isSuccessful){
                            //de aca funciona
                            guardarProduct(response.body()!!)
                        }else{
                            Toast.makeText(this@Products, "no funciono", Toast.LENGTH_LONG).show()

                        }
                    }
                })
        }

    }

    private fun guardarProduct(body: Item) {
        var titulo= findViewById<TextView>(R.id.tituloProducto)
        var precio = findViewById<TextView>(R.id.Precio)
        var cantidad = findViewById<TextView>(R.id.Cantidad)
        var condicion = findViewById<TextView>(R.id.Condicion)
        var image = findViewById<ImageView>(R.id.imageProduct)

        titulo.text = body.title
        precio.text = "$" + body.price
        cantidad.text = "Cantidad: " + body.available_quantity
        condicion.text =body.condition

        Picasso.get()
            .load(body.thumbnail)
            .into(image)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_product, menu)
        return true
    }
    private fun showError(t:Throwable) {
        Toast.makeText(this@Products, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
    }
}