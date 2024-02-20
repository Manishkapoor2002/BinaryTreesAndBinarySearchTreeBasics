import java.util.*;
public class AllrootLeaf {
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(8);
        root.left.right.left = new Node(6);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        System.out.println(allRootToLeaf(root));

    }

    public static List<String> allRootToLeaf(Node root) {
    List<String> ans = new ArrayList<>();

    if (root.left == null && root.right == null){
        ans.add("" +root.val);
        return ans;
    }

    if(root.left != null){
        helpfn(root.left,"" +root.val ,ans);
    }
    if (root.right != null){
        helpfn(root.right,"" + root.val,ans);
    }


    return ans;
    }

    public static void helpfn(Node root,String curr,List<String> list){


        if (root.left == null && root.right == null){

            list.add(curr +" " +root.val);
            return;
        }

//        left:
        if(root.left != null){
            helpfn(root.left,curr +" " +root.val,list);
        }

        //        right:

        if (root.right != null){
            helpfn(root.right,curr+ " " +root.val,list);
        }


    }




}