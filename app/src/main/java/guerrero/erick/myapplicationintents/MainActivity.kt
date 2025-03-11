package guerrero.erick.myapplicationintents

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import guerrero.erick.myapplicationintents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //poner un listener al botón de abrir
        binding.btnAbrir.setOnClickListener {
            val intent = Intent(this, SegundaActivity::class.java)
            intent.putExtra("argumento1","Mensaje de activity1")
            intent.putExtra("numero",212)
            startActivity(intent)

        }
    }
}