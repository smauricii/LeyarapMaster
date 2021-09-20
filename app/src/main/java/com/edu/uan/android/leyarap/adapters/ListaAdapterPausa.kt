package com.edu.uan.android.leyarap.adapters

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.edu.uan.android.leyarap.R
import com.edu.uan.android.leyarap.clases.ListaPausas
import kotlinx.android.synthetic.main.item_lista_pausa.view.*

class ListaAdapterPausa(private val mContext:Context, private val listaPau:List<ListaPausas>):ArrayAdapter<ListaPausas>(mContext,0,listaPau) {



    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_lista_pausa,parent,false)

        val ListaPausas= listaPau[position]

        layout.txt_lista.text = ListaPausas.titulo
        layout.txt_horaf.text = ListaPausas.diaHora
        layout.imageViewPausa.setImageResource(ListaPausas.imagen)

        layout.txt_lista.typeface = Typeface.createFromAsset(context?.assets, "fonts/moon.otf")
        layout.txt_lista.setTextColor(Color.WHITE)

        layout.txt_horaf.typeface = Typeface.createFromAsset(context?.assets, "fonts/moon.otf")
        layout.txt_horaf.setTextColor(Color.WHITE)


        return layout
    }

}