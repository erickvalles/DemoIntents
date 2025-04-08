package guerrero.erick.Catalog

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import coil3.load
import guerrero.erick.myapplicationintents.R
import guerrero.erick.myapplicationintents.databinding.ActivitySegundaBinding

class SegundaActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivitySegundaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySegundaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val paqueteDatos = intent.extras
        val cadena = paqueteDatos?.getString("argumento1")
        val numero = paqueteDatos?.getInt("numero")
        binding.btnRegresar.text = cadena+numero
       binding.btnRegresar.setOnClickListener(this)

        binding.imageView.load("https://techcrunch.com/wp-content/uploads/2021/04/GettyImages-458243847.jpg")

    }

    override fun onClick(v: View?) {
        val i = Intent(this, MainActivity::class.java)

        startActivity(i)
    }
}