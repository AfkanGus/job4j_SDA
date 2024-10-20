package ru.job4j;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 1. ��� ����� ��������. [#4951 #246649]
 */
class ArrayIteratorTest {
    /*����� ��������� ��� ��� ������������ ������ ����� ������ true*/
    @Test
    void whenMultiCallhasNextThenTrue() {
        /*��������� ����� ���� ������, ������� �������� 1,2,3*/
        ArrayIterator iterator = new ArrayIterator(
                new int[]{1, 2, 3}
        );
        /*��������� ��� ����� hasNext ������� true �� ������ ��������.*/
        assertTrue(iterator.hasNext());
        /*�� ������ ������ point ��� ��� ����� 0, ��� ��� hasNext �� �������� point
         * ������� � ������ ����� ���������� true*/
        assertTrue(iterator.hasNext());
    }

    /*����� ��������� ��� next ���������� ���������� �������� ������� �
     * ���������������� �������*/
    @Test
    void whenReadSequence() {
        ArrayIterator iterator = new ArrayIterator(
                new int[]{1, 2, 3}
        );
        /*��� ����������� ��� ������ ������� ������������ �������
         * ����� 1. ��� ������ ������ ������ next �������� �����
         * ������ ������� ������� � ����������� ������*/
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