package assignment;
/**
 *
 * CS314H Programming Assignment 1 - Java image processing
 *
 * Included is the Invert effect from the assignment.  Use this as an
 * example when writing the rest of your transformations.  For
 * convenience, you should place all of your transformations in this file.
 *
 * You can compile everything that is needed with
 * javac -d bin src/assignment/*.java
 *
 * You can run the program with
 * java -cp bin assignment.JIP
 *
 * Please note that the above commands assume that you are in the prog1
 * directory.
 */

import java.util.ArrayList;

class Invert extends ImageEffect {
    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixels[y][x] = ~pixels[y][x];
            }
        }
        return pixels;
    }
}

class NoRed extends ImageEffect {
    public int[][] apply(int[][] pixels, ArrayList<ImageEffectParam> params) {
        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[r].length; c++) {
                pixels[r][c] = makePixel(0, getGreen(pixels[r][c]), getBlue(pixels[r][c]));
            }
        }
        return pixels;
    }
}

class NoGreen extends ImageEffect {
    public int[][] apply(int[][] pixels, ArrayList<ImageEffectParam> params) {
        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[r].length; c++) {
                pixels[r][c] = makePixel(getRed(pixels[r][c]), 0, getBlue(pixels[r][c]));
            }
        }
        return pixels;
    }
}

class NoBlue extends ImageEffect {
    public int[][] apply(int[][] pixels, ArrayList<ImageEffectParam> params) {
        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[r].length; c++) {
                pixels[r][c] = makePixel(getRed(pixels[r][c]), getGreen(pixels[r][c]), 0);
            }
        }
        return pixels;
    }
}

class RedOnly extends ImageEffect {
    public int[][] apply(int[][] pixels, ArrayList<ImageEffectParam> params) {
        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[r].length; c++) {
                pixels[r][c] = makePixel(getRed(pixels[r][c]), 0, 0);
            }
        }
        return pixels;
    }
}

class GreenOnly extends ImageEffect {
    public int[][] apply(int[][] pixels, ArrayList<ImageEffectParam> params) {
        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[r].length; c++) {
                pixels[r][c] = makePixel(0, getGreen(pixels[r][c]), 0);
            }
        }
        return pixels;
    }
}

class BlueOnly extends ImageEffect {
    public int[][] apply(int[][] pixels, ArrayList<ImageEffectParam> params) {
        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[r].length; c++) {
                pixels[r][c] = makePixel(0, 0, getBlue(pixels[r][c]));
            }
        }
        return pixels;
    }
}

class BlackAndWhite extends ImageEffect {
    public int[][] apply(int[][] pixels, ArrayList<ImageEffectParam> params) {
        int avg;
        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[r].length; c++) {
                avg = getRed(pixels[r][c]) + getGreen(pixels[r][c]) + getBlue(pixels[r][c]);
                pixels[r][c] = makePixel(avg, avg, avg);
            }
        }
        return pixels;
    }
}

class VirticalReflect extends ImageEffect {
    public int[][] apply(int[][] pixels, ArrayList<ImageEffectParam> params) {
        int temp_pixel;
        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[r].length / 2; c++) {
                temp_pixel = pixels[r][c];
                pixels[r][c] = pixels[r][pixels[r].length - 1 - c];
                pixels[r][pixels[r].length - 1 - c] = temp_pixel;
            }
        }
        return pixels;
    }
}

class HorizontalReflect extends ImageEffect {
    public int[][] apply(int[][] pixels, ArrayList<ImageEffectParam> params) {
        int[] temp_pixel;
        for (int r = 0; r < pixels.length / 2; r++) {
            temp_pixel = pixels[r];
            pixels[r] = pixels[pixels.length - 1 - r];
            pixels[pixels.length - 1 - r] = temp_pixel;
        }
        return pixels;
    }
}

class Dummy extends ImageEffect {

    public Dummy() {
        super();
        params = new ArrayList<ImageEffectParam>();
        params.add(new ImageEffectParam("ParamName",
                                           "Description of param.",
                                           10, 0, 1000));
    }

    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        // Use params here.
        return pixels;
    }
}
