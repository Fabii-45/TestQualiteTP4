package modele.operations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class TestSomme{

    private Somme somme;

    @Test
    public void testGetResultatOK(){

        Operations operations = mock(Operations.class);
        somme = new Somme(operations);
        Assertions.assertDoesNotThrow(()->somme.getResultat(1,2));
        Assertions.assertEquals(3, somme.getResultat(1,2));

    }
}
