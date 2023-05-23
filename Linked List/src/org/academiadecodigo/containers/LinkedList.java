package org.academiadecodigo.containers;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class LinkedList<T> implements Iterable<T> {

    private Node head;
    private int length = 0;

    public LinkedList() {
        head = new Node(null);
    }

    public int size() {
        return length;
    }

    public void add(T data) {

        Node node = new Node(data);
        Node iterator = head;

        // Advance to the end of the list
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
        }

        iterator.setNext(node);
        length++;
    }
    public int indexOf(T data) {

        int index = 0;
        Node iterator = head.getNext();

        while (iterator != null) {

            if (iterator.getData().equals(data)) {
                return index;
            }

            iterator = iterator.getNext();
            index++;
        }

        // Data was not found
        return -1;
    }

    public T get(int index) {

        Node iterator = head.getNext();

        while (iterator != null) {
            if (index == 0) {
                return iterator.getData();
            }

            iterator = iterator.getNext();
            index--;
        }

        return null;
    }

    public boolean remove(T data) {

        Node previous = head;
        Node iterator = head.getNext();

        while (iterator != null) {

            if (iterator.getData().equals(data)) {
                previous.setNext(iterator.getNext());
                length--;
                return true;
            }

            previous = iterator;
            iterator = iterator.getNext();

        }

        return false;
    }


    public <R> LinkedList<R> map(Function<T, R> mapper) {

        LinkedList<R> toReturn = new LinkedList<>();

        for (T element : this) {
            toReturn.add(mapper.apply(element));
        }

        return toReturn;
    }

    public LinkedList<T> filter(Predicate<T> predicate) {

        LinkedList<T> toReturn = new LinkedList<>();

        for (T element : this) {

            if (predicate.test(element)) {
                toReturn.add(element);
            }
        }

        return toReturn;
    }

    public T reduce(BinaryOperator<T> reducer, T accumulator) {

        for (T element : this) {

            accumulator = reducer.apply(accumulator, element);
        }

        return accumulator;
    }


    public boolean anyMatch(Predicate<T> predicate) {

        for (T element : this) {

            if (predicate.test(element)) {
                return true;
            }
        }

        return false;
    }

    public boolean allMatch(Predicate<T> predicate) {

        for (T element : this) {
            if (!predicate.test(element)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append("LinkedList{ ");

        for (T element : this) {
            builder.append(" ")
                    .append(element)
                    .append(" ,");
        }

        builder.append("}");

        return builder.toString();
    }

    private class ListIterator implements Iterator<T> {

        Node iterator = head;

        @Override
        public boolean hasNext() {
            return iterator.next != null;
        }

        @Override
        public T next() {
            iterator = iterator.getNext();
            return iterator.getData();
        }

        @Override
        public void remove() {
            LinkedList.this.remove(iterator.getData());
        }
    }

    private class Node {


        private Node next;

        private T data;

        public Node(T data) {
            this.data = data;
            next = null;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

}
