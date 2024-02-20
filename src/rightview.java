import java.util.*;
public class rightview {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.left.right.left = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);
//        System.out.println(new rightview(root));

        System.out.println(rightSideView(root));
    }
    public static List<Integer> rightSideView(Node root) {
        // we are using BFS technique to solve this problem::
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,root));

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                if(q.peek().val>=0 && !map.containsKey(q.peek().val)){
                    map.put(q.peek().val,q.peek().node.val);
                }

                if(q.peek().node.left != null){

                    q.add(new Pair(q.peek().val-1,q.peek().node.left));
                }


                if(q.peek().node.right != null){
                    q.add(new Pair(q.peek().val+1,q.peek().node.right));
                }

                q.poll();
            }
        }


        for(int i : map.keySet()){
            int data = map.get(i);
            ans.add(data);
        }

        return ans;


    }
}