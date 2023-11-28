public class ListTester {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.add(3);
        sll.add(4);
        sll.add(10);
        sll.add(5);
        sll.add(15);
        sll.add(2);
        sll.remove();
        sll.remove();
        sll.printValues();

        // Ninja Test
        Node found = sll.find(10); // use number that are not in list to have not found as result
        if (found != null) {
            System.out.println("Found: " + found.value);
        } else {
            System.out.println("Not found");
        }

        sll.removeAt(2);
        sll.printValues();
    }
}
