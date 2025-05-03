package com.cursosant.fundamentosjunit

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

//V-29,paso 2.3, creamos una clase llamada LocationESRule y
//heredamos de TestRule
class LocationESRule : TestRule {
    var assertions: Assertions? = null

    override fun apply(base: Statement?, description: Description?): Statement {
        return object : Statement(){
            //Sobreescribimos el metodo evaluate
            override fun evaluate() {
                //Lo instanciamos
                assertions = Assertions()
                assertions?.setLocation("ES")
                try {
                    base?.evaluate()
                } finally {
                    //Liberamos la memoria
                    assertions = null
                }
            }
        }
    }
}