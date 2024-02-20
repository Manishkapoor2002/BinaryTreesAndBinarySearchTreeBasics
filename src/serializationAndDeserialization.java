import java.util.*;

public class serializationAndDeserialization {
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

        int a = 1234;
        String s = Integer.toString(a);
        System.out.println( );
        System.out.println(s);

        System.out.println(serialize(root));
        Node curr = deserialize(serialize(root));
//
        traversal(curr);

    }

    public static void traversal(Node root){
        if (root == null) return;

        System.out.println(root.val);
        traversal(root.left);
        traversal(root.right);
    }




    // Encodes a tree to a single string.
    public static String serialize(Node root) {
        if (root == null) return "";
        Queue<Node> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            for (int i = 0;i<size;i++){
                Node temp = q.poll();
                if(temp == null){
                    res.append("n,");
                    continue;
                }
                res.append(temp.val +",");
                q.add(temp.left);
                q.add(temp.right);
//                q.poll();
            }
        }

        return res.toString();
    }

    // Decodes your encoded data to tree.
    public static Node deserialize(String data) {

        if (data.isEmpty()) return null;
        Queue<Node> q = new LinkedList<>();
        String[] s = data.split(",");
        Node curr = new Node(Integer.parseInt(s[0]));
        q.add(curr);
        for(int i = 1;i<s.length;i++){
            Node parent = q.poll();
            if (!s[i].equals("n")){
                Node left = new Node(Integer.parseInt(s[i]));
                parent.left = left;
                q.add(left);
            }
            if (!s[++i].equals("n")){
                Node right = new Node(Integer.parseInt(s[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return curr;

    }


}