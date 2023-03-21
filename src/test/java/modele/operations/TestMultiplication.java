package modele.operations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class TestMultiplication {

    private Multiplication multiplication;

    @Test
    public void testGetResultatOK(){

        Operations operations = mock(Operations.class);
        multiplication = new Multiplication(operations);
        Assertions.assertDoesNotThrow(()->multiplication.getResultat(12,2));
        Assertions.assertEquals(24, multiplication.getResultat(12,2));

    }
}
