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
  
    addFront(value) {
      const newNode = new Node(value);
      newNode.next = this.head;
      this.head = newNode;
      return this.head;
    }
  
    removeFront() {
      if (!this.head) {
        return null; // List is empty
      }
      const removedNode = this.head;
      this.head = this.head.next;
      return removedNode;
    }
  
    front() {
      if (!this.head) {
        return null; // List is empty
      }
      return this.head.data;
    }
  
    // Method to display all list values as a string
    display() {
      let current = this.head;
      let result = "";
  
      while (current !== null) {
        result += current.data.toString();
        if (current.next !== null) {
          result += ", ";
        }
        current = current.next;
      }
  
      return result;
    }
  }
  
  // Example usage:
  const SLL1 = new SLL();
  console.log(SLL1.addFront(76));
  console.log(SLL1.addFront(2));
  console.log(SLL1.display());
  console.log(SLL1.addFront(11.41));
  console.log(SLL1.display());
  