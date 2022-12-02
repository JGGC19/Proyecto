package mx.tecnm.cdhidalgo.proyecto.Adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.tecnm.cdhidalgo.proyecto.Modelo.Numero
import mx.tecnm.cdhidalgo.proyecto.R

class AdaptadorNumero() : RecyclerView.Adapter<AdaptadorNumero.MyViewHolder>() {

    private val userList = ArrayList<Numero>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.card_instituciones,
            parent,false
        )
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = userList[position]

        holder.firstName.text = currentitem.nombre
        holder.lastName.text = currentitem.numero

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun updateUserList(userList: List<Numero>){

        this.userList.clear()
        this.userList.addAll(userList)
        notifyDataSetChanged()

    }

    class  MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val firstName : TextView = itemView.findViewById(R.id.tvfirstName)
        val lastName : TextView = itemView.findViewById(R.id.tvlastName)

    }

}
