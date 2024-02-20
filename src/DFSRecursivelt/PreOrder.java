package DFSRecursivelt;

public class PreOrder {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.right.left = new Node(7);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);
        traversal(root);
    }
    public static void traversal(Node root){
        if(root == null) return;
//       print:
        System.out.print(root.val + " , ");

//        left:
        traversal(root.left);
//        right:
        traversal(root.right);

    }
}
class Node{
    int val;
    Node left;
    Node right;


    public Node(int data){
        this.val = data;
        this.left = null;
        this.right = null;
    }
}