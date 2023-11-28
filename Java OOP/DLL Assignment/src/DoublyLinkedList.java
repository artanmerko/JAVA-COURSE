public class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    //backward
    public void printValuesBackward() {
        Node runner = tail;
        while (runner != null) {
            System.out.println(runner.value);
            runner = runner.prev;
        }
    }

    // pop
    public Node pop() {
        if (tail == null) {
            return null;
        }
        Node poppedNode = tail;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        return poppedNode;
    }

    // check if value
    public boolean contains(Integer value) {
        Node runner = head;
        while (runner != null) {
            if (runner.value == value) {
                return true;
            }
            runner = runner.next;
        }
        return false;
    }

    // return the size of the list
    public int size() {
        int count = 0;
        Node runner = head;
        while (runner != null) {
            count++;
            runner = runner.next;
        }
        return count;
    }

    // insertAt
    public void insertAt(Node newNode, int index) {
        if (index < 0 || (index > 0 && head == null)) return;
        if (index == 0) {
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            return;
        }
        Node runner = head;
        for (int i = 0; i < index - 1; i++) {
            if (runner.next == null) break;
            runner = runner.next;
        }
        newNode.next = runner.next;
        if (runner.next != null) {
            runner.next.prev = newNode;
        } else {
            tail = newNode;
        }
        runner.next = newNode;
        newNode.prev = runner;
    }

    // removeAt
    public void removeAt(int index) {
        if (index < 0 || head == null) return;
        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            return;
        }
        Node runner = head;
        for (int i = 0; i < index; i++) {
            if (runner.next == null) return;
            runner = runner.next;
        }
        if (runner.next != null) {
            runner.next.prev = runner.prev;
        } else {
            tail = runner.prev;
        }
        runner.prev.next = runner.next;
    }

    //isPalindrome
    public boolean isPalindrome() {
        Node left = head;
        Node right = tail;
        while (left != null && right != null && left != right && right.next != left) {
            if (left.value != right.value) {
                return false;
            }
            left = left.next;
            right = right.prev;
        }
        return true;
    }
}
