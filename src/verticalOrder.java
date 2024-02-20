import java.util.*;

public class verticalOrder {
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
        System.out.println(verticalTraversal(root));
    }

    public static void helpfn(Node root, TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map,int vertical,int level){
        if(root == null) return;

        if (!map.containsKey(vertical)){
            map.put(vertical,new TreeMap<>());
        }
        if (!map.get(vertical).containsKey(level)){
            map.get(vertical).put(level,new PriorityQueue<>());
        }
        map.get(vertical).get(level).add(root.val);

        helpfn(root.left,map,vertical-1,level+1);
        helpfn(root.right,map,vertical+1,level+1);

    }
    public static List<List<Integer>> verticalTraversal(Node root){

    List<List<Integer>> ans = new ArrayList<>();
    TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

    helpfn(root,map,0,0);

    for(Integer temp : map.keySet()){
        List<Integer> list = new ArrayList<>();
        for (Integer curr : map.get(temp).keySet()){
//            for (int i : map.get(temp).get(curr)){
//                list.add(i);
//            }
            while (!map.get(temp).get(curr).isEmpty()){
                list.add(map.get(temp).get(curr).poll());

            }
        }
        ans.add(list);
    }
    return ans;

    }
}


