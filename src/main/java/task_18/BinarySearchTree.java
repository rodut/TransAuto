package task_18;

public class BinarySearchTree {
    private static Node root;

    public static void main(String[] args) {
        root = new Node(4);
        System.out.println("Before: ");
        traverseBinaryTree(root);
        System.out.println("\nAfter: ");
        addElement(1);
        addElement(2);
        addElement(3);
        addElement(7);
        traverseBinaryTree(root);
        System.out.println("\nAfter2: ");
        addElement(5);
        traverseBinaryTree(root);
    }

    private static void addElement(int value) {
        root = addElementRecursively(root, value);
    }

    private static Node addElementRecursively(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.left = addElementRecursively(node.left, value);
        } else if (value > node.value) {
            node.right = addElementRecursively(node.right, value);
        }
        return node;
    }

    /**
     *   Starting with the extreme left
     */
    private static void traverseBinaryTree(Node node) {
        if (node != null) {
            traverseBinaryTree(node.left);
            System.out.print(node.value + " ");
            traverseBinaryTree(node.right);
        }
    }
}
