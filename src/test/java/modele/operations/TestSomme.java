package modele.operations;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

public class TestSomme extends TestOperations{
    @Override
    public Operations getInstanceTestOperations() {
        return new Somme();
    }
}
