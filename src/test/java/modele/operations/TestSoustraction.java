package modele.operations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class TestSoustraction {

    private Soustraction soustraction;

    @Test
    public void testGetResultatOK(){
        Operations operations = mock(Operations.class);
        soustraction = new Soustraction(operations);
        Assertions.assertDoesNotThrow(()->soustraction.getResultat(12,7));
        Assertions.assertEquals(5, soustraction.getResultat(12,7));
    }
}
