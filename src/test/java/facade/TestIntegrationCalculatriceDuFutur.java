package facade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class TestIntegrationCalculatriceDuFutur {

    private CalculatriceDynamiqueDuFutur calculatriceDynamiqueDuFutur;

    public abstract CalculatriceDynamiqueDuFutur getInstance();

    @BeforeEach
    public void initialisation(){
        this.calculatriceDynamiqueDuFutur = this.getInstance();
    }

    @Test
    public void testInputDigitMoins1(){
        Assertions.assertDoesNotThrow(()->this.calculatriceDynamiqueDuFutur.inputDigit(-1));
    }

    @Test
    public void testInputDigitDeux() {
        Assertions.assertDoesNotThrow(() -> this.calculatriceDynamiqueDuFutur.inputDigit(2));
    }

    @Test
    public void testInputDigit(){
        Assertions.assertDoesNotThrow(()->this.calculatriceDynamiqueDuFutur.inputDigit(2));
    }
}
