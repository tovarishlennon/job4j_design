package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class SimpleConvertTest {

    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).hasSize(5)
                .endsWith("five")
                .startsWith("first");

    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> strings = simpleConvert.toSet("first", "first", "second", "three", "four");
        assertThat(strings).hasSize(4)
                .doesNotContain("seven")
                .doesNotContainNull()
                .containsExactlyInAnyOrder("first", "second", "three", "four");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> stringIntegerMap = simpleConvert.toMap("first", "second", "three", "four", "five");
        assertThat(stringIntegerMap).hasSize(5)
                .containsKey("first")
                .containsValues(1, 2, 3)
                .doesNotContainValue(6);
    }

}