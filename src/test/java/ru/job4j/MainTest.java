package ru.job4j;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MainTest {

    @Test
    public void whenOnePlusTwo() {
        Main main = new Main();
        int result = main.Add(2, 2);
        assertThat(result, is(4));
    }
}