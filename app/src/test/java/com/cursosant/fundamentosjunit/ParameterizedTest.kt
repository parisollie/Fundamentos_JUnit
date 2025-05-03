package com.cursosant.fundamentosjunit

import org.junit.*
import org.junit.Assert.assertEquals
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


//Paso 3.0 ,parametroizedTest
@RunWith(value = Parameterized::class)
class ParameterizedTest(var currentValue: Boolean, var currentUser: User) {

    //Paso 3.2
    @get:Rule
    val locationESRule = LocationESRule()

    //Paso 3.3
    companion object{
        var assertions: Assertions? = null

        @BeforeClass @JvmStatic
        fun setupCommon(){
            assertions = Assertions()
        }
        @AfterClass
        @JvmStatic
        fun tearDownCommon(){
            assertions = null
        }

        //Paso 3.4, aqui le mandaremos un arreglo de usuarios
        @Parameterized.Parameters @JvmStatic
        /*fun getUsersUS() = arrayOf(
            arrayOf(false, User("Pedro", 12)),
            arrayOf(true, User("Clara", 34)),
            arrayOf(true, User("Bot21", 4, false)),
            arrayOf(false, User("Alex", 18)))*/
        fun getUsersES() = arrayOf(
            arrayOf(true, User("Pedro", 19)),
            arrayOf(false, User("Clara", 14)),
            arrayOf(true, User("Bot21", 4, false)),
            arrayOf(true, User("Alex", 18)))
    }

    //Paso 3.1
    @Test
    fun isAdultTest() {
        //assertEquals(currentValue, assertions?.isAdult(currentUser))
        assertEquals(currentValue, locationESRule.assertions?.isAdult(currentUser))
    }
}