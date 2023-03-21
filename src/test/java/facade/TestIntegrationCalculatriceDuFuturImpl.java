package facade;

public class TestIntegrationCalculatriceDuFuturImpl extends TestIntegrationCalculatriceDuFutur{
    @Override
    public CalculatriceDynamiqueDuFutur getInstance() {
        return new CalculatriceDynamiqueDuFuturImpl();
    }
}
