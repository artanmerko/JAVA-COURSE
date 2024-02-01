class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

class SLL {
    constructor() {
        this.head = null;
    }

    // Method to add a new node to the end of the list
    addBack(value) {
        const newNode = new Node(value);
        if (!this.head) {
            this.head = newNode;
        } else {
            let current = this.head;
            while (current.next) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to find the maximum value in the list
    max() {
        if (!this.head) {
            return null; // List is empty
        }
        let current = this.head;
        let maxVal = current.value;
        while (current) {
            if (current.value > maxVal) {
                maxVal = current.value;
            }
            current = current.next;
        }
        return maxVal;
    }

    // Method to find the minimum value in the list
    min() {
        if (!this.head) {
            return null; // List is empty
        }
        let current = this.head;
        let minVal = current.value;
        while (current) {
            if (current.value < minVal) {
                minVal = current.value;
            }
            current = current.next;
        }
        return minVal;
    }

    // Method to calculate the average value in the list
    average() {
        if (!this.head) {
            return null; // List is empty
        }
        let current = this.head;
        let sum = 0;
        let count = 0;
        while (current) {
            sum += current.value;
            count++;
            current = current.next;
        }
        return sum / count;
    }
}

// Example usage:
const myList = new SLL();
myList.addBack(5);
myList.addBack(3);
myList.addBack(7);
console.log(myList.max());
console.log(myList.min());
console.log(myList.average());
