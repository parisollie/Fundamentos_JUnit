package com.cursosant.fundamentosjunit

import org.junit.*
import org.junit.Assert.*


class AssertionsUsersTest {
    //V-24,Paso 1.11, ponemos variables globales
    private lateinit var bot: User

    //Paso 1.18, ponemos el companion object
    companion object{
        private lateinit var juan: User

        //Paso 1.17, le ponemos BeforesClass y AfterClass
        @BeforeClass @JvmStatic
        fun setupCommon(){
            juan = User("Juan", 18, true)
            println("BeforeClass")
        }

        @AfterClass @JvmStatic
        fun tearDownCommon(){
            juan = User()
            println("AfterClass")
        }
    }

    //Paso 1.12, se ejecuta antes de cada prueba
    @Before
    fun setup(){
        bot = User("8bit", 1, false)
        println("Before")
    }

    //V-25,Paso 1.13, se ejecuta despues de cada prueba
    @After
    fun tearDown(){
        //Una nueva instancia del user
        bot = User()
        println("After")
    }

    //Paso 1.14
    @Test
    fun checkHumanTest() {
        val assertions = Assertions()
        assertFalse(assertions.checkHuman(bot))
        assertTrue(assertions.checkHuman(juan))
        println("checkHuman")
    }

    //V-16,Paso 1.15
    @Test
    fun checkNotNullUserTest(){
        assertNotNull(juan)
        println("checkNotNullUser")
    }

    //V-26, paso 1.19, es  importante para analizar
    @Test
    fun checkNotSameUsersTest(){
        assertNotSame(bot, juan)
        println("checkNotSameUsers")
    }

    @Test
    fun checkSameUsersTest(){
        val copyJuan = juan
        assertSame(copyJuan, juan)
        println("checkSameUsers")
    }
}

/*
Nos imprimira esto al final en la consola :

BeforeClass
Before
checkSameUsers
After
Before
checkHuman
After
Before
checkNotSameUsers
After
Before
checkNotNullUser
After
AfterClass
 */