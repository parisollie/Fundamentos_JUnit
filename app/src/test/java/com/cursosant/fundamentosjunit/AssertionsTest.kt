package com.cursosant.fundamentosjunit

import org.junit.Assert.*
import org.junit.Test
import kotlin.random.Random

//V-17,Paso 1.2, creamos una clase llamada AssertionsUsersAdultTest, para hacer nuestros test
class AssertionsTest{
    //Ponemos Test
    @Test
    fun getArrayTest(){
        val assertions = Assertions()
        //Comprobamos que el arreglo de nuestra variable asertions , este correcta
        val array = arrayOf(21, 117)// valor esperado
        // valor esperado,falla porqué el valor esperado es el 117,paso 1.3
        //val array = arrayOf(21, 11)
        assertArrayEquals("mensaje personalizado de error en testing", array, assertions.getLuckyNumbers())
    }

    //V-19,paso 1.4
    @Test
    fun getNameTest(){
        val assertions = Assertions()
        //El nombre debe ser igual al que declaramos,si declaramos otro, dará error.
        val name = "Paul"
        val otherName = "Andrew"
        assertEquals(name, assertions.getName())
        assertNotEquals(otherName, assertions.getName())
    }

    //Paso 1.6
    @Test
    fun checkHumanTest(){
        val assertions = Assertions()
        val bot = User("8bit", 1, false)
        val juan = User("Juan", 18, true)
        assertFalse(assertions.checkHuman(bot))
        assertTrue(assertions.checkHuman(juan))
    }

    //V-20,paso 1.5
    @Test
    //averiguar si un objeto es null o no
    fun checkNullUserTest(){
        val user = null
        //Le pasamos un objeto ,la misma asersion ya sabe cual es el valor esperado
        assertNull(user)
        val assertions = Assertions()
        assertNull(assertions.checkHuman(user))
    }

    //Paso 1.7, verificar que un usuario no sea null
    @Test
    fun checkNotNullUserTest(){
        val juan = User("Juan", 18, true)
        assertNotNull(juan)
    }

    //V-22,paso 1.8, caso  negado
    @Test
    fun checkNotSameUsersTest(){
        val bot = User("8bit", 1, false)
        val juan = User("Juan", 18, true)
        assertNotSame(bot, juan)
    }

    //Paso 1.9, cuando dos casos ,ambos deben de ser iguales
    @Test
    fun checkSameUsersTest(){
        val bot = User("Juan", 18, true)
        val juan = User("Juan", 18, true)
        val copyJuan = juan
        assertSame(copyJuan, juan)
    }

    //V-23,Paso 1.10 timeOut, simula una peticion a una api
    @Test(timeout = 1_000)
    fun getCitiesTest(){
        val cities = arrayOf("México", "Perú", "Argentina")
        //la probabilidad de que pase de 200 a 1100, ya que le pusimos un timeOut de 1000
        Thread.sleep(Random.nextLong(200, 1_100))
        //Thread.sleep(Random.nextLong(950, 1_050))
        //Valor esperado 3
        assertEquals(3, cities.size)
    }
}