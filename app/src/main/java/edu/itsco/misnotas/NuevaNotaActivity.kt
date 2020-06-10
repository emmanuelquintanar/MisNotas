package edu.itsco.misnotas

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import edu.itsco.misnotas.db.Nota

class NuevaNotaActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var txtTitulo: EditText
    private lateinit var txtDescripcion: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva_nota)

        txtTitulo = findViewById(R.id.txt_titulo)
        txtDescripcion = findViewById(R.id.txt_descripcion)
        val btnGuardar: Button = findViewById(R.id.btn_guardar)
        btnGuardar.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        val intent: Intent = Intent()
       if(TextUtils.isEmpty(txtTitulo.text)&&TextUtils.isEmpty(txtDescripcion.text)){
         setResult(Activity.RESULT_CANCELED, intent)
       }else{
           val nota = Nota(titulo = txtTitulo.text.toString(), descripcion= txtDescripcion.text.toString())
           intent.putExtra(NOTA_RESPUESTA,nota)
           setResult(Activity.RESULT_OK,intent)

       }
        finish()
    }

    companion object{
        const val NOTA_RESPUESTA = "edu.itsco.misnotas.RESPUESTA"
    }
}