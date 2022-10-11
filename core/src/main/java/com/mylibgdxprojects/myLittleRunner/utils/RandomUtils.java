package com.mylibgdxprojects.myLittleRunner.utils;

import com.mylibgdxprojects.myLittleRunner.enums.ObstaclesType;

import java.util.Random;

public class RandomUtils {

    public static ObstaclesType getRandomEnemyType() {
        RandomEnum<ObstaclesType> randomEnum = new RandomEnum<ObstaclesType>(ObstaclesType.class);
        return randomEnum.random();
    }

    private static class RandomEnum<E extends Enum> {
        private static final Random RND = new Random();
        private final E[] values;

        public RandomEnum(Class<E> token) {
            values = token.getEnumConstants();
        }

        public E random() {
            return values[RND.nextInt(values.length)];
        }
    }
}
