package com.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2018-01-02 17:39
 */
public class ListTest {

    private static List<String> list = Arrays.asList("a", "b", "c", "a", "b", "c");

    public static void main(String[] args) {
        Set<String> uniqueValues = new HashSet<>();
        for (String s : list) {
            if (uniqueValues.add(s)) {
                System.out.println(s);
            }
        }
    }
}
