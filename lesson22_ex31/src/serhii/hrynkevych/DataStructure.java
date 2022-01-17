package serhii.hrynkevych;

import java.util.Iterator;

public class DataStructure<T> {
    private final T[] arrayOflnts;

    public DataStructure(T[] arrayOflnts) {
        this.arrayOflnts = arrayOflnts;
    }

    public void printEven() {
        EvenIterator evenIterator = this.new EvenIterator();
        while (evenIterator.hasNext()) {
            System.out.println(evenIterator.next());
        }
    }

    public Iterator<T> evenIterator() {
        return this.new EvenIterator();
    }

    public Iterator<T> evenIterator(int index) {
        return this.new EvenIterator(index);
    }

    private interface ArrayIterator<T> extends Iterator<T> {

    }

    private class EvenIterator implements ArrayIterator<T>{
        int index = 0;

        public EvenIterator() {
        }

        public EvenIterator(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return index < arrayOflnts.length;
        }

        @Override
        public T next() {
            T result = arrayOflnts[index];
            index += 2;
            return result;
        }
    }


}
