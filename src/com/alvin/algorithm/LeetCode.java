package com.alvin.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Alvin
 * @Project_name Algorithm
 * @Package_name: com.alvin.algorithm
 * @Type_name LeetCode
 * @Date: 2017/2/13
 * @TODO:  LeetCode算法题记录
 */
public class LeetCode {

    public static void main(String[] args){
        int[] a = {1,2,3,7,4,3,6,5};
        String b = "abcabc";
        System.out.println(countSegments(", , , ,        a, eaefa"));
    }

    /**
     * LeetCode(Array):
     * 228. Summary Ranges
     */
    public static List<String> summaryRanges(int[] nums) {
        List<String> list=new ArrayList();
        if(nums.length==1){
            list.add(nums[0]+"");
            return list;
        }
        for(int i=0;i<nums.length;i++){
            int a=nums[i];
            while(i+1<nums.length&&(nums[i+1]-nums[i])==1){
                i++;
            }
            if(a!=nums[i]){
                list.add(a+"->"+nums[i]);
            }else{
                list.add(a+"");
            }
        }
        return list;
    }
    
    /**
     *  LeetCode(Array):
     *  238. Product of Array Except Self
     *  
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    /**
     *  LeetCode(Array):
     *  287. Find the Duplicate Number
     *  二分查找，比较哪边的数比较多
     */
    public static int findDuplicate(int[] nums) {
        int min = 0, max = nums.length - 1;
        while(min <= max){
            int mid = min + (max - min) / 2;
            int count = 0;
            // 计算数组中有count个数小于等于中间数
            for(int i = 0; i < nums.length; i++){
                if(nums[i] <= mid){
                    count++;
                }
            }
            // 如果count的数量大于中间数，说明前半部分必有重复，否则后半部分必有重复
            if(count > mid){
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
        /*for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
                if(i!=j && nums[j]==nums[i]){
                    return nums[j];
                }
            }
        }
        return 0;*/
    }

    /**
     *  Leetcode(Array)：
     *  442. Find All Duplicates in an Array
     *  理解：因为数组中保存的数字在1~N之间，不能使用额外的空间，
     *      所以将出现的数字通过数组下标来记录，将数组的值设置为“负”作为出现标记
     */
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            return list;
        }
        for(int i = 0; i<nums.length; i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index] < 0){
                list.add(index + 1);
            }else{
                nums[index] = -nums[index];
            }
        }
        return list;
    }

    /**
     *  LeetCode(Array):
     *  448. Find All Numbers Disappeared in an Array
     *  将存在的数以数组下标为记录设置为负数，最后数组为正数的下标为缺少的值
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List list = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            return list;
        }
        for(int i=0; i<nums.length; i++){
            if(nums[Math.abs(nums[i])-1] > 0)
                nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
        }
        for(int j=0; j<nums.length; j++){
            if(nums[j] > 0) list.add(j+1);
        }
        return list;
    }

    

    /**
     *  LeetCode(string):
     *  459. Repeated Substring Pattern
     *  重复的字符串，分割成倍数再比较
     */
    public static boolean repeatedSubstringPattern(String str) {
        int length = str.length();
        for(int i = length / 2; i >= 1; i--) {
            //能被整除的倍数，都可能为重复次数
            if(length % i == 0) {
                int num = length / i;
                StringBuffer strbuffer = new StringBuffer();
                String strPart = str.substring(0, i);
                for(int j = 0; j < num; j++) {
                    strbuffer.append(strPart);
                }
                if(strbuffer.toString().equals(str)) return true;
            }
        }
        return false;
    }
    /**
     *  LeetCode(string):
     *  434. Number of Segments in a String
     *  只要有空格便是分隔符
     */
    public static int countSegments(String s) {
        int k=0;
        s = s.trim();
        if(s.length()==0) return  0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==' '&&s.charAt(i+1)!=' '){
                k++;
            }
        }
        return k+1;
    }

    //  Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    /**
     * LeetCode(tree):
     * 404. Sum of Left Leaves
     * 递归实现
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int sum =0;
        if(root.left != null){
            if(root.left.left == null && root.left.right == null) sum += root.left.val;
            else sum += sumOfLeftLeaves(root.left);
        }
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }
    /**
     * LeetCode(tree):
     * 404. Sum of Left Leaves
     * 非递归实现
     */
    public int sumOfLeftLeaves2(TreeNode root) {
        if(root == null) return 0;
        int sum = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.empty()) {
            TreeNode node = stack.pop();
            if(node.left != null) {
                if (node.left.left == null && node.left.right == null)
                    sum += node.left.val;
                else
                    stack.push(node.left);
            }
            if(node.right != null) {
                if (node.right.left != null || node.right.right != null)
                    stack.push(node.right);
            }
        }
        return sum;
    }

    /**
     *  LeetCode(tree):
     *  236. Lowest Common Ancestor of a Binary Tree
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root ==q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        return left == null ? right : right == null ? left : root;
    }
}

