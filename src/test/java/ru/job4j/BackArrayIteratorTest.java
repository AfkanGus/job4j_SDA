package ru.job4j;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.NoSuchElementException;

/**
 * 1. Что такое итератор. [#4951 #246649].
 */
class BackArrayIteratorTest {
    @Test
    void whenMultiCallHasNextThenTrue() {
        BackArrayIterator backArrayIterator = new BackArrayIterator(
                new int[]{1, 2, 3, 4}
        );
        assertThat(backArrayIterator.hasNext()).isTrue();
        assertThat(backArrayIterator.hasNext()).isTrue();
        assertThat(backArrayIterator.next()).isEqualTo(4);
        assertThat(backArrayIterator.next()).isEqualTo(3);
        assertThat(backArrayIterator.hasNext()).isTrue();
    }

    @Test
    void whenMultiCallHasNextThenNext() {
        BackArrayIterator backArrayIterator = new BackArrayIterator(
                new int[]{1, 2, 3}
        );
        assertThat(backArrayIterator.hasNext()).isTrue();
        assertThat(backArrayIterator.hasNext()).isTrue();
        assertThat(backArrayIterator.hasNext()).isTrue();
        assertThat(backArrayIterator.next()).isEqualTo(3);
    }

    @Test
    void whenReadSequence() {
        BackArrayIterator backArrayIterator = new BackArrayIterator(
                new int[]{1, 2, 3}
        );
        assertThat(backArrayIterator.next()).isEqualTo(3);
        assertThat(backArrayIterator.next()).isEqualTo(2);
        assertThat(backArrayIterator.next()).isEqualTo(1);
        assertThat(backArrayIterator.hasNext()).isFalse();
    }

    @Test
    void whenNextFromEmpty() {
        BackArrayIterator backArrayIterator = new BackArrayIterator(
                new int[]{}
        );
        assertThatThrownBy(backArrayIterator::next)
                .isInstanceOf(NoSuchElementException.class);
    }

}