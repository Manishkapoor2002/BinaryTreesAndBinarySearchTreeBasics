import java.util.*;
public class allNodeDistanceKinTree {


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

        System.out.println(distanceK(root,root.left.right.left,2));


    }



    public static List<Integer> distanceK(Node root, Node target, int k){
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        HashMap<Node,Node> map = new HashMap<>();
        HashSet<Node> visited = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0;i<size;i++){
                if (q.peek().left != null){
                    q.add(q.peek().left);
                    map.put(q.peek().left,q.peek());
                }

                if (q.peek().right != null){
                    q.add(q.peek().right);
                    map.put(q.peek().right,q.peek());
                }
                q.poll();
            }
        }

        q.add(target);
        int dist = 0;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0;i<size;i++){
                if (map.containsKey(q.peek()) && !visited.contains(map.get(q.peek()))){
                    q.add(map.get(q.peek()));
                }

                if (q.peek().left != null && !visited.contains(q.peek().left)){
                    q.add(q.peek().left);
                }

                if (q.peek().right != null && !visited.contains(q.peek().right)){
                    q.add(q.peek().right);
                }
                visited.add(q.peek());
                q.poll();
            }
            dist++;

            if (dist == k){
                break;
            }
        }

        while (!q.isEmpty()){
            ans.add(q.poll().val);
        }

        return ans;
    }
}