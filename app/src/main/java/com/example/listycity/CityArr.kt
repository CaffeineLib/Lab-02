package com.example.listycity

import androidx.compose.runtime.snapshots.SnapshotStateList

class CityArr(){  // not to be confused with a Sh... Arr
    private val _cityList: SnapshotStateList<City> = SnapshotStateList()
    init{
        for (i in listOf(
            "Victoria",
            "Calgary",
            "Regina",
            "Winnipeg",
            "Toronto",
            "Quebec City",
            "Fredricton",
            "Charlottetown",
            "Halifax",
            "St. John's",
            "Whitehorse",
            "Yellowknife",
            "Iqualuit"
        )){
            _cityList.add(City(i))
        }
        stateSort_City()
    }


    private fun stateSort_City(){
        _cityList.sortBy {it.name}

    }
    fun insert_City(city:City){
        //states are stupid bags
        //not failure of the Liskov Substitution Principal perhaps
        if (!_cityList.any {it.name == city.name}) {
            val n = _cityList.binarySearchBy(city.name){it.name}
            _cityList.add(if (n < 0) -n - 1 else n, city)       // Apparently binary serach can return negative numbers requiring inversion
        }
    }

    fun get_CityArr(): SnapshotStateList<City>{
        return _cityList
    }



    fun del_CityByName(name:String){
        if (_cityList.any {it.name == name}){
            _cityList.removeAll {it.name ==name}
        }
    }
    fun del_CityBySelection(){
        _cityList.removeAll {it.isSelected}
    }
}

