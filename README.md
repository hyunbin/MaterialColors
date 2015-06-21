# MaterialColors
A simple library to approximate RGB colors to their Material Design counterparts.

## Getting Started
Import the [MaterialColors.jar](../master/MaterialColors.jar) at the root of this project as a dependency into your project. Ta-da!

Alternatively, copy the following two files into your project directory: 

1. [ColorParse.java](../master/src/me/hyunbin/colors/ColorParse.java), which contains selection logic
2. [Palettes.java](../master/src/me/hyunbin/colors/Palettes.java), which contains material color values

## Usage

**Note:** 
Due to the nature of Java (or IntelliJ), the return value of `approximateColor` will be in base 10, even though it would make sense to return the number in base 16, as a color would be defined. The value is still the same and can be used as you normally would. If you want to see the hex value in base 16, please use the `approximateColorStr` function, but take note that this returns as a String.

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
**Example:** 

`ColorParse.approximateColor(0xADCF83, true)` returns `AED581`, the most accurate closest material color

`ColorParse.approximateColor(0xADCF83, false)` returns `8BC34A`, the main 500 value of the closest material color's family

=============

**Int Color Input Without `refine`**
```java
  ColorParse.approximateColor(int color);
```
**Example:** 

`ColorParse.approximateColor(0xADCF83)` returns `AED581`, the most accurate closest material color

=============

**String Color Input With `refine`**

String color param accepts `'#'` within the input. Both `#ADCF83` and `ADCF83` will return the same result. 
```java
  ColorParse.approximateColor(String color, boolean refine);
```
**Example:**

`ColorParse.approximateColor("#ADCF83", true)` returns `AED581`, the most accurate closest material color

`ColorParse.approximateColor("ADCF83", false)` returns `8BC34A`, the main 500 value of the closest material color's family

=============

**String Color Input Without `refine`**

String color param accepts `'#'` within the input. Both `#ADCF83` and `ADCF83` will return the same result. 
```java
  ColorParse.approximateColor(String color);
```
**Example:**

`ColorParse.approximateColor("#ADCF83")` returns `AED581`, the most accurate closest material color

=============

### approximateColorStr()

Returns the same result as `approximateColor()` as a String instead of as an int. Does not include `'#'` in the return value. The same parameters and options apply. 

**Example:**

`ColorParse.approximateColorStr(0xADCF83)` returns `"AED581"`

`ColorParse.approximateColorStr("#ADCF83", false)` returns `"8BC34A"`

=============

### getColorFamily()

Returns the full material color family palette of the input color

**Parameters**

|   Name   |  Type  | Required? | Description |
|:--------:|:------:|:---------:|:-----------:|
| color | int or String | either int or String required | the 6 digit hex value of the color to be materialized. String input can include `'#'` before the hex value 

**Example:**

`ColorParse.getColorFamily("ADCF83")` returns:
```
  {
    0xF1F8E9,
    0xDCEDC8, 
    0xC5E1A5, 
    0xAED581, 
    0x9CCC65, 
    0x8BC34A, 
    0x7CB342, 
    0x689F38, 
    0x558B2F, 
    0x33691E, 
    0xCCFF90, 
    0xB2FF59, 
    0x76FF03, 
    0x64DD17
  }
```

Notice this is the light green family from [Google's Material Color Palette](http://www.google.com/design/spec/style/color.html#color-color-palette)

## Contributors
Made by the superhero [Varun Munjeti](https://github.com/vrunjeti) and his sidekick [Hyunbin Park](https://github.com/hyunbin) on a cold and starless night. 
