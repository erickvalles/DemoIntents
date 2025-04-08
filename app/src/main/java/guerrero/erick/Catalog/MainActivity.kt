package guerrero.erick.Catalog

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import guerrero.erick.myapplicationintents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //establecer el binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //poner un listener al botón de abrir
        binding.btnAbrir.setOnClickListener {
            val intent = Intent(this, SegundaActivity::class.java)
            intent.putExtra("argumento1","Mensaje de activity1")
            intent.putExtra("numero",212)
            //iniciar la activity
            startActivity(intent)

        }
    }
}