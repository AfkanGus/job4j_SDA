package ru.job4j;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 1. Что такое итератор. [#4951 #246649]
 */
class ArrayIteratorTest {
    /*метод проверяет что при многократном вызове метод вернет true*/
    @Test
    void whenMultiCallhasNextThenTrue() {
        /*Создается новый экзм класса, иницилз массивом 1,2,3*/
        ArrayIterator iterator = new ArrayIterator(
                new int[]{1, 2, 3}
        );
        /*проверяем что вызов hasNext возвращ true на первой итерации.*/
        assertTrue(iterator.hasNext());
        /*на данный момент point все еще равно 0, так как hasNext не изменяет point
         * поэтому и второй вызов возвращает true*/
        assertTrue(iterator.hasNext());
    }

    /*метод проверяет что next возвращает правильные элементы массива в
     * последовательном порядке*/
    @Test
    void whenReadSequence() {
        ArrayIterator iterator = new ArrayIterator(
                new int[]{1, 2, 3}
        );
        /*тут проверяется что первый элемент возвращаемый методом
         * равен 1. при первом вызове метода next итератор берет
         * первый элемент массива и увеличивает индекс*/
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.next()).isEqualTo(3);
    }

    @Test
    void whenNextFromEmpty() {
        ArrayIterator iterator = new ArrayIterator(
                new int[]{}
        );
        assertThatThrownBy(iterator::next).isInstanceOf(NoSuchElementException.class);
    }
}