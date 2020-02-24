package tsk2020.CV01;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tsk2020.CV01.App;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @ParameterizedTest(name = "Test trojuhelniku {index}, strany a = {0}, b = {1}, c = {2}, Ocekavany vystup = {3}")
    @MethodSource("edgeProvider")
    public void testParametrizeTriangle(double a, double b, double c, boolean result) {
        assertEquals(result, App.isTriangle(a, b, c));
    }

    static Stream<Arguments> edgeProvider() {
        return Stream.of(
                Arguments.arguments(10, 10, 10, true),
                Arguments.arguments(10, 20, 15, true),
                Arguments.arguments(30, 20, 15, true),
                Arguments.arguments(20, 15, 30, true),
                Arguments.arguments(15, 30, 25, true),
                Arguments.arguments(1.5, 1, 1, true),
                Arguments.arguments(2.1, 3.1, 4.1, true),
                Arguments.arguments(0, 20, 15, false),
                Arguments.arguments(10, 0, 15, false),
                Arguments.arguments(10, 20, 0, false),
                Arguments.arguments(-10, 20, 15, false),
                Arguments.arguments(10, -20, 15, false),
                Arguments.arguments(10, 20, -15, false)
        );
    }
}


