import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BSFtraversal {
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
        travseral(root);
    }

    public static void travseral(Node root) {
        if (root == null) return;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int currSize = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < currSize; i++) {
                if (q.peek().left != null) {
                    q.add(q.peek().left);
                }
                if (q.peek().right != null) {
                    q.add(q.peek().right);
                }
                temp.add(q.peek().val);
                q.poll();
            }
            list.add(temp);
        }
        


//        System.out.println(list);

        for (ArrayList<Integer> i : list){
            for (int j : i){
                System.out.print(j + " , ");
            }
        }
    }
}