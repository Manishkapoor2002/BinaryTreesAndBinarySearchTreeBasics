public class binaryPathSum {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(-4);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.left.right.left = new Node(6);
//        root.right.left = new Node(7);
//        root.right.right = new Node(8);
//        root.right.right.left = new Node(9);
//        root.right.right.right = new Node(10);

        int ans = maxPathSum(root);
        System.out.println(ans);
    }

    public static int helpfn(Node root,int sum,int[] ans){
        if(root == null) return 0;

        int left = helpfn(root.left,sum,ans);
        int right = helpfn(root.right,sum,ans);


            if (left<=0 && right<=0) {
                sum = root.val;
            }else if (left<0){
                sum += right;
            }else  if (right<0){
                sum += left;
            }else {
                sum += left+right+root.val;
            }

            ans[0] = Math.max(ans[0],sum);

            if (left>right){
                return left + sum;
            }else{
                return right + sum;
            }

    }

    public static int maxPathSum(Node root) {
        int[] ans = new int[1];

        helpfn(root,0,ans);

        return ans[0];


    }
}