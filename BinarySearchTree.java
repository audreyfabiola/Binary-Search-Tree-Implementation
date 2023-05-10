//TAKE AWAY EXERCISE//
//Write a function that counts the number of items in a binary tree

public class BinarySearchTree {
    //Represent the node of binary tree
    public static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            //Assign data to the new node, set left and right children to null
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    //Represent the root of binary tree
    public Node root;
    public BinarySearchTree() {
        root = null;
    }

    //Inserting new nodes to the BinarySearchTree
    public void insertNode(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        }
        //Traverse the tree to find the appropriate place to insert the new node
        Node current = root;
        while (true) {
            //The left node must be smaller than the root
            if (data < current.data) {
                if (current.left == null) {
                    current.left = newNode;
                    return;
                }
                current = current.left;
            } else {
                //The right node must be larger than the root
                if (current.right == null) {
                    current.right = newNode;
                    return;
                }
                current = current.right;
            }
        }
    }

    //Printing the tree in inOrder traversal
    public void printInorder(Node node) {
        if (node == null) {
            return;
        } else {
            printInorder(node.left);
            System.out.print(node.data + " ");
            printInorder(node.right);
        }
    }

    //Counting the number of nodes
    public int countNode(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftCount = countNode(node.left);
            int rightCount = countNode(node.right);
            //Add 1 for the root node, then adding it with the total count of the left and right nodes
            return 1 + leftCount + rightCount;
        }
    }

    public static void main(String[] args) {
        //Create the BinarySearchTree
        BinarySearchTree bst = new BinarySearchTree();
        //Insert some nodes
        bst.insertNode(3);
        bst.insertNode(2);
        bst.insertNode(1);
        bst.insertNode(6);
        bst.insertNode(5);
        bst.insertNode(4);
        bst.insertNode(7);

        //Print the tree inOrder traversal
        System.out.print("Tree in order traversal: ");
        bst.printInorder(bst.root);
        System.out.println();

        //Call the countNode function
        int numberOfNodes = bst.countNode(bst.root);
        System.out.println("Number of nodes in the binary search tree: " + numberOfNodes);
    }
}
