package edu.itsco.misnotas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.itsco.misnotas.db.Nota

class NotaAdapter internal constructor(context: Context): RecyclerView.Adapter<NotaAdapter.ViewHolder>() {


    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var notas = emptyList<Nota>()

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val lbTituloNota = view.findViewById<TextView>(R.id.lb_titulo_nota)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotaAdapter.ViewHolder {
       val view: View = inflater.inflate(R.layout.item_nota, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return notas.size
    }

    override fun onBindViewHolder(holder: NotaAdapter.ViewHolder, position: Int) {
        holder.lbTituloNota.text = notas[position].titulo
    }

    internal fun setNotas(notas: List<Nota>){
        this.notas = notas
        notifyDataSetChanged()
    }
}