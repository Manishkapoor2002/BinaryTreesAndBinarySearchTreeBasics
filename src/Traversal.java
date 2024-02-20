

public class Traversal {


    public static void preOrder(Node root){
        if(root == null) return;
//       print:
        System.out.print(root.val + " , ");

//        left:
        preOrder(root.left);
//        right:
        preOrder(root.right);

    }

    public static void inOrder(Node root){
        if(root == null) return;

//        left:
        inOrder(root.left);

//       print:
        System.out.print(root.val + " , ");
//        right:
        inOrder(root.right);

    }

    public static void postOrder(Node root){
        if(root == null) return;

//        left:
        postOrder(root.left);
//        right:
        postOrder(root.right);
//       print:
        System.out.print(root.val + " , ");

    }
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
        System.out.print("Pre Order Traversal : -> ");
        preOrder(root);
        System.out.println();
        System.out.print("In Order Traversal : -> ");
        inOrder(root);
        System.out.println();
        System.out.print("Post Order Traversal : -> ");
        postOrder(root);

    }
}