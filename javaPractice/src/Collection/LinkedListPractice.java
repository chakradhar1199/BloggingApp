package Collection;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListPractice {
    public static void main(String[] args) {
        ArrayList<String > aList1= new ArrayList<>(Arrays.asList("a","b","c","d"));
        LinkedList<String> l1= new LinkedList<>(aList1);
        l1.add(2,"e");
        System.out.println(l1);

//        Node<String> currentNode = l1.getFirst();
    }

    // Node class representing an element in the LinkedList
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}


