package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void  parseTestWithoutEqual() {
        NameLoad sm = new NameLoad();
        String s = "Azim";
        assertThatThrownBy(() -> sm.parse(s))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(s);
    }

    @Test
    void  testEmptyParse() {
        NameLoad sm = new NameLoad();
        String s = "";
        assertThatThrownBy(() -> sm.parse(s))
                .isInstanceOf(IllegalArgumentException.class)
                .message()
                .isNotEmpty();
    }

    @Test
    void  parseTestStartingWithEqual() {
        NameLoad sm = new NameLoad();
        String s = "=Azim";
        assertThatThrownBy(() -> sm.parse(s))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(s)
                .hasMessageContaining("key");
    }

    @Test
    void  parseTestEqualNotFound() {
        NameLoad sm = new NameLoad();
        String s = "Azim=";
        assertThatThrownBy(() -> sm.parse(s))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(s)
                .hasMessageContaining("value");
    }


}