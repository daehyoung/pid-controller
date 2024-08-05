package kr.luxsoft.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author: Cho, Daehyoung
 * @contact: daehyoung.cho@gmail.com
 * @since: 2024-08-05
 * @version: 1.0
 */
@Slf4j
public class CircularQueue<T> implements Iterable<T>{
    private T[] data;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.data = (T[]) new Object[capacity];
        this.head = -1;
        this.tail = -1;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(T value) {
        if (isFull()) {
            head = (head + 1) % capacity;
        } else {
            size++;
        }
        tail = (tail + 1) % capacity;
        data[tail] = value;
    }

    public <T>  T createInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("Error creating instance of class {}", clazz.getName());
            return null;
        }
    }

    public T[] getElements() {
        T[] elements = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            elements[i] = data[(head + 1 + i) % capacity];
        }
        return elements;
    }


    public T getHead() {
        return data[(head+1)%capacity];
    }

    @Override
    public Iterator<T> iterator() {
        return new CircularQueueIterator();
    }

    private class CircularQueueIterator implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T value = data[(head + 1 + index) % capacity];
            index++;
            return value;
        }
    }

}
