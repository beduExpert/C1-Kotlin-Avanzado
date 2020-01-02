package org.bedu.realmexample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import io.realm.Realm
import io.realm.RealmChangeListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var mAdapter : RecyclerAdapter
    private lateinit var contacts: List<Contact>

    private lateinit var realm : Realm
    private lateinit var realmListener : RealmChangeListener<Realm>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("TAG","hola a todos")
        setContentView(R.layout.activity_main)

        fab.setOnClickListener{
            val intent = Intent(this,AddContactActivity::class.java)
            startActivityForResult(intent,1)
        }

        realm = Realm.getDefaultInstance()

        //declaramos la notificación cada que cambia el Realm
        realmListener =  RealmChangeListener{
            Toast.makeText(this,"Tabla modificada",Toast.LENGTH_SHORT).show()
        }

        //suscribimos a nuestra instancia de Realm
        realm.addChangeListener(realmListener)

        contacts = realm
            .where(Contact::class.java)
            .beginGroup()
                .like("name", "*s*")
                .or()
                .equalTo("city", "Lille")
            .endGroup()
            .findAllAsync()

        

    }

    override fun onDestroy() {
        super.onDestroy()

        realm.removeChangeListener(realmListener)
        realm.close()
    }

    //configuramos lo necesario para desplegar el RecyclerView
    private fun setUpRecyclerView(){
        recyclerContacts.setHasFixedSize(true)
        recyclerContacts.layoutManager = LinearLayoutManager(this)
        mAdapter = RecyclerAdapter( this,contacts)
        recyclerContacts.adapter = mAdapter
    }

    private fun updateRecycler() {
        contacts = realm.where(Contact::class.java).findAll()
        mAdapter.notifyDataSetChanged()
    }

    private fun addContact(data: Intent?){


        realm.executeTransaction {
            var pk = realm.where(Contact::class.java!!).max("id") ?: 0
            pk = pk.toInt() + 1

            val contact = realm.createObject(Contact::class.java,pk)

            contact.name = data!!.getStringExtra("name")
            contact.job = data!!.getStringExtra("job")
            contact.company = data!!.getStringExtra("company")
            contact.city = data!!.getStringExtra("city")
        }


        updateRecycler()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("TAG","Activity Result")
        if (requestCode == 1) {
            Log.d("TAG","Request Code 1")

            if (resultCode == Activity.RESULT_OK) {
                Log.d("TAG","Result OK")

                addContact(data)

            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Log.d("TAG","Result CANCELLED")
            }
        }
    }

}
