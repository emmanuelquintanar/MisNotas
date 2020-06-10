package edu.itsco.misnotas

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.itsco.misnotas.db.Nota

class MainActivity : AppCompatActivity() {

    private val NUEVA_NOTA = 0
    private lateinit var notaViewModel: NotaViewModel
    private lateinit var fabAdd: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerNotas: RecyclerView = findViewById(R.id.recycler_notas)
        val adapter = NotaAdapter(this)
        recyclerNotas.adapter = adapter
        recyclerNotas.layoutManager = LinearLayoutManager(this)

        notaViewModel = ViewModelProvider(this).get(NotaViewModel::class.java)
        notaViewModel.allNotas.observe(this, Observer { notas -> notas?.let{adapter.setNotas(it)}})

        fabAdd = findViewById(R.id.fab_add_nota)
        fabAdd.setOnClickListener {
            val intent = Intent(this@MainActivity,NuevaNotaActivity::class.java)
            startActivityForResult(intent, NUEVA_NOTA)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == NUEVA_NOTA && resultCode == Activity.RESULT_OK){
            data?.getParcelableExtra<Nota>(NuevaNotaActivity.NOTA_RESPUESTA)?.let{
                notaViewModel.insert(it)
            }
        }else
        {
            Toast.makeText(this,"Nota no agregada", Toast.LENGTH_SHORT).show()
        }

    }
}