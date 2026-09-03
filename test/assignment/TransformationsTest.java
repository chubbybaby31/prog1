package assignment;

import org.junit.jupiter.api.Test;

import static assignment.ImageEffect.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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

    @Test
    public void testNoRed() {
        final int BLACK = makePixel(0, 0, 0);
        final int RED = makePixel(255, 0, 0);


        int[][] pixels = {
                { BLACK, RED, BLACK },
                { RED, BLACK, RED },
                { BLACK, RED, BLACK }
        };

        int[][] expected = {
                { BLACK, BLACK, BLACK },
                { BLACK, BLACK, BLACK },
                { BLACK, BLACK, BLACK }
        };

        ImageEffect noRedEffect = new NoRed();

        int[][] actual = noRedEffect.apply(pixels, new ArrayList<>());

        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                assertEquals(getRed(expected[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expected[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expected[i][j]), getBlue(actual[i][j]));
            }
        }

    }

    @Test
    public void testNoBlue() {
        final int BLACK = makePixel(0, 0, 0);
        final int BLUE = makePixel(0, 0, 255);


        int[][] pixels = {
                { BLACK, BLUE, BLACK },
                { BLUE, BLACK, BLUE },
                { BLACK, BLUE, BLACK }
        };

        int[][] expected = {
                { BLACK, BLACK, BLACK },
                { BLACK, BLACK, BLACK },
                { BLACK, BLACK, BLACK }
        };

        ImageEffect noBlueEffect = new NoBlue();

        int[][] actual = noBlueEffect.apply(pixels, new ArrayList<>());

        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                assertEquals(getRed(expected[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expected[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expected[i][j]), getBlue(actual[i][j]));
            }
        }

    }
 
    @Test
    public void testNoGreen() {

        final int BLACK = makePixel(0, 0, 0);
        final int GREEN = makePixel(0, 255, 0);

        int[][] pixels = {
                { BLACK, GREEN, BLACK },
                { GREEN, BLACK, GREEN },
                { BLACK, GREEN, BLACK }
        };

        int[][] expected = {
                { BLACK, BLACK, BLACK },
                { BLACK, BLACK, BLACK },
                { BLACK, BLACK, BLACK }
        };

        ImageEffect noGreenEffect = new NoGreen();
        int[][] actual = noGreenEffect.apply(pixels, new ArrayList<>());

        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                assertEquals(getRed(expected[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expected[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expected[i][j]), getBlue(actual[i][j]));
            }
        }
    }

    @Test
    public void testOnlyRed() {

        final int RED = makePixel(255, 0, 0);
        final int GREEN = makePixel(0, 255, 0);
        final int BLUE = makePixel(0, 0, 255);
        final int BLACK = makePixel(0, 0, 0);

        int[][] pixels = {
                { RED, GREEN, BLUE },
                { GREEN, BLUE, RED },
                { BLUE, RED, GREEN }
        };

        int[][] expected = {
                { RED, BLACK, BLACK },
                { BLACK, BLACK, RED },
                { BLACK, RED, BLACK }
        };

        ImageEffect onlyRedEffect = new RedOnly();
        int[][] actual = onlyRedEffect.apply(pixels, new ArrayList<>());

        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                assertEquals(getRed(expected[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expected[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expected[i][j]), getBlue(actual[i][j]));
            }
        }
    }

    @Test
    public void testOnlyBlue() {

        final int RED = makePixel(255, 0, 0);
        final int GREEN = makePixel(0, 255, 0);
        final int BLUE = makePixel(0, 0, 255);
        final int BLACK = makePixel(0, 0, 0);

        int[][] pixels = {
                { RED, GREEN, BLUE },
                { GREEN, BLUE, RED },
                { BLUE, RED, GREEN }
        };

        int[][] expected = {
                { BLACK, BLACK, BLUE },
                { BLACK, BLUE, BLACK },
                { BLUE, BLACK, BLACK }
        };

        ImageEffect onlyBlueEffect = new BlueOnly();
        int[][] actual = onlyBlueEffect.apply(pixels, new ArrayList<>());

        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                assertEquals(getRed(expected[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expected[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expected[i][j]), getBlue(actual[i][j]));
            }
        }
    }

    @Test
    public void testOnlyGreen() {

        final int RED = makePixel(255, 0, 0);
        final int GREEN = makePixel(0, 255, 0);
        final int BLUE = makePixel(0, 0, 255);
        final int BLACK = makePixel(0, 0, 0);

        int[][] pixels = {
                { RED, GREEN, BLUE },
                { GREEN, BLUE, RED },
                { BLUE, RED, GREEN }
        };

        int[][] expected = {
                { BLACK, GREEN, BLACK },
                { GREEN, BLACK, BLACK },
                { BLACK, BLACK, GREEN }
        };

        ImageEffect onlyGreenEffect = new GreenOnly();
        int[][] actual = onlyGreenEffect.apply(pixels, new ArrayList<>());

        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                assertEquals(getRed(expected[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expected[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expected[i][j]), getBlue(actual[i][j]));
            }
        }
    }
   
    @Test
    public void testBlackAndWhite() {

        final int RED = makePixel(255, 0, 0);
        final int GREEN = makePixel(0, 255, 0);
        final int BLUE = makePixel(0, 0, 255);
        final int WHITE = makePixel(255, 255, 255);
        final int GRAY_85 = makePixel(85, 85, 85);
        final int BLACK = makePixel(0, 0, 0);

        int[][] pixels = {
                { RED, GREEN, BLUE },
                { WHITE, BLACK, RED },
                { GREEN, BLUE, WHITE }
        };

        int[][] expected = {
                { GRAY_85, GRAY_85, GRAY_85 },
                { WHITE, BLACK, GRAY_85 },
                { GRAY_85, GRAY_85, WHITE }
        };

        ImageEffect blackAndWhiteEffect = new BlackAndWhite();
        int[][] actual = blackAndWhiteEffect.apply(pixels, new ArrayList<>());

        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                assertEquals(getRed(expected[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expected[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expected[i][j]), getBlue(actual[i][j]));
            }
        }
    }

    @Test
    public void testHorizontalReflect() {

        final int RED = makePixel(255, 0, 0);
        final int GREEN = makePixel(0, 255, 0);
        final int BLUE = makePixel(0, 0, 255);
        final int BLACK = makePixel(0, 0, 0);
        final int WHITE = makePixel(255, 255, 255);
        final int GRAY = makePixel(128, 128, 128);

        int[][] pixels = {
                { RED, GREEN, BLUE },
                { BLACK, WHITE, GRAY },
                { BLUE, BLACK, RED }
        };

        int[][] expected = {
                { BLUE, BLACK, RED },
                { BLACK, WHITE, GRAY },
                { RED, GREEN, BLUE }
        };

        ImageEffect horizontalReflect = new HorizontalReflect();
        int[][] actual = horizontalReflect.apply(pixels, new ArrayList<>());

        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testVerticalReflect() {

        final int RED = makePixel(255, 0, 0);
        final int GREEN = makePixel(0, 255, 0);
        final int BLUE = makePixel(0, 0, 255);
        final int BLACK = makePixel(0, 0, 0);
        final int WHITE = makePixel(255, 255, 255);
        final int GRAY = makePixel(128, 128, 128);

        int[][] pixels = {
                { RED, GREEN, BLUE },
                { BLACK, WHITE, GRAY },
                { BLUE, BLACK, RED }
        };

        int[][] expected = {
                { BLUE, GREEN, RED },
                { GRAY, WHITE, BLACK },
                { RED, BLACK, BLUE }
        };

        ImageEffect verticalReflect = new VerticalReflect();
        int[][] actual = verticalReflect.apply(pixels, new ArrayList<>());

        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testGrow() {

        final int RED = makePixel(255, 0, 0);
        final int GREEN = makePixel(0, 255, 0);
        final int BLUE = makePixel(0, 0, 255);
        final int WHITE = makePixel(255, 255, 255);

        int[][] pixels = {
                { RED, GREEN },
                { BLUE, WHITE }
        };

        int[][] expected = {
                { RED, RED, GREEN, GREEN },
                { RED, RED, GREEN, GREEN },
                { BLUE, BLUE, WHITE, WHITE },
                { BLUE, BLUE, WHITE, WHITE }
        };

        ImageEffect growEffect = new Grow();
        int[][] actual = growEffect.apply(pixels, new ArrayList<>());

        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testShrink() {

        final int RED = makePixel(200, 0, 0);
        final int GREEN = makePixel(0, 200, 0);
        final int BLUE = makePixel(0, 0, 200);
        final int WHITE = makePixel(200, 200, 200);

        final int RED_GREEN_AVG = makePixel(100, 100, 0);
        final int BLUE_WHITE_AVG = makePixel(100, 100, 200);

        int[][] pixels = {
                { RED, GREEN, RED, GREEN },
                { GREEN, RED, GREEN, RED },
                { BLUE, WHITE, BLUE, WHITE },
                { WHITE, BLUE, WHITE, BLUE }
        };

        int[][] expected = {
                { RED_GREEN_AVG, RED_GREEN_AVG },
                { BLUE_WHITE_AVG, BLUE_WHITE_AVG }
        };

        ImageEffect shrinkEffect = new Shrink();
        int[][] actual = shrinkEffect.apply(pixels, new ArrayList<>());

        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testThreshold() {
    
        final int BELOW = makePixel(50, 100, 120);
        final int EQUAL = makePixel(127, 127, 127);
        final int ABOVE = makePixel(200, 150, 255);
        final int MIXED = makePixel(200, 50, 127);
    
        final int BLACK = makePixel(0, 0, 0);
        final int ABOVE_EXPECTED = makePixel(255, 255, 255);
        final int MIXED_EXPECTED = makePixel(255, 0, 0);
    
        int[][] pixels = {
                { BELOW, EQUAL },
                { ABOVE, MIXED }
        };
    
        int[][] expected = {
                { BLACK, BLACK },
                { ABOVE_EXPECTED, MIXED_EXPECTED }
        };
    
        ImageEffect thresholdEffect = new Threshold();
        thresholdEffect.params.get(0).setValue(127);
        int[][] actual = thresholdEffect.apply(pixels, thresholdEffect.params);
    
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(getRed(expected[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expected[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expected[i][j]), getBlue(actual[i][j]));
            }
        }
    }
    
    @Test
    public void testNonUniformImage() {

        final int RED = makePixel(255, 0, 0);
        final int GREEN = makePixel(0, 255, 0);
        final int BLUE = makePixel(0, 0, 255);
        final int WHITE = makePixel(255, 255, 255);
        final int BLACK = makePixel(0, 0, 0);

        int[][] pixels = {
                { RED, GREEN, BLUE },
                { WHITE },
                { BLUE, BLACK, GREEN, RED },
                { BLACK, WHITE }
        };

        ImageEffect[] effects = {
                new NoRed(),
                new NoGreen(),
                new NoBlue(),
                new RedOnly(),
                new GreenOnly(),
                new BlueOnly(),
                new BlackAndWhite(),
                new HorizontalReflect(),
                new VerticalReflect(),
                new Grow(),
                new Shrink(),
                new Threshold()
        };

        for (ImageEffect effect : effects) {
            try {
                effect.apply(pixels, new ArrayList<>());
            } catch (Exception e) {
                fail(effect.getClass().getSimpleName() + " failed on a jagged array: "
                        + e.getClass().getSimpleName());
            }
        }
    }

    @Test
    public void testShrinkOddDimensions() {

        final int RED = makePixel(255, 0, 0);
        final int GREEN = makePixel(0, 255, 0);
        final int BLUE = makePixel(0, 0, 255);
        final int WHITE = makePixel(255, 255, 255);

        int[][] pixels = {
                { RED, RED, GREEN, GREEN, BLUE },
                { RED, RED, GREEN, GREEN, BLUE },
                { BLUE, BLUE, WHITE, WHITE, RED },
                { BLUE, BLUE, WHITE, WHITE, RED },
                { GREEN, GREEN, RED, RED, BLUE }
        };

        int[][] expected = {
                { RED, GREEN },
                { BLUE, WHITE }
        };

        ImageEffect shrinkEffect = new Shrink();
        int[][] actual = shrinkEffect.apply(pixels, new ArrayList<>());

        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(getRed(expected[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expected[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expected[i][j]), getBlue(actual[i][j]));
            }
        }
    }

}
