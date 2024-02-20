import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LCAInBinary {
    public static void main(String[] args) {
        Node root = new Node(-1);
        root.left = new Node(0);
        root.right = new Node(3);
        root.left.left = new Node(-2);
        root.left.right = new Node(4);
        root.left.left.left = new Node(6);
//        root.right.left = new Node(5);
//        root.right.right = new Node(8);
//        root.right.right.left = new Node(9);
//        root.right.right.right = new Node(10);
        Node ans =  lowestCommonAncestor(root,root.right,root.left.left.left);
        System.out.println(ans.val);
//        System.out.println(ans.val);


    }

//    public static void findPath(Node root, Node goal, ArrayList<Node> list,List<Node> paths){
//        if(root == null) return;
//
//        list.add(root);
//
//        if(root == goal){
//            paths.addAll(list);
//            return;
//        }
//
//        findPath(root.left,goal,list,paths);
//        findPath(root.right,goal,list,paths);
//
//        list.removeLast();
//
//
//    }



    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
//        List<List<Integer>> paths = new ArrayList<>();
//        List<Node> pathP = new ArrayList<>();
//        List<Node> pathQ = new ArrayList<>();
//        findPath(root,p,new ArrayList<>(),pathP);
//        findPath(root,q,new ArrayList<>(),pathQ);
//
//        int i =0;
//        Node ans = root;
//
////
//        while(i<pathP.size() && i<pathQ.size()){
//            if(pathP.get(i) != pathQ.get(i)){
//                break;
//            }else{
//                ans = pathP.get(i);
//            }
//            i++;
//        }
////
////
//       return ans;























        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return root;
        }
        Node leftCall = lowestCommonAncestor(root.left,p,q);
        Node rightCall = lowestCommonAncestor(root.right,p,q);
        if(leftCall == null && rightCall == null){
            return null;
        }else if(leftCall == null && rightCall != null){
            return rightCall;
        }else if(leftCall != null && rightCall == null){
            return leftCall;
        }else{
            return root;
        }



































    }
}