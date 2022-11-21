package com.legend045.effectivemarvel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.legend045.effectivemarvel.network.MarvelApi
import com.legend045.effectivemarvel.network.marvel.data.HeroesData
import kotlinx.coroutines.launch

enum class MarvelApiStatus {LOADING, ERROR, DONE}

class OverviewViewModel : ViewModel() {

    //Состояние статуса загрузки данных
    private val _status = MutableLiveData<MarvelApiStatus>()
    val status: LiveData<MarvelApiStatus> = _status

    //Состояния которые получают данные.
    private val _heroesData = MutableLiveData<HeroesData>()
    val heroesData: LiveData<HeroesData> = _heroesData

    private val _heroData = MutableLiveData<com.legend045.effectivemarvel.network.marvel.data.Result>()
    var heroData: LiveData<com.legend045.effectivemarvel.network.marvel.data.Result> = _heroData



    init {
        getHeroesData()
        getHeroData()
    }


    private fun getHeroesData() {
        viewModelScope.launch {
            try {
                _heroesData.value = MarvelApi.retrofitService.getData()
                _status.value = MarvelApiStatus.DONE
            } catch (e: Exception) {
                _status.value = MarvelApiStatus.ERROR
                _heroesData.value = null
            }
        }
    }
    private fun getHeroData(){
        viewModelScope.launch {
            _status.value = MarvelApiStatus.LOADING
            try {
                _heroData.value = MarvelApi.retrofitService2.getHero("")
                _status.value = MarvelApiStatus.DONE
            }catch (e: Exception){
                _status.value = MarvelApiStatus.ERROR
                _heroData.value = null
            }
        }
    }
}
