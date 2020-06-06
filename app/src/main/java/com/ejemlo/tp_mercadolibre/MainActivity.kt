package com.ejemlo.tp_mercadolibre

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item!!.itemId)
        {
            R.id.menu_buscar -> startActivity(Intent(this@MainActivity,Products::class.java))
            R.id.textsearch -> startActivity(Intent(this@MainActivity,Products::class.java))
            R.id.cart -> Toast.makeText(this@MainActivity, "No ha nada en el carrito", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }



}
