package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisSphereNotBlank() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name)
                .isNotBlank()
                .isNotEmpty();
    }

    @Test
    void numberOfVerticesIsNotMinus1() {
        Box box = new Box(0, 10);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex)
                .isNotEqualTo(-1)
                .isEqualTo(0);
    }

    @Test
    void getNumberOfVertices() {
        Box box = new Box(4, 10);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex).isEqualTo(4)
                .isNotZero()
                .isEven();
    }

    @Test
    void isExist() {
        Box box = new Box(4, 10);
        boolean existence = box.isExist();
        assertThat(existence).isTrue();
    }

    @Test
    void doesNotExist() {
        Box box = new Box(5, 10);
        boolean existence = box.isExist();
        assertThat(existence).isFalse();
    }

    @Test
    void getArea() {
        Box box = new Box(4, 5);
        double existence = box.getArea();
        assertThat(existence).isCloseTo(43.2, withPrecision(0.2d))
                .isGreaterThan(40)
                .isLessThan(45);
    }

    @Test
    void getAreaZero() {
        Box box = new Box(0, 0);
        double existence = box.getArea();
        assertThat(existence).isEqualTo(0).isNotNegative();
    }
}