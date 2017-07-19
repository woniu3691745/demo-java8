package com.example.java8.optional;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by lidongliang on 2017/7/12.
 * optional
 * Optional 是一个包含或着不包含一个非空值的容器对象
 * <p>
 * 当试图避免空值相关的缺陷，如未捕获的异常时，可以考虑一下是否可使用Optional对象
 * <p>
 * isPresent() 与 obj != null 无任何分别
 */
public class Optiona01 {

    /**
     * 创建某个值得Optional对象
     */
    private void op1() {
        Optional<String> a = Optional.of("a");
        assertEquals("a", a.get());
        assertTrue(a.isPresent());
    }

    /**
     * 1.创建一个空对象
     * 2.讲一个null值转换成Optional对象
     * 3.isPresent检查Optional对象是否有值
     */
    private void op2() {
        Optional emptyOptional = Optional.empty();
        Optional alsoEmpty = Optional.ofNullable(null);

        assertFalse(emptyOptional.isPresent());
        assertEquals("b", emptyOptional.orElse("b"));
        assertEquals("c", emptyOptional.orElseGet(() -> "c"));
    }

    public static void main(String[] args) {

        Optiona01 optiona01 = new Optiona01();
//        optiona01.op1();
        optiona01.op2();
    }
}
