import java.util.*;
public class timeToBurnTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.left.right.left = new Node(6);
//        root.right.left = new Node(7);
        root.right.right = new Node(8);
//        root.right.right.left = new Node(9);
//        root.right.right.right = new Node(10);

        System.out.println(timeToBurnTree(root,2));

    }

    public static Node  findStartNode(Node root,int start){

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node startNode = new Node(-1);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){

                if(q.peek().val == start){
                    startNode = q.peek();
                }

                if(q.peek().left != null){

                    q.add(q.peek().left);
                }

                if(q.peek().right != null){
                    q.add(q.peek().right);
                }

                q.poll();
            }
            if(startNode.val != -1){
                break;
            }
        }
        return startNode;
    }

    public static int timeToBurnTree(Node root, int start)
    {

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        HashMap<Node,Node> map = new HashMap<>();
        HashSet<Node> visited = new HashSet<>();
        int time = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                if(q.peek().left != null){
                    map.put(q.peek().left,q.peek());
                    q.add(q.peek().left);
                }

                if(q.peek().right != null){
                    map.put(q.peek().right,q.peek());
                    q.add(q.peek().right);
                }

                q.poll();
            }
        }


        q.add(findStartNode(root,start));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                if(map.containsKey(q.peek()) && !visited.contains(map.get(q.peek()))) {
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
            time++;
        }


        return time-1;



    }
}