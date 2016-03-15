// cracking the coding interview 4.3

import java.util.Comparator;

public class MinimalBST {
    int[] nums;
    TreeNode root;
    StringBuilder s;

    public MinimalBST(int[] numbers) {
        // defensive copy
        nums = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++)
            nums[i] = numbers[i];

        int low = 0;
        int high = nums.length;
        int median = (low + high) / 2;

        root = new TreeNode(nums[median], null);
    
        addMedian(nums);   
    }

    // functions addMedian modeled after sort() in mergesort
    public void addMedian(int [] nums) {
        addMedian(0, nums.length);
    }

    private void addMedian(int low, int high) {
        int median = (low + high) / 2;

        if (low >= high)
            return;
        add(nums[median]);
        addMedian(low, median);
        addMedian(median + 1, high);
    }

    private void add(int value) {
        if (value == root.value)
            return;

        TreeNode b = root;
        while (true) {
            if (value < b.value)
                if (b.left != null)
                    b = b.left;
                else {
                    b.left = new TreeNode(value, b);
                    break;
                }
            else
                if (b.right != null)
                    b = b.right;
                else {
                    b.right = new TreeNode(value, b);
                    break;
                }
        }
    }

    private class TreeNode {
        int value;
        TreeNode parent;
        TreeNode left, right; 

        public TreeNode(int value, TreeNode parent) {
            this.value = value;
            this.parent = parent;
            left = null;
            right = null;
        }

        public TreeNode(int value, TreeNode parent, TreeNode left, TreeNode right) {
            this.value = value;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public String toString() {
            return (value + "");
        }
    }

    public String print() {
        s = new StringBuilder();
        TreeNode node = root;

        s.append("value = " + node.value + "\n");
        s.append("parent = null \n");
        s.append("left = " + node.left.value + "\n");
        s.append("right = " + node.right.value + "\n\n");
        
        print(node.left);
        print(node.right);

        return s.toString();
    }
    
    private void print(TreeNode node) {
        if (node != null) {
            
            s.append("value = " + node.value + "\n");
            s.append("parent = " + node.parent.value + "\n");
            if (node.left != null)
                s.append("left = " + node.left.value + "\n");
            else
                s.append("left = null \n");
            if (node.right != null)
                s.append("right = " + node.right.value + "\n\n");
            else
                s.append("right = null \n\n");

            print(node.left);
            print(node.right);
        }
    }
    
    public static void main(String args[]) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        MinimalBST bst = new MinimalBST(nums);

        System.out.println("Nodes in the Tree:");
        System.out.println(bst.print());
    }
}