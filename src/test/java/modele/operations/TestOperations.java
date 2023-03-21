package modele.operations;


import modele.exceptions.NonSupporteeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Mockito.*;

public class TestOperations {


    private Operations operations;

    @BeforeEach
    public void initialisation(){
        this.operations=spy(Operations.class);
    }

    @Test
    public void testGetResultatOK() throws NonSupporteeException {
        double operand1 = 2;
        double operand2 = 4;
        String operation = "Somme";
        double petitGetResultat = 6;
        double resultat = 6;

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

        doReturn("Prout").when(this.operations).getNomOperation();
        doReturn(null).when(this.operations).getNext();

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


        doReturn(operation).when(this.operations).getNomOperation();
        doReturn(getNext).when(this.operations).getNext();
        doReturn(getResult).when(getNext).getResultat(operation2,operand1,operand2);


        Assertions.assertDoesNotThrow(() -> this.operations.getResultat(operation2,operand1,operand2));
        Assertions.assertEquals(resultat, this.operations.getResultat(operation2,operand1,operand2));
    }

    @Test
    public void testGetOperations() {
        Collection<String> others = new ArrayList<>();
        others.add("Soustraction");
        String nomOperation = "Soustraction";


        doReturn(null).when(this.operations).getNext();
        doReturn(nomOperation).when(this.operations).getNomOperation();

        Assertions.assertDoesNotThrow(() -> this.operations.getOperations());
        Assertions.assertEquals(others, this.operations.getOperations());
    }

    @Test
    public void testGetOperationsElse() {
        Collection<String> others = new ArrayList<>();
        others.add("Somme");
        Collection<String> result = new ArrayList<>();
        result.add("Somme");
        result.add("Soustraction");

        Operations getNext = mock(Operations.class);

        doReturn(getNext).when(this.operations).getNext();
        doReturn(others).when(getNext).getOperations();
        doReturn("Soustraction").when(this.operations).getNomOperation();

        Assertions.assertEquals(result, this.operations.getOperations());
    }








}
