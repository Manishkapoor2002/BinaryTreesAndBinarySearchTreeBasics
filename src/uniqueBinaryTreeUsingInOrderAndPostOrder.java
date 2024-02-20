import java.util.*;
public class uniqueBinaryTreeUsingInOrderAndPostOrder {
    public static void main(String[] args) {
        int[] inOrder = {9,3,15,20,7};
        int[] postOrder = {9,15,7,20,3};
        Node ans = buildTree(inOrder,postOrder);

        traversal(ans);

    }

    public static void traversal(Node root){
        if (root == null) return;

        traversal(root.left);
        System.out.println(root.val);
        traversal(root.right);
    }


    public static Node buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return helpfn(postorder,postorder.length-1,0,inorder,inorder.length-1,0,map);
    }

    public static Node helpfn(int[] postOrder,int postStart,int postEnd,int[] inOrder,int inStart,int inEnd,HashMap<Integer,Integer> map){

        if (postStart<postEnd || inStart<inEnd){
            return null;
        }

        Node curr = new Node(postOrder[postStart]);
        int idx = map.get(curr.val);
        int rightSide =  inStart -idx;

        curr.right = helpfn(postOrder,postStart-1,postStart-rightSide-1,inOrder,inStart,idx+1,map);
        curr.left = helpfn(postOrder,postStart-1-rightSide,postEnd,inOrder,idx-1,inEnd,map);

        return curr;

    }


}