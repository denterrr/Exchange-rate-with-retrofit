package den.ter.money.data.api

import den.ter.money.model.Dengi
import den.ter.money.model.DengiModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("daily_json.js")
    suspend fun getMoneys(): Response<Dengi>
}