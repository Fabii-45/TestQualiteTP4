package modele.operations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class TestPythagore {
    private Pythagore pythagore;

    @Test
    public void testGetResultatOK(){

        Operations operations = mock(Operations.class);
        pythagore = new Pythagore(operations);
        Assertions.assertDoesNotThrow(()->pythagore.getResultat(4,3));
        Assertions.assertEquals(5, pythagore.getResultat(4,3));

    }
}
