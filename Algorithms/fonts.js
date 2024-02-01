class Node {
    constructor(data) {
      this.data = data;
      this.next = null;
    }
  }
  
  class SLL {
    constructor() {
      this.head = null;
    }
  
    // Method to add a new node at the front of the list
    addFront(value) {
      const newNode = new Node(value);
      newNode.next = this.head;
      this.head = newNode;
      return this.head;
    }
  
    // Method to remove the head node and return the new head node
    removeFront() {
      if (!this.head) {
        return null; // List is empty
      }
      const removedNode = this.head;
      this.head = this.head.next;
      return removedNode;
    }
  
    // Method to return the value at the head of the list
    front() {
      if (!this.head) {
        return null; // List is empty
      }
      return this.head.data;
    }
  }
  
  // Example usage:
  const SLL1 = new SLL();
  console.log(SLL1.addFront(18));
  console.log(SLL1.addFront(5));
  console.log(SLL1.addFront(73));
  
  console.log(SLL1.removeFront());
  console.log(SLL1.removeFront());
  console.log(SLL1.front());
  