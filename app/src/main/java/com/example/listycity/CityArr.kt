package com.example.listycity

class CityArr(){  // not to be confused with a Sh... Arr
    private val _cityList:ArrayList<City> = ArrayList()
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
        sort_City()
    }


    private fun sort_City(){
        _cityList.sortBy {it.name} // define it.name city->city.name // sortBy expects lambda function
    }

    fun get_CityArr(): List<City>{
        return _cityList
    }

    fun add_City(city:City){
        if (!_cityList.any {it.name == city.name}) {
            _cityList.add(city)
            sort_City()
        }
    }

    fun kill_City(name:String): Int{
        if (_cityList.any {it.name == name}){
            _cityList.removeAll {it.name ==name}
            return 0
        }
        return 1
    }
}

