# App Theming: Typography

To start learning the Android Desgin System I will show you first how to apply it only with the typography. 
In next articles I will try to do the same for colors and shapes.

# 1. Add Fonts to your project

Lets start simply by adding a font for our app.

Since Android 8.0 fonts can be used as resources. For previous version you can use the Support Library 26.  

First create the `font` folder under `res` folder. Secondly add your fonts there. Names must be lower case und with under scores. Like other xmls in Android.

<img src="imgs/font-folder.png" alt="font-folder" width="350"/>


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

### We can us them directly in the view
```xml
  <TextView
    ... 
    android:fontFamily="@font/comic_neue"/>
```
### Or we can better create a style
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
### But what we really want is to use the Android built in Design System

# Let start with the built in styles
Andorid  AppCompat Library and the Material Design library offer us a set of premade styles that we can use or modify.
Like for example the `TextAppearance.AppCompat.Display1`
We can use it like any other `style`
```xml
<TextView
    style="@style/TextAppearance.AppCompat.Display1"
```

Right Clicking and following the path we can reach the definition of the style. In this case `TextAppearance.AppCompat.Display1` inherits from `Base.TextAppearance.AppCompat.Display1` that results in this definition:
```xml
    <style name="Base.TextAppearance.AppCompat.Display1">
        <item name="android:textSize">@dimen/abc_text_size_display_1_material</item>
        <item name="android:textColor">?android:textColorSecondary</item>
    </style>
```
> Note: We will get later to what is `?android:textColorSecondary`

Same happens with the Material Design Library. For `TextAppearance.MaterialComponents.Body1` we can see that it inherits from an appcompat style.

```xml
<style name="TextAppearance.MaterialComponents.Body1" parent="TextAppearance.AppCompat.Body2">
```

This is really cool. We can get some premeade styles to create our Design System and tweek them instead of building them from scratch.

First question whould be: Is there a list of all these cool styles?

There predefined styles for AppCompat and for Material Design Libraries.
This one is a part from the `TextAppearance` styles from the AppCompat Library.
<img src="imgs/appcompat-styles.png" alt="font-folder" width="800"/>

These looks big and overwhelming but don't worry we are getting to simplify all of it.

# The Material Design Type System
Lets stop for a second looking to code and check the [Material Design documentation](https://material.io/design/typography/the-type-system.html#type-scale) about typography.

There you can see that it is defined the **Type Scale** Main 2 points of its definition are:
> A range of contrasting styles that support the needs of your product and its content.

> A combination of thirteen styles that are supported by the type system. It contains reusable categories of text, each with an intended application and meaning.

Basically it says that they defined 13 styles that should be enough for any application. 


Here are they:

<img src="imgs/type-scale.png" alt="font-folder" width="800"/>


They are used in all the Material Design Definitions. So if you go to the MD documentation, and look for a component you will find the corresponding type scale associated to each element.
In the [List component on the Theming section/typography ](https://material.io/components/lists#theming) you can see how they use the Type scale to define the styles of the differnt list components. 

<img src="imgs/type-scale-sample.png" alt="font-folder" width="600"/>

Let's go back to Android

# Theme attributes vs View attributes (in less than 50 words)

The new Android Theme System defines Theme attributes. Lets see how they differ from the View attributes.

These are view attribute. Applied to a single view.  `android:textColor=red`, `android:fontFamily="@font/comic_neue"`. 

These are theme attribute. Applied to a theme. Used widely. Theme provides them and vary them `colorPrimary = red`,  `textAppearanceBody1 = ... `. These are defined in a Theme and they have an extra feature that View Attributes don't have.

*You can define them in your theme and they will be the same in all the application.* (Change)

```xml
  <style name="Base.Theme.MyApp" parent="Theme.MaterialComponents.DayNight.DarkActionBar">
    <item name="textAppearanceBody1">@style/TextAppearance.MyApp.Body1</item>
  </style>
```
To use them just call them with the `?attr` key word first.

```xml
  <TextView
  ...
  android:textAppearance="?attr/textAppearanceBody1" />
```

Ok after some theory lets go back to code.

# Android text appearance attributes
We are talking about typography, so which are the theme attributes for typograppy. 
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

Material Design Docs said 13 whould be enough and Adnroid provide us with these 13 theme attributes

All these theme attributes are set to a specific pre made style, and as we did before with the premade styles we can do it with the theme attributes.

```xml
  <TextView
  ...
  android:textAppearance="?attr/textAppearanceHeadline5" />
```

To know which are the default styles that it uses we just need to follow the path of the theme. Right click on the theme, follow the thread until you find the style.
For `Theme.MaterialComponents.DayNight.DarkActionBar` you can reach how `textAppearanceBody1` is set to the style `TextAppearance.MaterialComponents.Body1`
```xml
<item name="textAppearanceBody1">@style/TextAppearance.MaterialComponents.Body1</item>
```


<img src="imgs/find-style.gif" alt="font-folder" width="800"/>

You can see that we end up in `Base.V14.Theme.MaterialComponents.Light.Bridge` 


The full list of Type styles in the Material Design library are these ones. 

```xml
    <!-- Type styles -->
    <item name="textAppearanceHeadline1">@style/TextAppearance.MaterialComponents.Headline1</item>
    <item name="textAppearanceHeadline2">@style/TextAppearance.MaterialComponents.Headline2</item>
    <item name="textAppearanceHeadline3">@style/TextAppearance.MaterialComponents.Headline3</item>
    <item name="textAppearanceHeadline4">@style/TextAppearance.MaterialComponents.Headline4</item>
    <item name="textAppearanceHeadline5">@style/TextAppearance.MaterialComponents.Headline5</item>
    <item name="textAppearanceHeadline6">@style/TextAppearance.MaterialComponents.Headline6</item>
    <item name="textAppearanceSubtitle1">@style/TextAppearance.MaterialComponents.Subtitle1</item>
    <item name="textAppearanceSubtitle2">@style/TextAppearance.MaterialComponents.Subtitle2</item>
    <item name="textAppearanceBody1">@style/TextAppearance.MaterialComponents.Body1</item>
    <item name="textAppearanceBody2">@style/TextAppearance.MaterialComponents.Body2</item>
    <item name="textAppearanceCaption">@style/TextAppearance.MaterialComponents.Caption</item>
    <item name="textAppearanceButton">@style/TextAppearance.MaterialComponents.Button</item>
    <item name="textAppearanceOverline">@style/TextAppearance.MaterialComponents.Overline</item>
```

Now we can use theme as base for our custom Type Styles.

# Creating custom Theme Styles

To create for example out custom style for the Headline5 we can add it as follows.

First create a under the `res` folder a file called `type.xml`. 

>Instead of creating the style in the `styles.xml` the new recomendation is the one presented in [Developing Themes with Style (Android Dev Summit '19)](https://www.youtube.com/watch?v=Owkf8DhAOSo&t=1999s) (I can't stop recommending this talk.)
<img src="imgs/res-folders.png" alt="res-folder" width="600"/>


Then add your TextAppearance style.
```xml
<style name="TextAppearance.MaterialComponents.Headline5.MyApp">
  <item name="fontFamily">@font/comic_neue_light</item>
</style>
```
## Easy Hierarchy
Dot notation also applies inherintance so this `TextAppearance.MaterialComponents.Headline5.MyApp`  inherits from `TextAppearance.MaterialComponents.Headline5`. You dno't need to specify the parent explicitly.

Finally what we need is to set up this style to our theme attribute in our theme definition.

In your `themes.xml` where you are suppoused to to have your application theme, add the definition.

```xml
<style name="Base.Theme.MyApp" parent="Theme.MaterialComponents.DayNight.DarkActionBar">
  <item name="textAppearanceHeadline5">@style/TextAppearance.MaterialComponents.Headline5.MyApp</item>
</style>
```

Don't forget to add your theme in the manifest.
```xml
<application
...
android:theme="@style/Base.Theme.MyApp">
```

# The end

That is it. Just get the Type styles and override waht you want from them and use the theme attributes in your textviews.
Some widgets will use the theme attribute, so if you have all set you won't need to change nothing on the widget, the estyle will be get apropietrly.

# Questions
Should I use Material Components or AppCompat. As far as I looked at it I would suggest to go with the Material Components, they are more alligned with the Material Documentation. In case you can't add the library go with Appcompat but be awere that some theme atributes does not have the correspondong pre made style. 
Like there is no  `TextAppearance.AppCompat.Subtitle1` or `Headline,2,3,4` but instad `Display1,2,3`. 

# Widgets
As you cans ee in the sample in the Types the Button widget does not set any textAppearance in its definition but it shows the correct Type Style.
In the sample the Custom Tab Has TextView, AppCompatTextView, MaterialTextView, and none of theme set a default Type Style.  I don't know if this is the expected behavior, it is something that will come in the future or simply an error I made. In any case be aware of that.
Like the Material Chip does have a default type style.
So for these widgets you would need to set the textAppearance explicitily. 
------------------------------------------------------------------
------------------------------------------------------------------
------------------------------------------------------------------
------------------------------------------------------------------
------------------------------------------------------------------
# Where are the attriubutes set for the default theme? 


`androidx.appcompat` vs `com.google.android.material`

> Note: There are not styles `TextAppearance.AppCompat.Headline5/4/3...` but there are `TextAppearance.AppCompat.Display1/2/3`
As you see there are differnt libraries with different purpouses one for the attrs and one for the styles


# Automatic settings
In the specific button we dont have to set the type textAppearance, it will get the one set for the attribute



# In Next articles
Hierarchy 
Overlap
DarkMode
Multi Brand