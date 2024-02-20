import java.util.*;

public class toplevelView {
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
        System.out.println(topView(root));


    }

    public static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(0,root));

        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0;i<size;i++){
                if (!map.containsKey(q.peek().val)){
                    map.put(q.peek().val,q.peek().node.val);
                }

                if (q.peek().node.left != null){
                    q.add(new Pair(q.peek().val-1,q.peek().node.left));
                }

                if (q.peek().node.right != null){
                    q.add(new Pair(q.peek().val+1,q.peek().node.right));
                }

                q.poll();
            }
        }

        for (int i : map.keySet()){
            int value = map.get(i);
            ans.add(value);
        }

        return ans;

    }

}

class Pair{
    int val;
    Node node;
    public Pair(int data,Node node){
        this.node = node;
        this.val = data;
    }
}