package guerrero.erick.Catalog

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import guerrero.erick.Catalog.adaper.MiAdaptador
import guerrero.erick.Catalog.data.Gato
import guerrero.erick.Catalog.data.api.ApiRepository
import guerrero.erick.myapplicationintents.R
import kotlinx.coroutines.launch

class ListaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista)

        val gato1 = Gato("https://i.pinimg.com/736x/2e/2d/b3/2e2db3394efa67302e2da1deb676839b.jpg","Hola")
        val gato2 = Gato("https://i.pinimg.com/736x/2e/2d/b3/2e2db3394efa67302e2da1deb676839b.jpg","Hola")
        val gato3 = Gato("https://i.pinimg.com/736x/2e/2d/b3/2e2db3394efa67302e2da1deb676839b.jpg","Hola")
        val gato4 = Gato("https://i.pinimg.com/736x/2e/2d/b3/2e2db3394efa67302e2da1deb676839b.jpg","Hola")
        val gato5 = Gato("https://i.pinimg.com/736x/2e/2d/b3/2e2db3394efa67302e2da1deb676839b.jpg","Hola")

        val conjuntoGatos = arrayOf(gato1,gato2,gato3,gato4,gato5)
        val listaGatos = mutableListOf<Gato>()
        listaGatos.addAll(conjuntoGatos)
        val miAdaptador = MiAdaptador(listaGatos)
        lifecycleScope.launch {
            try{
                val respuesta = ApiRepository().getCats()
                Log.d("respuesta",respuesta.toString())
                listaGatos.addAll(respuesta)
                miAdaptador.notifyDataSetChanged()
            }catch (ex:Exception){
                Log.e("ERROR API","${ex.message}")
            }
        }





        val miRecycler: RecyclerView = findViewById(R.id.rvGatos)

        miRecycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        //miRecycler.layoutManager = GridLayoutManager(this,2)
        //miRecycler.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        miRecycler.adapter = miAdaptador


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}