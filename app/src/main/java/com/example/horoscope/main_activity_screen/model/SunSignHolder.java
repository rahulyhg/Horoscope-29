package com.example.horoscope.main_activity_screen.model;

import com.example.horoscope.utils.Const;

import java.util.ArrayList;
import java.util.List;

public class SunSignHolder {

    private static List<SunSign> sSunSigns = new ArrayList<>();

    public static List<SunSign> getLanguageItems() {
        for (int i = 0; i < Const.ZODIAC_SUN_SIGNS.length; i++) {
            sSunSigns.add(new SunSign(i, Const.ZODIAC_SUN_SIGNS[i], Const.ZODIAC_DATES[i], Const.ZODIAC_ICON[i]));
        }
        return sSunSigns;
    }
}
