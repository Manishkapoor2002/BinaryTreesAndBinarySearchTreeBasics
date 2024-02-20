public class CheckChildSumProperty {


    public static void traverse(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.val + " , ");
        if(root.left != null){
            traverse(root.left);
        }
        if (root.right != null){
            traverse(root.right);
        }
    }

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
        traverse(root);
        System.out.println();
        changeTree(root);
        System.out.println();
        traverse(root);

    }


    public static void changeTree(Node root) {

        if(root == null){
            return;
        }
        int childSum = 0;
        if(root.left != null){
            childSum += root.left.val;
        }

        if (root.right != null){
            childSum += root.right.val;
        }

        if (root.val<childSum){
            root.val = childSum;
        }else {
            if (root.left != null){
                root.left.val = root.val;
            }
            if (root.right != null){
                root.right.val = root.val;
            }
        }

        changeTree(root.left);
        changeTree(root.right);

        int check = 0;
        if(root.left != null){
            check += root.left.val;
        }

        if (root.right != null){
            check += root.right.val;
        }

        if (root.left != null || root.right != null){
            root.val = check;
        }




    }
}