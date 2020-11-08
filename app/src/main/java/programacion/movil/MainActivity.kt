package programacion.movil

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import java.security.AccessController.getContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton1 = findViewById<Button>(R.id.boton1)
        val editText1 = findViewById<EditText>(R.id.editText1)
        val imagenBatman = findViewById<ImageView>(R.id.imagenBatman)
        val layout = findViewById<ConstraintLayout>(R.id.layout)


        editText1.visibility = View.INVISIBLE
        boton1.text = "Comenzar"
        imagenBatman.visibility = View.INVISIBLE

        boton1.setOnClickListener {
            if(boton1.text.toString() == "Comenzar") {
                editText1.visibility = View.VISIBLE
                editText1.setText("Introduce tu nombre")
            }
            else {
                if(editText1.text.toString().isNotEmpty()) {
                    editText1.visibility = View.INVISIBLE
                    boton1.text = "Comenzar"
                    imagenBatman.visibility = View.INVISIBLE
                    layout.setBackgroundColor(Color.WHITE)
                    boton1.setBackgroundColor(Color.parseColor("#E5E400"))
                    boton1.setTextColor(Color.parseColor("#000000"))
                    editText1.setTextColor(Color.parseColor("#000000"))
                }
                else {
                    editText1.setText("Introduce tu nombre")
                }

            }
        }

        editText1.setOnClickListener {
            boton1.text = "Finalizar"
            editText1.setText("")
        }






        editText1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int){
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) =
                when {
                    editText1.text.toString() == "Wayne" -> {
                        imagenBatman.visibility = View.VISIBLE
                    }
                    editText1.text.toString() == "joker" -> {
                        layout.setBackgroundColor(Color.parseColor("#46BA28"))
                        boton1.setBackgroundColor(Color.parseColor("#FF3700B3"))
                        boton1.setTextColor(Color.parseColor("#FFFFFF"))
                        editText1.setTextColor(Color.parseColor("#FFFFFF"))

                    }
                    else -> {
                        imagenBatman.visibility = View.INVISIBLE
                        layout.setBackgroundColor(Color.WHITE)
                        boton1.setBackgroundColor(Color.parseColor("#E5E400"))
                        boton1.setTextColor(Color.parseColor("#000000"))
                        editText1.setTextColor(Color.parseColor("#000000"))
                    }
                }
        })
    }
}


