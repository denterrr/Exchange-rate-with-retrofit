package den.ter.money.data.repository

import den.ter.money.data.api.RetrofitInstance
import den.ter.money.model.Dengi
import den.ter.money.model.DengiModel
import retrofit2.Response

class Repository {
    suspend fun getVal(): Response<Dengi>{
        return RetrofitInstance.api.getMoneys()
    }
}