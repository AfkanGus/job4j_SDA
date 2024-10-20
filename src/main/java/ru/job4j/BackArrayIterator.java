package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 1. Что такое итератор. [#4951 #246649]
 * Реализуйте итератор для массива. Итератор должен
 * отдавать элементы в обратном порядке.
 */
public class BackArrayIterator implements Iterator<Integer> {
    private final int[] data;
    private int point;

    /*надо установить point на последний элемент массива*/
    public BackArrayIterator(int[] data) {
        this.data = data;
        this.point = data.length - 1;
    }

    /*когад hasNext вернет true или false
     * True если point болььше или = 0
     * False если все элементы пройдены*/
    @Override
    public boolean hasNext() {
        return point >= 0;
    }

    /*возвращает текущий элемент и перемещает указатель
     * на предыдущий элемент массива*/
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point--];
    }
}
