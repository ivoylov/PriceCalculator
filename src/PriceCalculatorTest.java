import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class PriceCalculatorTest {

    private final PriceCalculator priceCalculator = new PriceCalculator();

    @Test
    public void shouldThrowExceptionWhenBikeAndDistanceIs0Km() {
        IllegalArgumentException ex = Assertions.assertThrows(
                IllegalArgumentException.class,
                generateExecutable(TransportType.BIKE, 0)
        );

        Assertions.assertEquals("Distance should be more than 0 km", ex.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenBikeAndDistanceIs21Km() {
        IllegalArgumentException ex = Assertions.assertThrows(
                IllegalArgumentException.class,
                generateExecutable(TransportType.BIKE, 21)
        );

        Assertions.assertEquals("Bike can not go for more than 20 km", ex.getMessage());
    }

    @Test
    public void shouldReturn150ForBikeAndDistanceIs20Km() {
        Assertions.assertEquals(200, priceCalculator.calculatePrice(TransportType.BIKE, 20));
    }

    private Executable generateExecutable(TransportType type, int distance) {
        return () -> priceCalculator.calculatePrice(type, distance);
    }

    @Test
    public void shouldThrowExceptionWhenCarAndDistanceIs1001Km() {
        IllegalArgumentException ex = Assertions.assertThrows(
                IllegalArgumentException.class,
                generateExecutable(TransportType.CAR, 1001)
        );

        Assertions.assertEquals("Car can not go for more than 1000 km", ex.getMessage());
    }

    @Test
    public void shouldReturn7000ForCarAndDistanceIs1000Km() {
        Assertions.assertEquals(7000, priceCalculator.calculatePrice(TransportType.CAR, 1000));
    }

    @Test
    public void shouldThrowExceptionWhenCarAndDistanceIs0Km() {
        IllegalArgumentException ex = Assertions.assertThrows(
                IllegalArgumentException.class,
                generateExecutable(TransportType.CAR, 0)
        );

        Assertions.assertEquals("Distance should be more than 0 km", ex.getMessage());
    }

    @Test
    public void shouldReturn5000ForTruckAndDistanceIs1000Km() {
        Assertions.assertEquals(5000, priceCalculator.calculatePrice(TransportType.TRUCK, 1000));
    }

    @Test
    public void shouldThrowExceptionWhenTruckAndDistanceIs0Km() {
        IllegalArgumentException ex = Assertions.assertThrows(
                IllegalArgumentException.class,
                generateExecutable(TransportType.TRUCK, 0)
        );

        Assertions.assertEquals("Distance should be more than 0 km", ex.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenDRONE() {
        UnsupportedOperationException ex = Assertions.assertThrows(
                UnsupportedOperationException.class,
                generateExecutable(TransportType.DRONE, 0)
        );

        Assertions.assertEquals("transport type 'DRONE' is not handled correctly", ex.getMessage());
    }

}