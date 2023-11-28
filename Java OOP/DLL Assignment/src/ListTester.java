public class ListTester {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        // adding nodes to the doubly linked list
        dll.insertAt(new Node(1), 0);
        dll.insertAt(new Node(2), 1);
        dll.insertAt(new Node(3), 2);
        dll.insertAt(new Node(4), 3);
        dll.insertAt(new Node(5), 4);

        System.out.println("Original List:");
        dll.printValuesBackward();

        // pop
        Node poppedNode = dll.pop();
        if (poppedNode != null) {
            System.out.println("Popped node value: " + poppedNode.value);
        }

        // check
        System.out.println("Contains 3: " + dll.contains(3));
        System.out.println("Contains 6: " + dll.contains(6));

        // Print the size of the list
        System.out.println("Size of list: " + dll.size());

        // Insert a node
        dll.insertAt(new Node(9), 2);

        // Remove
        dll.removeAt(1);

        // palindrome
        System.out.println("Is palindrome: " + dll.isPalindrome());

        // final state of the list
        System.out.println("Final List:");
        dll.printValuesBackward();
    }
}
