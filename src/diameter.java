public class diameter {
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

        int ans  = diameterOfBinaryTree(root);
        System.out.println(ans);
    }

//    private static int max = -1;
    public static int height(Node root){
        if(root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left,right) + 1;
    }

    public static int diameterOfBinaryTree(Node root) {

        if(root == null) return 0;
        int[] max = new int[1];

        int leftheight = height(root.left);
        int rightheight = height(root.right);

        max[0] = Math.max(max[0],rightheight+leftheight);
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);

        return max[0];

    }
}