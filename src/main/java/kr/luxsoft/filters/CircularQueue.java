package kr.luxsoft.filters;

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
public class CircularQueue implements Iterable<Double>{
    private double[] data;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.data = new double[capacity];
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

    public void enqueue(double value) {
        if (isFull()) {
            head = (head + 1) % capacity;
        } else {
            size++;
        }
        tail = (tail + 1) % capacity;
        data[tail] = value;
    }


    public double ema(double alpha) {
//        log.info("size : {}, capacity : {}", size, capacity);

        if(size > 1 ){

            double sum = 0.0;
            for (int i = 0; i < (size - 1); i++) {
                sum += data[(head + 1 + i) % capacity];
            }
            double ema =sum/(size-1);
            double last = data[tail];
//            log.info("sum : {}, ema : {}, last : {} ", sum, ema, last);
            return ema*(1-alpha) + last*alpha;

        }else if(size == 1){
            return data[tail];
        }else{
            return 0.0;
        }

    }

    public double[] getElements() {
        double[] elements = new double[size];
        for (int i = 0; i < size; i++) {
            elements[i] = data[(head + 1 + i) % capacity];
        }
        return elements;
    }

    public Iterator<Double> iterator() {
        return new CircularQueueIterator();
    }

    public double getHead() {
        return data[(head+1)%capacity];
    }

    private class CircularQueueIterator implements Iterator<Double> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Double next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            double value = data[(head + 1 + index) % capacity];
            index++;
            return value;
        }
    }
}
