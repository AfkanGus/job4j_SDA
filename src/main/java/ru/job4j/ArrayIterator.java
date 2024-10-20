package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 *1. Что такое итератор. [#4951 #246649]
 * класс предоставляет функциональность для итерации по массиву целых чисел*/
public class ArrayIterator implements Iterator<Integer> {
    private final int[] data;
    /*точка текущей позиции в массиве,изначально 0*/
    private int point;

    /*конструктор принимает  массив data и инициализрт поле класса*/
    public ArrayIterator(int[] data) {
        this.data = data;
    }

    /* проверяет есть ли еще элементы в массиве*/
    @Override
    public boolean hasNext() {
        /*метод вернет true если текущая позиция point меньше длины data*/
        return point < data.length;
    }

    /*метод вернет текущий элемент массива по индексу point
     * а затем увеличивает point на 1. Это означает что следующий вызов next()
     * вернет следующий элемент массива*/
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }
}
