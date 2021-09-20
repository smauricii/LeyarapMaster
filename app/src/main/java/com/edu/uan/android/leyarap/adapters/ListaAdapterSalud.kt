package com.edu.uan.android.leyarap.adapters

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.edu.uan.android.leyarap.R
import com.edu.uan.android.leyarap.clases.ListaSalud
import kotlinx.android.synthetic.main.activity_salud.view.*
import kotlinx.android.synthetic.main.item_lista_salud.view.*

class ListaAdapterSalud(private val mContext: Context, private val listasalud: List<ListaSalud>): ArrayAdapter<ListaSalud>(mContext,0, listasalud) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_lista_salud,parent,false)

        val listaSalud = listasalud[position]
        layout.txt_Lista_salud.text = listaSalud.titulo
        layout.imageViewSalud.setImageResource(R.drawable.imagen_fondo_salud)

        layout.txt_Lista_salud.typeface = Typeface.createFromAsset(context?.assets, "fonts/moon.otf")
        layout.txt_Lista_salud.setTextColor(Color.WHITE)

        return layout



    }
}