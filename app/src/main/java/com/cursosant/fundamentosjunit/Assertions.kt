package com.cursosant.fundamentosjunit

//Paso 1.1, creamos una clase llamada Assertions, para hacer nuestros test
class Assertions {
    private val user = User("Paul", 22)
    private var location = "US"

    fun setLocation(location: String){
        this.location = location
    }

    //Nos devuelve un array de enteros
    fun getLuckyNumbers(): Array<Int>{
        return arrayOf(21, 117)
    }

    //Para saber el nombre del usuario
    fun getName(): String{
        return user.name
    }

    fun checkHuman(user: User): Boolean{
        return user.isHuman
    }

    //sobrecarga de metodos, podria ser un valor null
    fun checkHuman(user: User? = null): Boolean?{
        if (user == null) return null
        return user.isHuman
    }

    fun isAdult(user: User): Boolean{
        //Primero comprobamos que sea humano
        if (!user.isHuman) return true
        //Paso 2.2, si vive en US  y su edad es mayor a 21
        return if (location == "US") user.age >= 21
        else user.age >= 18
    }
}