package com.ejemlo.tp_mercadolibre.io

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ejemlo.tp_mercadolibre.R
import com.ejemlo.tp_mercadolibre.model.Productos
import com.squareup.picasso.Picasso

class ProductosAdapter:RecyclerView.Adapter<ProductoViewHolder>() {

    private val productoList : MutableList<Productos> = mutableListOf<Productos>()
    private var productClickListener : ProductClickedListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val productosView :View =
        LayoutInflater.from(parent.context).inflate(R.layout.list_result,parent,false)
        return ProductoViewHolder(productosView)
    }

    override fun getItemCount()= productoList.size

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val productos :Productos =productoList[position]
        holder.titulo.text=productos.title
        holder.precio.text="$"+productos.price
        if (productos.condition.equals("new"))
            holder.condicion.text="nuevo"
        else
            holder.condicion.text="usado"
        holder.id.text=productos.id
        if(productos.address.city_name.equals(productos.address.state_name))
            holder.direccion.text=productos.address.city_name
        else
        holder.direccion.text=productos.address.city_name+","+productos.address.state_name

        holder.modeoventa.text=productos.buying_mode
        if (productos.accepts_mercado)
        holder.mercadopago.text="Mercadopaogo"

        Picasso.get()
            .load(productos.thumbnail)
            .into(holder.image)

        holder.itemView.setOnClickListener{
            productClickListener?.onProductClicked(productos)
        }

    }

    fun UpdateProductos(results: List<Productos>) {
        productoList.clear()
        productoList.addAll(results)

    }
    fun setProductoClickeListener(clicklinstener :ProductClickedListener){
        this.productClickListener =clicklinstener
    }
}
class ProductoViewHolder(view: View):RecyclerView.ViewHolder(view){
    val image :ImageView = view.findViewById(R.id.image)
    val titulo :TextView =view.findViewById(R.id.titulo)
    val precio :TextView =view.findViewById(R.id.precio)
    val condicion :TextView =view.findViewById(R.id.condicion)
    val id :TextView =view.findViewById(R.id.id_item)
    val direccion :TextView =view.findViewById(R.id.direccion)
    val modeoventa: TextView = view.findViewById(R.id.modoventa)
    val mercadopago :TextView =view.findViewById(R.id.mercadopago)

}

interface ProductClickedListener{
    fun onProductClicked(producto : Productos)
}