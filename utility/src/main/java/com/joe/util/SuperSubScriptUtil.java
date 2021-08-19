package com.joe.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SuperSubScriptUtil {
    private static final Map<String, String> superScriptMapping = new HashMap<>();
    private static final Map<String, String> subScriptMapping = new HashMap<>();

    static {
        superScriptMapping.put("0", "⁰");
        superScriptMapping.put("1", "¹");
        superScriptMapping.put("2", "²");
        superScriptMapping.put("3", "³");
        superScriptMapping.put("4", "⁴");
        superScriptMapping.put("5", "⁵");
        superScriptMapping.put("6", "⁶");
        superScriptMapping.put("7", "⁷");
        superScriptMapping.put("8", "⁸");
        superScriptMapping.put("9", "⁹");

        subScriptMapping.put("0", "₀");
        subScriptMapping.put("1", "₁");
        subScriptMapping.put("2", "₂");
        subScriptMapping.put("3", "₃");
        subScriptMapping.put("4", "₄");
        subScriptMapping.put("5", "₅");
        subScriptMapping.put("6", "₆");
        subScriptMapping.put("7", "₇");
        subScriptMapping.put("8", "₈");
        subScriptMapping.put("9", "₉");
    }

    public static String superscript(int num) {
        StringBuilder sup = new StringBuilder();
        for (String s : String.valueOf(num).split("")) {
            sup.append(superScriptMapping.get(s));
        }
        return sup.toString();
    }

    public static String subScript(int num) {
        StringBuilder sub = new StringBuilder();
        for (String s : String.valueOf(num).split("")) {
            sub.append(subScriptMapping.get(s));
        }
        return sub.toString();
    }


}
