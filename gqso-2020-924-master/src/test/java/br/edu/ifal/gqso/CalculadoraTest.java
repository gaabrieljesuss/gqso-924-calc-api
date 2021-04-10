package br.edu.ifal.gqso;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ifal.gqso.Calculadora.DivisaoPorZeroException;
import br.edu.ifal.gqso.Calculadora.EntradaInvalidaException;

public class CalculadoraTest {
    private Calculadora calc;

    @BeforeEach
    public void setUp() {
        calc = new Calculadora();
    }

    @Test
    public void testSoma() {
        assertEquals(2, calc.soma(1, 1), "Somar 1+1 deve ser igual a 2");
        assertEquals(0, calc.soma(2, -2), "Somar 2+(-2) deve ser igual a 0");
        assertEquals(0, calc.soma(0, 0), "Somar 0+0 deve ser igual a 0");
    }

    @Test
    public void testDivide() throws DivisaoPorZeroException {
        assertEquals(3, calc.divide(6, 2));
        assertThrows(DivisaoPorZeroException.class, () -> calc.divide(6, 0));
    }

    @Test
    public void testFromString() throws Exception {
        assertEquals(2, calc.fromString("1+1"));
        assertEquals(2, calc.fromString("6/3"));
        assertThrows(EntradaInvalidaException.class,
                () -> calc.fromString("1000000000000000000000000000000000000000000000000000000000000000000+1"));
    }
}
