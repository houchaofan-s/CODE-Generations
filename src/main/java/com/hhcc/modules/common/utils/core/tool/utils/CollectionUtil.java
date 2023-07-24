package com.hhcc.modules.common.utils.core.tool.utils;

import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class CollectionUtil extends CollectionUtils {

    public static <T> boolean contains(@Nullable T[] array, final T element) {
        return array == null ? false : Arrays.stream(array).anyMatch((x) -> {
            return ObjectUtil.nullSafeEquals(x, element);
        });
    }

    public static boolean isArray(Object obj) {
        return null == obj ? false : obj.getClass().isArray();
    }

    public static boolean isNotEmpty(@Nullable Collection<?> coll) {
        return !CollectionUtils.isEmpty(coll);
    }

    public static boolean isNotEmpty(@Nullable Map<?, ?> map) {
        return !CollectionUtils.isEmpty(map);
    }
}
