public class Introduction {
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
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