package modele.operations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class TestDivision{

    private Division division;

    @Test
    public void testGetResultatOK(){

        Operations operations = mock(Operations.class);
        division = new Division(operations);
        Assertions.assertDoesNotThrow(()->division.getResultat(12,3));
        Assertions.assertEquals(4, division.getResultat(12,3));

    }
}
