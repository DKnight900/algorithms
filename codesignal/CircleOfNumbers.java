package codesignal;

import java.util.HashMap;
import java.util.Map;

public class CircleOfNumbers {
    public static void main(String[] args) {
        System.out.println(circleOfNumbers(10, 2));
        System.out.println(circleOfNumbers(6, 3));
        System.out.println(circleOfNumbers(18, 6));
    }

    static int circleOfNumbers(int n, int firstNumber) {
        DoubleCircleLinkedList doubleCircleLinkedList = new DoubleCircleLinkedList();

        for (int i = 0; i < n; i++) {
            doubleCircleLinkedList.addNode(i);
        }

        return doubleCircleLinkedList.findMaxDistance(firstNumber);
    }

    private static class DoubleCircleLinkedList {
        private Node head;

        public int findMaxDistance(int value) {
            Node currentNode = head;
            Node nodeFound = null;
            do {
                if (currentNode.value == value) {
                    nodeFound = currentNode;
                    break;
                }
                currentNode = currentNode.next;
            } while (currentNode != head);

            int valueOfNodeWithRadialDistance = 0;
            if(nodeFound != null) {
                int clockwiseDistance;
                int antiClockwiseDistance;
                Map<String, String> a = new HashMap<>();

                currentNode = nodeFound.next;
                do {
                    clockwiseDistance = computeClockwiseDistance(nodeFound, currentNode);
                    antiClockwiseDistance = computeAntiClockwiseDistance(nodeFound, currentNode);
                    if (clockwiseDistance == antiClockwiseDistance) {
                        valueOfNodeWithRadialDistance = currentNode.value;
                    }
                    currentNode = currentNode.next;
                } while (currentNode != nodeFound);
            }


            return valueOfNodeWithRadialDistance;
        }

        public int computeClockwiseDistance(Node head, Node destinationNode) {
            int clockwiseDistance = 0;
            for(Node currentNode = head; currentNode != destinationNode; currentNode = currentNode.next) {
                clockwiseDistance++;
            }
            return clockwiseDistance;
        }

        public int computeAntiClockwiseDistance(Node head, Node destinationNode) {
            int clockwiseDistance = 0;
            for(Node currentNode = head; currentNode != destinationNode; currentNode = currentNode.previous) {
                clockwiseDistance++;
            }
            return clockwiseDistance;
        }

        public void addNode(int value) {
            if(this.isEmpty()) {
                head = new Node(value);
            }
            else {
                Node currentNode = head;
                do {
                    if (currentNode.next == null || currentNode.next == head) {
                        Node newNode = new Node(value);
                        currentNode.next = newNode;
                        newNode.previous = currentNode;
                        newNode.next = head;
                        head.previous = newNode;
                        break;
                    }
                    currentNode = currentNode.next;
                } while (currentNode != null && currentNode != head);
            }
        }

        public boolean isEmpty() {
            return head == null;
        }

        public void print() {
            if (this.isEmpty()) {
                System.out.println("Empty list");
                return;
            }
            Node currentNode = head;
            do {
                System.out.print(currentNode.value + " -> ");
                currentNode = currentNode.next;
            } while (currentNode != head && currentNode != null);
        }
    }

    private static class Node {
        private Node next;
        private Node previous;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
