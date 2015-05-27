package me.hyunbin.colors;

/**
 * Created by Hyunbin on 5/26/2015.
 */
public class ColorParse {

    public static final int[] mainPalette = {0xF44336, 0xE91E63, 0x9C27B0, 0x673AB7, 0x3F51B5, 0x2196F3, 0x03A9F4, 0x00BCD4, 0x009688, 0x4CAF50, 0x8BC34A, 0xCDDC39, 0xFFEB3B, 0xFFC107, 0xFF9800, 0xFF5722, 0x795548, 0x9E9E9E, 0x607D8B};

    public static void testColorParse(int color){
        System.out.println("Input:    " + Integer.toHexString(color).toUpperCase());
        System.out.println("Red:      " + Integer.toHexString(getRed(color)).toUpperCase());
        System.out.println("Green:    " + Integer.toHexString(getGreen(color)).toUpperCase());
        System.out.println("Blue:     " + Integer.toHexString(getBlue(color)).toUpperCase());
        System.out.println("Material: " + Integer.toHexString(approximateColor(color)).toUpperCase());
    }

    public static int approximateColor(int color){
        int ans = 0;
        double curDistance;
        double bestDistance = Double.MAX_VALUE;
        for(int i = 0; i < mainPalette.length; i++){
            curDistance = colorDistance(color, mainPalette[i]);
            if(curDistance < bestDistance){
                bestDistance = curDistance;
                ans = mainPalette[i];
            }
        }
        return ans;
    }

    /* http://stackoverflow.com/questions/6334311/whats-the-best-way-to-round-a-color-object-to-the-nearest-color-constant
     * formula comes from: http://www.compuphase.com/cmetric.htm */
    public static double colorDistance(int c1, int c2) {
        int red1 = getRed(c1);
        int red2 = getRed(c2);
        int rmean = (red1 + red2) >> 1;
        int r = red1 - red2;
        int g = getGreen(c1) - getGreen(c2);
        int b = getBlue(c1) - getBlue(c2);
        return Math.sqrt((((512+rmean)*r*r)>>8) + 4*g*g + (((767-rmean)*b*b)>>8));
    }

    public static int getRed(int color){
        // make sure we're only dealing with 6 digit hex
        color = (color & 0xffffff) >> 16;
        return color;
    }

    public static int getGreen(int color){
        // make sure we're only dealing with 6 digit hex
        color = (color & 0x00ffff) >> 8;
        return color;
    }

    public static int getBlue(int color){
        // make sure we're only dealing with 6 digit hex
        color = color & 0x0000ff;
        return color;
    }
}
