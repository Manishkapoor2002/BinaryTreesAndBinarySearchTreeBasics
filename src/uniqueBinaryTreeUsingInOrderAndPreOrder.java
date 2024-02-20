import java.util.HashMap;

public class uniqueBinaryTreeUsingInOrderAndPreOrder {
    public static void main(String[] args) {
        int[] preOrder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};

        Node ans = buildTree(preOrder,inOrder);
        traversal(ans);
    }

    public static void traversal(Node root){
        if (root == null) return;

        System.out.println(root.val);
        traversal(root.left);
        traversal(root.right);
    }

    public static Node buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }

    public static Node build(int[] preOrder,int preStart,int preEnd,int[] inOrder,int inStart,int inEnd,HashMap<Integer,Integer> map){

        if (inStart>inEnd || preStart>preEnd) return null;

        Node curr = new Node(preOrder[preStart]);

        int idx = map.get(curr.val);
        int numLeft = idx - inStart;


        curr.left = build(preOrder,preStart+1,preStart + numLeft,inOrder,inStart,idx-1,map);
        curr.right = build(preOrder,preStart+numLeft+1,preEnd,inOrder,idx+1,inEnd,map);

        return curr;

    }
}