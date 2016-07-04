package com.cyoutrip.ui;

import com.cyoutrip.R;
import com.cyoutrip.fragment.HomeFragment;


public enum MainTab {

	/*
	NEWS(0, R.string.main_tab_name_news, R.drawable.tab_icon_new,
			NewsViewPagerFragment.class),
			*/

    HOME(0, R.string.home_tab, R.drawable.tab_icon_home,
            HomeFragment.class),

    TOUR(0, R.string.impromptu_tour_tab, R.mipmap.ic_home_black_24dp,
            HomeFragment.class),
    CIRCLE(0, R.string.business_circle_tab, R.mipmap.ic_home_black_24dp,
            HomeFragment.class),
    MY(0, R.string.my_tab, R.mipmap.ic_home_black_24dp,
            HomeFragment.class);

    private int idx;
    private int resName;
    private int resIcon;
    private Class<?> clz;

    private MainTab(int idx, int resName, int resIcon, Class<?> clz) {
        this.idx = idx;
        this.resName = resName;
        this.resIcon = resIcon;
        this.clz = clz;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getResName() {
        return resName;
    }

    public void setResName(int resName) {
        this.resName = resName;
    }

    public int getResIcon() {
        return resIcon;
    }

    public void setResIcon(int resIcon) {
        this.resIcon = resIcon;
    }

    public Class<?> getClz() {
        return clz;
    }

    public void setClz(Class<?> clz) {
        this.clz = clz;
    }
}
