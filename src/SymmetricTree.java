import java.util.*;
public class SymmetricTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
//        root.left.right.left = new Node(6);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
//        root.right.right.left = new Node(9);
//        root.right.right.right = new Node(10);
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(Node root) {
        if (root == null){
            return true;
        }else {
            return  check(root.left,root.right);
        }

    }

    public static boolean check(Node left,Node right){
        if (left == null || right == null){
            return left == right;
        }
        if (left.val != right.val) return false;


        return check(left.left,right.right) && check(left.right,right.left);

    }
}