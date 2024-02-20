import java.util.*;

public class sumChildProperty {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(11);
        System.out.println(isParentSum(root));

    }

    public static boolean isParentSum(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            int flag = 0;
            for (int i = 0;i<size;i++){
                if (q.peek().left != null){
                    q.add(q.peek().left);
                    sum += q.peek().left.val;
                    flag++;
                }

                if (q.peek().right != null){
                    q.add(q.peek().right);
                    sum += q.peek().right.val;
                    flag++;
                }

                if(q.peek().val != sum && flag != 0){
                    return false;
                }
                q.poll();
            }
        }

        return true;


    }
}