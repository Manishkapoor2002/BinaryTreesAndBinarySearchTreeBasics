package DFSIteratively;
import java.util.*;

public class InOrder {
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

        ArrayList<Integer> ans = Iterate(root);
        System.out.println(ans);
    }
    public static ArrayList<Integer> Iterate(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<Node> s = new Stack<>();

        Node curr = root;

        while (true){
            if (curr != null){
                s.add(curr);
                curr = curr.left;
            }else {
                if (s.isEmpty()){
                    break;
                }
                Node temp = s.pop();
                list.add(temp.val);
                curr = temp.right;
            }
        }

        return list;
    }




}