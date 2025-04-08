package guerrero.erick.Catalog.adaper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil3.load
import guerrero.erick.Catalog.data.Gato
import guerrero.erick.myapplicationintents.R

class MiAdaptador(private val dataSet:MutableList<Gato>): RecyclerView.Adapter<MiAdaptador.ViewHolder>() {

    inner class ViewHolder(view:View): RecyclerView.ViewHolder(view){
        val ivFoto:ImageView
        val tvMensaje:TextView

        init{
            ivFoto = view.findViewById(R.id.ivFoto)
            tvMensaje = view.findViewById(R.id.tvDescripcion)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvMensaje.text = dataSet[position].mensaje
        if(dataSet[position].imagen.startsWith("https")){
            holder.ivFoto.load(dataSet[position].imagen)
        }else{
            holder.ivFoto.load("https://cataas.com/cat/${dataSet[position].imagen}")
        }

    }
}