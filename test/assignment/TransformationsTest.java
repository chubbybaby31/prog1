package assignment;

import org.junit.jupiter.api.Test;

import static assignment.ImageEffect.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class TransformationsTest {

    @Test
    public void testInvert() {
        final int WHITE = makePixel(255, 255, 255);
        final int BLACK = makePixel(0, 0, 0);

        int[][] pixels = {
                { WHITE, BLACK, WHITE },
                { BLACK, WHITE, BLACK },
                { WHITE, BLACK, WHITE }
        };

        int[][] expected = {
                { BLACK, WHITE, BLACK },
                { WHITE, BLACK, WHITE },
                { BLACK, WHITE, BLACK }
        };

        ImageEffect invertEffect = new Invert();

        int[][] actual = invertEffect.apply(pixels, new ArrayList<>());

        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                assertEquals(getRed(expected[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expected[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expected[i][j]), getBlue(actual[i][j]));
            }
        }

    }

}
