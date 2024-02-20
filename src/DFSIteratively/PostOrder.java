package DFSIteratively;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrder {
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


        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> s1 = new Stack<>();

//        using 2stacks::

//        Stack<Node> s2 = new Stack<>();
//        s1.add(root);
//
//        while (!s1.isEmpty()){
//            s2.add(s1.pop());
//            if (s2.peek().left != null){
//                s1.add(s2.peek().left);
//            }
//            if (s2.peek().right != null){
//                s1.add(s2.peek().right);
//            }
//        }
//
//
//        while (!s2.isEmpty()){
//            ans.add(s2.pop().val);
//        }

        Node curr = root;
        while(curr != null || !s1.isEmpty()){
            if (curr != null){
                s1.add(curr);
                curr = curr.left;
            }else {
                Node temp = s1.peek().right;
                if (temp == null){
                    temp = s1.pop();
                    ans.add(temp.val);
                    while (!s1.isEmpty() && temp == s1.peek().right){
                        temp = s1.pop();
                        ans.add(temp.val);
                    }
                }else {
                    curr = temp;
                }
            }
        }

        return ans;
    }
}