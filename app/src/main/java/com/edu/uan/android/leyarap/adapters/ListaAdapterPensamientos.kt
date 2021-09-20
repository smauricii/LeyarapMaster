package com.edu.uan.android.leyarap.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.edu.uan.android.leyarap.R
import com.edu.uan.android.leyarap.clases.ListaPensamientos
import kotlinx.android.synthetic.main.item_lista_pensamientos.view.*

class ListaAdapterPensamientos(private val mContext:Context,private val listaPensamientosA:List<ListaPensamientos>):ArrayAdapter<ListaPensamientos>(mContext,0,listaPensamientosA) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_lista_pensamientos,parent,false)

        val pensamientos = listaPensamientosA[position]

        layout.txt_Lista_Pensamientos.text = pensamientos.titulo
        layout.imageViewPensamientos.setImageResource(pensamientos.imagen)

        return layout
    }
}