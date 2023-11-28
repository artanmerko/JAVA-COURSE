public class SinglyLinkedList {
    public Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while (runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }

    public void remove() {
        if (head != null) {
            if (head.next == null) {
                head = null;
            } else {
                Node runner = head;
                while (runner.next.next != null) {
                    runner = runner.next;
                }
                runner.next = null;
            }
        }
    }

    public void printValues() {
        Node runner = head;
        while (runner != null) {
            System.out.println(runner.value);
            runner = runner.next;
        }
    }

    // Ninja 1
    public Node find(int value) {
        Node runner = head;
        while (runner != null) {
            if (runner.value == value) {
                return runner;
            }
            runner = runner.next;
        }
        return null;
    }
    // Ninja 2
    public void removeAt(int index) {
        if (head == null || index < 0) return;
        if (index == 0) {
            head = head.next;
            return;
        }
        Node runner = head;
        for (int i = 0; i < index - 1; i++) {
            if (runner.next == null) return;
            runner = runner.next;
        }
        if (runner.next != null) {
            runner.next = runner.next.next;
        }
    }
}
