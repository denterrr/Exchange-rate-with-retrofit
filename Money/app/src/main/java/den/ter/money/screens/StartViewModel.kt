package den.ter.money.screens

import android.app.Application
import androidx.lifecycle.*

import den.ter.money.data.repository.Repository
import den.ter.money.model.Dengi
import den.ter.money.model.DengiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class StartViewModel(application: Application): AndroidViewModel(application) {

    var repo = Repository()
    val myMoneyList: MutableLiveData<Response<Dengi>> = MutableLiveData()


    fun getMoney(){
        viewModelScope.launch {
            myMoneyList.value = repo.getVal()
        }
    }

}