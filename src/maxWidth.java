import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class maxWidth {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(8);
//        root.left.right.left = new Node(6);
//        root.right.right.left = new Node(9);
//        root.right.right.right = new Node(10);
        System.out.println(widthOfBinaryTree(root));

    }

    public static int widthOfBinaryTree(Node root){
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(0,root));
        int ans = 0;

        while (!q.isEmpty()){
            int size = q.size();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int minIdx = q.peek().val;
            for (int i = 0;i<size;i++){
                if (q.peek().node.left != null){
                    q.add(new Pair((2 * (q.peek().val- minIdx) )+ 1,q.peek().node.left));
                }
                if (q.peek().node.right != null){
                    q.add((new Pair((2 *(q.peek().val-minIdx))+2,q.peek().node.right)));
                }
               if (i == 0){
                   min = q.peek().val;
               }

               if (i == size-1){
                   max = q.peek().val;
               }
                q.poll();
            }
            ans = Math.max(ans,(max-min+1));
        }
            return ans;
    }
}