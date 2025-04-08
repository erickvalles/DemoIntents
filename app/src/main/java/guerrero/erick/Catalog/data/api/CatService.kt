package guerrero.erick.Catalog.data.api

import guerrero.erick.Catalog.data.Gato
import retrofit2.http.GET

interface CatService {
    @GET("api/cats?limit=100")
    suspend fun getCats(): List<Gato>

    @GET("api/tags/Angry")
    suspend fun getCatsByTag(): List<Gato>

}