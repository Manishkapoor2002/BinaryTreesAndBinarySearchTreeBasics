import java.util.*;
public class BoundaryTraversal {
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
//        System.out.println(traverseBoundary(root));
        int[] arr = {73,74,75,71,69,72,76,73};
        int[] ans = dailyTemperatures(arr);
        for (int i  : ans){
            System.out.print(i +" , ");
        }
    }

    public static boolean isLeaf(Node root){
        return root.left == null && root.right == null;
    }

    public static void leftView(Node root,List<Integer> ans){
        Node temp = root.left;
        while (temp != null){
            if (isLeaf(temp)){
                break;
            }
            ans.add(temp.val);

            if (temp.left != null){
                temp = temp.left;
            }else{
                temp = temp.right;
            }
        }
    }


    public static void rightView(Node root,List<Integer> ans){
        Node temp = root;
        Stack<Integer> s = new Stack<>();
        while (temp != null){
            if (isLeaf(temp)){
                break;
            }
            s.add(temp.val);

            if (temp.right != null){
                temp = temp.right;
            }else{
                temp = temp.left;
            }
        }

        while (!s.isEmpty()){
            ans.add(s.pop());
        }
    }


    public static void leafView(Node root,List<Integer> ans){

        if (isLeaf(root)){
            ans.add(root.val);
            return;
        }

        if (root.left != null){
            leafView(root.left,ans);
        }

        if (root.right != null){
            leafView(root.right,ans);
        }

    }


    public static List<Integer> traverseBoundary(Node root){
        List<Integer> ans  = new ArrayList<>();
        if (root == null) return ans;
        if (isLeaf(root)) {
            ans.add(root.val);
            return ans;
        }
        ans.add(root.val);
//        left;
        leftView(root,ans);

//        leaf:
        leafView(root,ans);


//        right:
        if (root.right != null){
            rightView(root.right,ans);
        }

        return ans;


    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> s = new Stack();
        s.add(temperatures.length-1);

        for(int i = temperatures.length-2;i>=0;i--){

            while(!s.isEmpty() && temperatures[s.peek()]<=temperatures[i]){
                s.pop();
            }


            if(s.isEmpty()){
                ans[i] = 0;
            }else{
                ans[i] = s.peek() - i;
            }

            s.add(i);
        }

        return ans;

    }
}
