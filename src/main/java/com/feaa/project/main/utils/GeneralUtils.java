package com.feaa.project.main.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GeneralUtils {

    public static Map<String, String> getColumnValuePair(Object obj, List<String> columnList) throws IllegalAccessException {

        Map<String, String> columnValuePair = new HashMap<>();
        int indexOfColumn = 0;
        for (Field f: obj.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            columnValuePair.put(columnList.get(indexOfColumn), f.get(f).toString());
            indexOfColumn++;
        }

        return columnValuePair;
    }

}
