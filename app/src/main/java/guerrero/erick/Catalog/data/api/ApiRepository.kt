package guerrero.erick.Catalog.data.api

import guerrero.erick.Catalog.data.Gato
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiRepository {
    private val catApi: CatService
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://cataas.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        catApi = retrofit.create(CatService::class.java)
    }

    suspend fun getCats():List<Gato> = catApi.getCats()
    suspend fun getCatsByTag():List<Gato> = catApi.getCatsByTag()

}