# MaterialColors
A simple library to approximate RGB colors to their Material Design counterparts.

## Getting Started
Import the [MaterialColors.jar](../master/MaterialColors.jar) at the root of this project as a dependency into your project. Ta-da!

Alternatively, copy the following two files into your project directory: 

1. [ColorParse.java](../master/src/me/hyunbin/colors/ColorParse.java), which contains selection logic
2. [Palettes.java](../master/src/me/hyunbin/colors/Palettes.java), which contains material color values

## Usage
All color parsing methods are static, so there is no need to initialize an object. Simply use the following two functions:

```java
/**
 * Calculates closest material color based on input color
 * @param color: the hex value of the color to be materialized
 * @param refine: set true to return the most accurate material color, set false to return a default 500 value
 */
ColorParse.approximateColor(int color, boolean refine);
```

```java
/**
 * Refines the color approximation by looking through an identified 500 value's family
 * @param color: the hex value of the color to be materialized
 * @param identifier: the index for fullPalette, identifies the color family based on 500 value
*/
ColorParse.refine(int color, int identifier);
```
That's it!

## Contributors
Made by the superhero [Varun Munjeti](https://github.com/vrunjeti) and his sidekick [Hyunbin Park](https://github.com/hyunbin) on a cold and starless night. 
