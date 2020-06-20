# App Theming: Typography

To start learning the Android Desgin System I will show you first how to apply it only with the typography. 
In next articles I will try to do the same for colors and shapes.

# 1. Add Fonts to your project

Lets start simply by adding a font for our app.

Since Android 8.0 fonts can be used as resources. For previous version you can use the Support Library 26.  

First create the `font` folder under `res` folder. Secondly add your fonts there. Names must be lower case und with under scores. Like other xmls in Android.

![img](imgs/font-folder.png) 

And finally create your font family resources xml. Here is where the definitions of your fonts will be.

`comic_neue.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<font-family xmlns:app="http://schemas.android.com/apk/res-auto">

  <font
    app:font="@font/comic_neue_regular"
    app:fontStyle="normal"
    app:fontWeight="400" />

  <font
    app:font="@font/comic_neue_bold"
    app:fontStyle="normal"
    app:fontWeight="700" />

  <font
    app:font="@font/comic_neue_light"
    app:fontStyle="normal"
    app:fontWeight="200" />

  <font
    app:font="@font/comic_neue_italic"
    app:fontStyle="italic"
    app:fontWeight="400" />

</font-family>
```

> * `fontWeight` : Positive number, a multiple of 100, and between 100 and 900, inclusive. The most common values are 400 for regular weight and 700 for bold weight.
> * `fontStyle`: `normal` or `italic`         


> Using in Support Library: Declare font families in XML, using the `app` namespace.
https://developer.android.com/guide/topics/ui/look-and-feel/fonts-in-xml

We have everything set up. Now let use it.

#### We can us them directly in the view
```xml
  <TextView
    ... 
    android:fontFamily="@font/comic_neue"/>
```
#### Or we can better create a style
```xml
  <TextView
    ...
    style="@style/MyFontStyle"/>
```
```xml
  <style name="MyFontStyle">
    ...
    <item name="fontFamily">@font/comic_neue_bold</item>
  </style>
```
#### But what we really want is to use the Android built in Design System




## Attributes vs Styles (in typefaces)
So the attributes are the one taht change dinamically and are in the MD Documentation. They are:
```  
   textAppearanceBody1
   textAppearanceBody2
   textAppearanceButton
   textAppearanceCaption
   textAppearanceHeadline1
   textAppearanceHeadline2
   textAppearanceHeadline3
   textAppearanceHeadline4
   textAppearanceHeadline5
   textAppearanceHeadline6
   textAppearanceOverline
   textAppearanceSubtitle1
   textAppearanceSubtitle2
```
These ones are used by the Android Theme System so you can put then in any xml view something like:
```xml
  <TextView
  ...
  android:textAppearance="?attr/textAppearanceHeadline5" />
```

And Android will apply the current styling values(size, font...) for the `textAppearanceHeadline5` attribute.
These are attributes and are stored in the MD library as references. Right click on it and you will find its definition:
```xml
<attr format="reference" name="textAppearanceHeadline5"/>
```
A similar but different thing are the styles.
Android internally associate each attribute with a style. For exmaple for the attribute `textAppearanceBody1` the style that it is directing is
`TextAppearance.AppCompat.Body1`.
> Note: There are not styles `TextAppearance.AppCompat.Headline5/4/3...` but there are `TextAppearance.AppCompat.Display1/2/3`
As you see there are differnt libraries with different purpouses one for the attrs and one for the styles

# Where are the attriubutes set for the default theme? 


`androidx.appcompat` vs `com.google.android.material`
# Easy Hierarchy



# Automatic settings
In the the specific button we dont have to set the type textAppearance, it will get the one set for the attribute



# In Next articles
Hierarchy 
Overlap
DarkMode
Multi Brand