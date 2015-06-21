package me.hyunbin.colors;

/**
 * Created by Hyunbin on 5/26/2015.
 * Google Material Color Palette: http://www.google.com/design/spec/style/color.html#color-color-palette
 */
public class ColorParse {

    public static final int[] mainPalette = Palettes.mainPalette;
    public static final int[][] fullPalette = Palettes.fullPalette;

    /**
     * Calculates closest material color based on input color
     * @param color the hex value of the color to be materialized
     * @param refine set true to return the most accurate material color, set false to return a default 500 value
     */
    public static int approximateColor(int color, boolean refine){
        int ans = 0;
        double curDistance;
        double bestDistance = Double.MAX_VALUE;
        int bestIndex = 0;
        for(int i = 0; i < mainPalette.length; i++){
            curDistance = colorDistance(color, mainPalette[i]);
            if(curDistance < bestDistance){
                bestDistance = curDistance;
                ans = mainPalette[i];
                bestIndex = i;
            }
        }
        if(!refine) return ans;
        else return refine(color, bestIndex);
    }

    /**
     * Refines the color approximation by looking through an identified 500 value's family
     * @param color the hex value of the color to be materialized
     * @param identifier the index for fullPalette, identifies the color family based on 500 value
     */
    public static int refine(int color, int identifier) {
        int ans = 0;
        double curDistance;
        double bestDistance = Double.MAX_VALUE;
        int[] palette = fullPalette[identifier];
        for(int i = 0; i < palette.length; i++){
            curDistance = colorDistance(color, palette[i]);
            if(curDistance < bestDistance){
                bestDistance = curDistance;
                ans = palette[i];
            }
        }
        return ans;
    }

    /**
     * Wrapper function with only color param, defaults to refine
     * @param color the hex value of the color to be materialized
     */
    public static int approximateColor(int color) {
        return approximateColor(color, true);
    }

    /**
     * Wrapper function that allows hex value to be input as a string. Accepts '#' as part of the input
     * @param color the hex value of the color to be materialized
     * @param refine set true to return the most accurate material color, set false to return a default 500 value
     */
    public static int approximateColor(String color, boolean refine) {
        int c = hexstringToInt(color);
        return approximateColor(c, refine);
    }

    /**
     * Wrapper function that allows hex value to be input as a string. Accepts '#' as part of the input. Defaults to refine
     * @param color the hex value of the color to be materialized
     */
    public static int approximateColor(String color) {
        int c = hexstringToInt(color);
        return approximateColor(c, true);
    }

    public static int hexstringToInt(String hexstring) {
        // if '#' is included in input, get rid of it
        if(hexstring.contains("#")) hexstring = hexstring.substring(1);
        return Integer.parseInt(hexstring, 16);
    }

    /**
     * http://stackoverflow.com/questions/6334311/whats-the-best-way-to-round-a-color-object-to-the-nearest-color-constant
     * formula comes from: http://www.compuphase.com/cmetric.htm
     * TLDR: Human vision perception weighs R,G,B differently,
     *       so we need to adjust the weights of the values in our calculation
     */
    private static double colorDistance(int c1, int c2) {
        int red1 = getRed(c1);
        int red2 = getRed(c2);
        int rMean = (red1 + red2) >> 1;
        int r = red1 - red2;
        int g = getGreen(c1) - getGreen(c2);
        int b = getBlue(c1) - getBlue(c2);
        return Math.sqrt((((512+rMean)*r*r)>>8) + 4*g*g + (((767-rMean)*b*b)>>8));
    }

    private static int getRed(int color){
        // make sure we're only dealing with 6 digit hex
        return (color & 0xffffff) >> 16;
    }

    private static int getGreen(int color){
        // make sure we're only dealing with 6 digit hex
        return (color & 0x00ffff) >> 8;
    }

    private static int getBlue(int color){
        // make sure we're only dealing with 6 digit hex
        return color & 0x0000ff;
    }

    public static void testColorParse(int color){
        System.out.println("Input:    " + Integer.toHexString(color).toUpperCase());
        System.out.println("Red:      " + Integer.toHexString(getRed(color)).toUpperCase());
        System.out.println("Green:    " + Integer.toHexString(getGreen(color)).toUpperCase());
        System.out.println("Blue:     " + Integer.toHexString(getBlue(color)).toUpperCase());
        System.out.println("Material: " + Integer.toHexString(approximateColor(color, false)).toUpperCase());
        System.out.println("Refined:  " + Integer.toHexString(approximateColor(color, true)).toUpperCase());
        System.out.println("Refined2: " + Integer.toHexString(approximateColor(color)).toUpperCase());
    }

    public static void testColorParse(String color){
        System.out.println("Input:    " + color.toUpperCase());
        System.out.println("Material: " + Integer.toHexString(approximateColor(color, false)).toUpperCase());
        System.out.println("Refined:  " + Integer.toHexString(approximateColor(color, true)).toUpperCase());
        System.out.println("Refined2: " + Integer.toHexString(approximateColor(color)).toUpperCase());
    }

}
