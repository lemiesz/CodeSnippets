class TreeNode {

    constructor(data, children) {
        this.data = data;
        this.children = children;
    }    

}

class BST {
    constructor(data) {
        this.data = data;
    }

    setRightChild(node) {
        this.rightChild = node;
    }

    setLeftChild(node) {
        this.leftChild = node;
    }
}

function traverseTree(head) {
    if(head === null) return;

    console.log(head.data)

    if(head.children === null) return;

    head.children.forEach(child => {
        traverseTree(child)
    });

}

A = new BST("A");
B = new BST("B");
C = new BST("C");
D = new BST("D");
E = new BST("E");
F = new BST("F");
G = new BST("G");
Z = new BST("Z");
A.setRightChild(C);
A.setLeftChild(B);
B.setLeftChild(D);
B.setRightChild(E);
C.setLeftChild(F);
C.setRightChild(G);
G.setLeftChild(Z);

function findHeight(head) {
    if(!head) {
        return 0;
    }
    return Math.max(1 + findHeight(head.leftChild), 1 + findHeight(head.rightChild));
}

function preOrderTraversal(head) {
    if(!head) {
        return;
    }
    console.log(head.data);
    preOrderTraversal(head.leftChild);
    preOrderTraversal(head.rightChild);
}

function inOdrerTraversal(head) {
    if(!head) {
        return;
    }
    inOdrerTraversal(head.leftChild);
    console.log(head.data);
    inOdrerTraversal(head.rightChild);
}

function postOrderTraversal(head) {
    if(!head) {
        return;
    }
    postOrderTraversal(head.leftChild);
    postOrderTraversal(head.rightChild);
    console.log(head.data);
}

console.log(postOrderTraversal(A));