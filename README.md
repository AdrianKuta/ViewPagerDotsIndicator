# View Pager(2) dots indicator

This repository was created to present you implemented dots indicator
either for `ViewPager` or `ViewPager2`.


## How to implement View Pager dots indicator?

All we need are: [ViewPager][1], [TabLayout][2] and 2 drawables for
selected and default dots.

Firstly, we have to add `TabLayout` to our screen layout, and connect it
with `ViewPager`. We can do this in two ways:


### Nested `TabLayout` in `ViewPager`

```xml
<androidx.viewpager.widget.ViewPager
    android:id="@+id/photos_viewpager"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <com.google.android.material.tabs.TabLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
</androidx.viewpager.widget.ViewPager>
```

> In this case `TabLayout` will be automatically connected with
> `ViewPager`, but `TabLayout` will be next to `ViewPager`, not over it.

### Separate `TabLayout`

```xml
<androidx.viewpager.widget.ViewPager
    android:id="@+id/photos_viewpager"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>

<com.google.android.material.tabs.TabLayout
    android:id="@+id/tab_layout"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"/>
```

> In this case, we can put `TabLayout` anywhere, but we have to connect
> `TabLayout` with `ViewPager` programmatically

```java
ViewPager pager = (ViewPager) view.findViewById(R.id.photos_viewpager);
PagerAdapter adapter = new PhotosAdapter(getChildFragmentManager(), photosUrl);
pager.setAdapter(adapter);

TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
tabLayout.setupWithViewPager(pager, true);
```

Once we created our layout, we have to prepare our dots. So we create
three files: `selected_dot.xml`, `default_dot.xml` and
`tab_selector.xml`.

### selected_dot.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<layer-list xmlns:android="http://schemas.android.com/apk/res/android">
    <item>
        <shape
            android:innerRadius="0dp"
            android:shape="ring"
            android:thickness="8dp"
            android:useLevel="false">
            <solid android:color="@color/colorAccent"/>
        </shape>
    </item>
</layer-list>
```

### default_dot.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<layer-list xmlns:android="http://schemas.android.com/apk/res/android">
    <item>
        <shape
            android:innerRadius="0dp"
            android:shape="ring"
            android:thickness="8dp"
            android:useLevel="false">
            <solid android:color="@android:color/darker_gray"/>
        </shape>
    </item>
</layer-list>
```

### tab_selector.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">

    <item android:drawable="@drawable/selected_dot"
          android:state_selected="true"/>

    <item android:drawable="@drawable/default_dot"/>
</selector>
```

---

Now we need to add only 3 lines of code to `TabLayout` in our XML
layout.

```xml
app:tabBackground="@drawable/tab_selector"
app:tabGravity="center"
app:tabIndicatorHeight="0dp"
```



*[ViewPager with dots indicator][3] at medium.com*

*Up-votes are welcome ;-)*

[1]:
https://developer.android.com/reference/androidx/viewpager/widget/ViewPager?hl=en
[2]: https://developer.android.com/reference/com/google/android/material/tabs/TabLayout?hl=en
[3]: https://medium.com/@adrian.kuta93/android-viewpager-with-dots-indicator-a34c91e59e3a

