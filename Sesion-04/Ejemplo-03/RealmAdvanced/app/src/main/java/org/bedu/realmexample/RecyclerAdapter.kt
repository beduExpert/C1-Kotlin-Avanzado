package org.bedu.realmexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import io.realm.Realm
import io.realm.RealmObject.deleteFromRealm



//Declaración con constructor
class RecyclerAdapter(
    var context:Context,
    var contacts: List<Contact>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    //Aquí atamos el ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = contacts.get(position)
        holder.bind(item, context)

        holder.removeBtn.setOnClickListener {
            val realm = Realm.getDefaultInstance()

            //otra forma de ejecutar una transaccción a la DB
            realm.executeTransaction {
                notifyItemRemoved(holder.adapterPosition)
                item.deleteFromRealm()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_contact, parent, false),this)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    //El ViewHolder ata los datos del RecyclerView a la Vista para desplegar la información
    //También se encarga de gestionar los eventos de la View, como los clickListeners
    class ViewHolder(view: View, adapter: RecyclerAdapter) : RecyclerView.ViewHolder(view) {
        //obteniendo las referencias a las Views
        val nombre = view.findViewById(R.id.tvNombre) as TextView
        val job = view.findViewById(R.id.tvJob) as TextView
        val city = view.findViewById(R.id.tvCity) as TextView
        val removeBtn = view.findViewById(R.id.btnRemove) as ImageButton
        //val image = view.findViewById(R.id.userImage) as ImageView

        //"atando" los datos a las Views
        fun bind(contact: Contact, context: Context){
            nombre.text = contact.name
            job.text = contact.job
            city.text = contact.city
            //image.setImageResource(contact.idImage)


        }
    }


}