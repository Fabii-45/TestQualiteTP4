package modele.operations;


import modele.exceptions.NonSupporteeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collection;

import static org.mockito.Mockito.*;

public abstract class TestOperations {


    private Operations operations;

    public abstract Operations getInstanceTestOperations();

    public void OperationsImpl(){
        this.operations = this.getInstanceTestOperations();
    }

    @BeforeEach
    public void initialisation(){
        operations = this.getInstanceTestOperations();
    }

    @Test
    public void testGetResultatOK() throws NonSupporteeException {
        double operand1 = 2;
        double operand2 = 4;
        String operation = "Somme";
        double petitGetResultat = 6;
        double resultat = 6;

        this.operations=spy(Operations.class);

        doReturn(operation).when(this.operations).getNomOperation();
        doReturn(petitGetResultat).when(this.operations).getResultat(operand1,operand2);

        Assertions.assertDoesNotThrow(() -> this.operations.getResultat(operation,operand1,operand2));
        Assertions.assertEquals(resultat, this.operations.getResultat(operation,operand1,operand2));
    }

    @Test
    public void testGetResultatNonSupporteeKO() throws NonSupporteeException {
        double operand1 = 2;
        double operand2 = 4;
        String operation = "Lalalalalalala";
        double petitGetResultat = 6;

        this.operations=spy(Operations.class);

        doReturn(petitGetResultat).when(this.operations).getResultat(operand1,operand2);

        Assertions.assertThrows(NonSupporteeException.class,()->this.operations.getResultat(operation,operand1,operand2));
    }

    @Test
    public void testGetResultatNextOK() throws NonSupporteeException {
        double operand1 = 2;
        double operand2 = 4;
        String operation = "Somme";
        String operation2 = "Soustraction";
        Operations getNext = mock(Operations.class);
        double getResult = -2;
        double resultat = -2;

        this.operations=spy(Operations.class);

        doReturn(operation).when(this.operations).getNomOperation();
        doReturn(getNext).when(this.operations).getNext();
        doReturn(getResult).when(getNext).getResultat(operation2,operand1,operand2);


        Assertions.assertDoesNotThrow(() -> this.operations.getResultat(operation2,operand1,operand2));
        Assertions.assertEquals(resultat, this.operations.getResultat(operation2,operand1,operand2));
    }

    public void testGetOperations() {

        double resultat = 6;

        this.operations=spy(Operations.class);

        doReturn(null).when(this.operations).getNext();

        Assertions.assertDoesNotThrow(() -> this.operations.getOperations());
        Assertions.assertEquals(resultat, this.operations.getOperations());
    }






}
