# MaterialColors
A simple library to approximate RGB colors to their Material Design counterparts.

## Getting Started
Import the [MaterialColors.jar](../master/MaterialColors.jar) at the root of this project as a dependency into your project. Ta-da!

Alternatively, copy the following two files into your project directory: 

1. [ColorParse.java](../master/src/me/hyunbin/colors/ColorParse.java), which contains selection logic
2. [Palettes.java](../master/src/me/hyunbin/colors/Palettes.java), which contains material color values

## Usage
All color parsing methods are static, so there is no need to initialize an object. The `approximateColor` and `approximateColorStr` functions have wrapper functions that support `int` and `String` inputs with an optional `refine` parameter.

### approximateColor()

**Parameters**

|   Name   |  Type  | Required? | Description |
|:--------:|:------:|:---------:|:-----------:|
| color | int or String | either int or String required | the 6 digit hex value of the color to be materialized. String input can include `'#'` before the hex value 
| refine | boolean | optional, defaults to `true` | `true` returns the most accurate material color, `false` returns the default 500 value (based on [Google's Material Color Palette](http://www.google.com/design/spec/style/color.html#color-color-palette))

=============

**Int Color Input With `refine`**
```java
  ColorParse.approximateColor(int color, boolean refine);
```
Example: 

`ColorParse(0xADCF83, true)` returns `AED581`, the most accurate closest material color

`ColorParse(0xADCF83, false)` returns `8BC34A`, the main 500 value of the closest material color's family

=============

**Int Color Input Without `refine`**
```java
  ColorParse.approximateColor(int color);
```
Example: 

`ColorParse(0xADCF83)` returns `AED581`, the most accurate closest material color

=============

**String Color Input With `refine`**

String color param accepts `'#'` within the input. Both `#ADCF83` and `ADCF83` will return the same result. 
```java
  ColorParse.approximateColor(String color, boolean refine);
```
Example: 

`ColorParse("#ADCF83", true)` returns `AED581`, the most accurate closest material color

`ColorParse("ADCF83", false)` returns `8BC34A`, the main 500 value of the closest material color's family

=============

**String Color Input Without `refine`**

String color param accepts `'#'` within the input. Both `#ADCF83` and `ADCF83` will return the same result. 
```java
  ColorParse.approximateColor(String color);
```
Example: 

`ColorParse("#ADCF83")` returns `AED581`, the most accurate closest material color

### approximateColorStr()

Returns the same result as `approximateColor()` as a String instead of as an int. The same parameters and options apply. 

## Contributors
Made by the superhero [Varun Munjeti](https://github.com/vrunjeti) and his sidekick [Hyunbin Park](https://github.com/hyunbin) on a cold and starless night. 
