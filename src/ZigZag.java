import java.util.*;

public class ZigZag {
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
        System.out.println(zigzagLevelOrder(root));

    }


    public static List<List<Integer>> zigzagLevelOrder(Node root) {

        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int flag = 0;
        // flag == 0 means: left to right
        // flag == 1 means: right to left

        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> list = new ArrayList<>(size+1);

            for(int i = 0;i<size;i++){
                Node temp = q.peek();
                if(temp.left != null){
                    q.add(temp.left);
                }

                if(temp.right != null){
                    q.add(temp.right);
                }
                if(flag == 1){
                    list.set(size-1-i,temp.val);
                }else{
                    list.add(temp.val);
                }
                q.poll();
            }
            if(flag == 0){
                flag = 1;
            }else{
                flag = 0;
            }
            ans.add(list);
        }


        return ans;

    }
}