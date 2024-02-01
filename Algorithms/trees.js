class BTNode {
    constructor(value) {
        this.val = value;
        this.left = null;
        this.right = null;
    }
}

class BST {
    constructor() {
        this.root = null;
    }

    // Method to add a new value to the BST
    add(val) {
        const newNode = new BTNode(val);
        if (!this.root) {
            this.root = newNode;
        } else {
            this._insertNode(this.root, newNode);
        }
    }

    _insertNode(node, newNode) {
        if (newNode.val < node.val) {
            if (!node.left) {
                node.left = newNode;
            } else {
                this._insertNode(node.left, newNode);
            }
        } else {
            if (!node.right) {
                node.right = newNode;
            } else {
                this._insertNode(node.right, newNode);
            }
        }
    }

    // Method to check if the BST contains a given value
    contains(val) {
        return this._contains(this.root, val);
    }

    _contains(node, val) {
        if (!node) {
            return false;
        }

        if (val === node.val) {
            return true;
        } else if (val < node.val) {
            return this._contains(node.left, val);
        } else {
            return this._contains(node.right, val);
        }
    }

    // Method to find the minimum value in the BST
    min() {
        if (!this.root) {
            return null;
        }
        let current = this.root;
        while (current.left) {
            current = current.left;
        }
        return current.val;
    }

    // Method to find the maximum value in the BST
    max() {
        if (!this.root) {
            return null;
        }
        let current = this.root;
        while (current.right) {
            current = current.right;
        }
        return current.val;
    }

    // Method to calculate the number of nodes in the BST
    size() {
        return this._size(this.root);
    }

    _size(node) {
        if (!node) {
            return 0;
        }
        return 1 + this._size(node.left) + this._size(node.right);
    }

    // Method to check if the BST is empty
    isEmpty() {
        return this.root === null;
    }
}

// Example usage:
const myBST = new BST();
myBST.add(5);
myBST.add(3);
myBST.add(7);

console.log(myBST.contains(3));
console.log(myBST.contains(6));
console.log(myBST.min());
console.log(myBST.max());
console.log(myBST.size());
console.log(myBST.isEmpty());
