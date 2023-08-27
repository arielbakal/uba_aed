package aed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CoberturaTests {
    Cobertura cobertura = new Cobertura();

    @Test
    void testFizzBuzz() {
        assertEquals(cobertura.fizzBuzz(3),"Fizz");
        assertEquals(cobertura.fizzBuzz(5),"Buzz");
        assertEquals(cobertura.fizzBuzz(15),"FizzBuzz");
        assertEquals(cobertura.fizzBuzz(7),"7");
    }

    @Test
    void testNumeroCombinatorio() {
        assertEquals(cobertura.numeroCombinatorio(1,0),1);
        assertEquals(cobertura.numeroCombinatorio(3,3),1);
        assertEquals(cobertura.numeroCombinatorio(1,2),0);
        assertEquals(cobertura.numeroCombinatorio(8,2),28);
    }

    @Test
    void testRepeticionesConsecutivas() {
        assertEquals(cobertura.repeticionesConsecutivas(new int[0]),0);
        assertEquals(cobertura.repeticionesConsecutivas(new int[]{1}),0);
        assertEquals(cobertura.repeticionesConsecutivas(new int[]{1,2,3}),1);
        assertEquals(cobertura.repeticionesConsecutivas(new int[]{1,1}),2);
        assertEquals(cobertura.repeticionesConsecutivas(new int[]{1,1,2,3,1,1,1,4}),3);
    }
}
