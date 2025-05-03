package com.cursosant.fundamentosjunit

import org.junit.*
import org.junit.Assert.*

class AssertionsUsersAdultTest {

    //V-27, Paso 2.0 reglas
    private lateinit var bot: User
    private lateinit var juan: User

    //Paso 2.4, creamos nuestra regla
    @get:Rule val locationESRule = LocationESRule()

    @Before
    fun setup(){
        bot = User("8bit", 1, false)
        juan = User("Juan", 18, true)
    }

    @After
    fun tearDown(){
        bot = User()
        juan = User()
    }

    @Test
    fun isAdultTest() {
        //Paso 2.1, tiene mas que ver con herencia
        /*val assertions = Assertions()
        assertions.setLocation("ES")
        assertTrue(assertions.isAdult(juan))
        assertTrue(assertions.isAdult(bot))*/
        //Paso 2.5
        assertEquals(true, locationESRule.assertions?.isAdult(juan))
        assertEquals(true, locationESRule.assertions?.isAdult(bot))
    }
}