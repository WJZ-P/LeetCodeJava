//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//
//class Solution {
//    public List<List<String>> groupAnagrams(String[] strs) {
//        //这里新建一个hashMap
//        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
//        for (String string : strs) {
//            //遍历字符串数组
//            char[] charStr = string.toCharArray();
//            Arrays.sort(charStr);
//            //排序好的字符串
//            String sortedStr = new String(charStr);
//            ArrayList<String> strList = hashMap.get(sortedStr);
//            if (strList == null) {
//                strList = new ArrayList<>();
//                hashMap.put(sortedStr, strList);
//            }
//
//            strList.add(string);
//
//
//        }
//        //hashMap不保证顺序，但是无所谓，题目不要求顺序
//
//        //现在全部存放好了，接下来需要的是输出！
//        return new ArrayList<>(hashMap.values());
//    }
//}

//import java.util.HashSet;
//import java.util.Set;
//
//class Solution {
//    public int longestConsecutive(int[] nums) {
//        //这里使用哈希集合
//        Set<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            set.add(num);//先把元素插入
//        }
//        //接下来就开始查询
//        int currentCount = 0;
//        int currNum = 0;
//        int max = 0;
//        for (int number : set) {
//            currNum = number;
//            if (!set.contains(currNum - 1)) {//集合里面没有比这个小1的，说明是序列的开头
//                currentCount++;//数字增加
//                while (set.contains(++currNum)) {//如果集合里面有比这个大的
//                    currentCount++;
//                }
//                max = Math.max(max, currentCount);//更新最大值
//                currentCount=0;
//            }
//        }
//        return max;
//    }
//}

//class Solution {
//    public void moveZeroes(int[] nums) {
//        int lastNotZeroNumIndex=0;
//        for(int i=0;i<nums.length;i++){
//            if(nums[i]!=0){
//                nums[lastNotZeroNumIndex]=nums[i];
//                lastNotZeroNumIndex++;
//            }
//        }
//        for(int i=lastNotZeroNumIndex;i<nums.length;i++){
//            nums[i]=0;
//        }
//    }
//}

//class Solution {
//    public int maxArea(int[] height) {
//        int left = 0, right = height.length - 1;
//        //上面定义了双指针。
//        int maxArea = 0;
//        while (left != right) {
//            int newArea = Math.min(height[left], height[right]) * (right - left);
//            if (newArea > maxArea) maxArea = newArea;
//            //上面进行最大面积的更新。
//            if(height[left]>height[right])//左边的高度比右边高，应该右边往左边靠拢
//                right--;
//            else
//                left++;
//        }
//        return maxArea;
//    }
//}

//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.List;
//
//class Solution {
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> resultList = new ArrayList<>();
//        //先对数组进行排序
//        Arrays.sort(nums);
//        //下面开始遍历查找
//        for (int first = 0; first < nums.length - 2; first++) {
//            //这是三元组的第一个数字
//            if (first > 0 && nums[first] == nums[first - 1]) continue;
//
//            int target = -nums[first];//确认target
//
//            //接下来定位第三个数为数组的末尾，此时有对应关系，b+c=-a.又因为数组是排序好的，那么找三元组的过程中，
//            //第三个指针只会往左，第二个指针只会往右。
//            int third = nums.length - 1;
//            for (int second = first + 1; second < third; second++) {
//                //下面开始找，要先保证second不重复
//                if (second > first + 1 && nums[second] == nums[second - 1]) continue;//说明这个second会重复，就不找了
//                while (nums[second] + nums[third] > target && second < third) {
//                    //说明后两个数字加起来不满足条件
//                    third--;
//                }
//                //现在third索引位置的元素大小就是正常的
//                if (nums[second] + nums[third] == target && second != third) {
//                    resultList.add(Arrays.asList(nums[first], nums[second], nums[third]));
//                }
//            }
//        }
//        return new ArrayList<>(resultList);
//    }
//}

import com.sun.source.tree.Tree;

import java.util.*;

//class Solution {
//    public int trap(int[] height) {
//        int leftMax = 0;
//        int rightMax = 0;
//        int leftIndex = 0;
//        int rightIndex = height.length - 1;
//        int result = 0;
//        while (leftIndex < rightIndex) {
//            //先更新最大值
//            leftMax = Math.max(leftMax, height[leftIndex]);
//            rightMax = Math.max(rightMax, height[rightIndex]);
//
//            if (height[leftIndex]<height[rightIndex]){
//                result+=leftMax-height[leftIndex];
//                leftIndex++;
//            }
//            else{
//                result+=rightMax-height[rightIndex];
//                rightIndex--;
//            }
//        }
//        return result;
//    }
//}

//class Solution {
//    public List<Integer> findAnagrams(String s, String p) {
//        List<Integer> result = new ArrayList<>();
//        if (p.length() > s.length()) return result;
//        //用数组替代
//        int[] stand = new int[26];
//        int[] window = new int[26];
//        // 初始化标准表和第一个窗口
//        for (int i = 0; i < p.length(); i++) {
//            stand[p.charAt(i) - 'a']++;
//            window[s.charAt(i) - 'a']++;
//        }
//        if (Arrays.equals(stand, window)) result.add(0);
//        //开始滑动窗口
//        for (int i = p.length(); i < s.length(); i++) {
//            //窗口右移，加新的字母，减去旧的字母
//            window[s.charAt(i) - 'a']++;
//            window[s.charAt(i - p.length()) - 'a']--;
//            if (Arrays.equals(stand, window)) result.add(i - p.length() + 1);
//        }
//
//        return result;
//    }
//}

//class NumArray {
//    private int[] nums;
//
//    public NumArray(int[] nums) {
//        this.nums = nums;
//    }
//
//    public int sumRange(int left, int right) {
//        int result = 0;
//        for (int i = left; i <= right; i++) {
//            result += nums[i];
//        }
//        return result;
//    }
//}

//class Solution {
//    public int subarraySum(int[] nums, int k) {
//        int count = 0;
//        int s = 0;//这个是前缀和
//        Map<Integer, Integer> map = new HashMap<>(nums.length + 1);
//        map.put(0, 1);//前缀和s[0]单独统计
//        for (int x : nums) {
//            //统计前缀和
//            s += x;
//            //统计s[i]-s[j]=k的个数
//            count += map.getOrDefault(s - k, 0);
//            map.merge(s, 1, Integer::sum);
//        }
//        return count;
//    }
//}

//class Solution {
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        //滑动窗口最大值，应使用双端队列
//        int[] result = new int[nums.length - k + 1];
//        Deque<Integer> deque = new ArrayDeque<>();
//        //循环处理
//        for (int i = 0; i < nums.length; i++) {
//            //处理入队
//            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
//                deque.removeLast();
//            }
//            deque.addLast(i);//索引放入
//            if (i - deque.getFirst() >= k) {
//                //说明最大值已经滑出了
//                deque.removeFirst();
//            }
//            //处理结果
//            if (i >= k - 1) {
//                result[i - k + 1] = nums[deque.getFirst()];
//            }
//        }
//        return result;
//    }
//}

//class Solution {
//    public String minWindow(String s, String t) {
//        char[] chars = s.toCharArray();
//        int[] cnt = new int[128];
//        int ansLeft = -1;
//        int ansRight = s.length() - 1;
//        int less = 0;//表示当前子串中某个字符少于标准串的该字符的数量
//        for (char c : t.toCharArray()) {
//            if (cnt[c] == 0) {
//                less++;
//            }
//            cnt[c]++;
//        }
//
//        int left = 0;
//        for (int right = 0; right < s.length(); right++) {
//            cnt[chars[right]]--;//右边字符移入，则计数减少
//            //减少到0的时候就说明这个字符覆盖了
//            if (cnt[chars[right]] == 0) {
//                //那么未覆盖数-1；
//                less--;
//            }
//            //判断是否全覆盖
//            while (less == 0) {
//                //如果全覆盖了，判断当前左右差值是否比已查到最小的小
//                if (right - left < ansRight - ansLeft) {
//                    ansRight = right;
//                    ansLeft = left;
//                }
//                //左侧移出去之前要先判断
//                char leftChar = chars[left];
//                if (cnt[leftChar] == 0) {
//                    less++;
//                }
//                cnt[leftChar]++;
//                left++;
//            }
//        }
//        return ansLeft >= 0 ? s.substring(ansLeft, ansRight + 1) : "";
//    }
//}

//class Solution {
//    public int maxSubArray(int[] nums) {
//        //这道题用最小前缀和做。
//        int ans = Integer.MIN_VALUE;
//        int preSum = 0;
//        int minPreSum = 0;
//        for (int num : nums) {
//            preSum += num;
//            //更新结果
//            ans = Math.max(ans, preSum - minPreSum);
//            //维护最小前缀和
//            minPreSum = Math.min(preSum, minPreSum);
//        }
//        return ans;
//    }
//}


//class Solution {
//    public int[][] merge(int[][] intervals) {
//        //现在就是按照子元素的左端点排序好了
//        Arrays.sort(intervals, (p, q) -> p[0] - q[0]);
//        //创造一个新的数组
//        List<int[]> ans = new ArrayList<>();
//        for (int[] element : intervals) {
//            int ansSize = ans.size();
//            if (ansSize > 0 && element[0] <= ans.get(ansSize - 1)[1]) {
//                //说明当前数组的开始小于结果数组的结束，说明是可以合并的
//                ans.get(ansSize - 1)[1] = Math.max(element[1], ans.get(ansSize - 1)[1]);
//            } else {
//                ans.add(element);
//            }
//        }
//        return ans.toArray(new int[ans.size()][]);
//    }
//}


//class Solution {
//    public void rotate(int[] nums, int k) {
//        k %= nums.length;
//
//        //先进行数组的反转
//        int right = nums.length - 1;
//        for (int left = 0; left < right; left++) {
//            int temp = nums[left];
//            nums[left] = nums[right];
//            nums[right] = temp;
//            right--;
//        }
//
//        //然后继续反转，0-k-1和k-n反转
//        right = k - 1;
//        for (int left = 0; left < right; left++) {
//            int temp = nums[left];
//            nums[left] = nums[right];
//            nums[right] = temp;
//            right--;
//        }
//        right = nums.length - 1;
//        for (int left = k; left < right; left++) {
//            int temp = nums[left];
//            nums[left] = nums[right];
//            nums[right] = temp;
//            right--;
//        }
//    }
//}

//class Solution {
//    public int[] productExceptSelf(int[] nums) {
//        //维护一个前缀积
//        int[] preMulti = new int[nums.length];
//        preMulti[0] = 1;
//        for (int i = 1; i < nums.length; i++) {
//            preMulti[i] = nums[i - 1] * preMulti[i - 1];
//        }
//        int x = 1;
//        for (int i = nums.length - 1; i >= 0; i--) {
//            preMulti[i] *= x;
//            x *= nums[i];
//        }
//
//        return preMulti;
//    }
//}

//class Solution {
//    public int firstMissingPositive(int[] nums) {
//        //这题要用到原地哈希
//        for (int i = 0; i < nums.length; i++) {
//            while (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]) {
//                int temp = nums[nums[i] - 1];
//                nums[nums[i] - 1] = nums[i];
//                nums[i] = temp;
//            }
//        }
//        //开始找数字吧
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != i + 1) return i + 1;
//        }
//        return nums.length + 1;
//    }
//}

//class Solution {
//    public void setZeroes(int[][] matrix) {
//        int m = matrix.length, n = matrix[0].length;
//        boolean col0 = false;
//
//        // 检查第一列是否有 0
//        for (int i = 0; i < m; i++) {
//            if (matrix[i][0] == 0) {
//                col0 = true;
//                break;
//            }
//        }
//
//        // 检查第一行是否有 0
//        for (int j = 0; j < n; j++) {
//            if (matrix[0][j] == 0) {
//                matrix[0][0] = 0;
//                break;
//            }
//        }
//
//        // 标记（从 1 开始）
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                if (matrix[i][j] == 0) {
//                    matrix[i][0] = 0;
//                    matrix[0][j] = 0;
//                }
//            }
//        }
//
//        // 先处理内部（除第一行第一列）
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//
//        // 处理第一行
//        if (matrix[0][0] == 0) {
//            for (int j = 0; j < n; j++) {
//                matrix[0][j] = 0;
//            }
//        }
//
//        // 处理第一列
//        if (col0) {
//            for (int i = 0; i < m; i++) {
//                matrix[i][0] = 0;
//            }
//        }
//    }
//}


//class Solution {
//    public void rotate(int[][] matrix) {
//        //先上下反转，然后左对角线反转就行
//        int n = matrix.length;
//        for (int i = 0; i < n / 2; i++) {
//            for (int j = 0; j < n; j++) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[n - 1 - i][j];
//                matrix[n - 1 - i][j] = temp;
//            }
//        }
//        //做\这样的反转
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[j][i];
//                matrix[j][i] = temp;
//            }
//        }
//    }
//}


//class Solution {
//    public boolean searchMatrix(int[][] matrix, int target) {
//        //右上角开始是一个二叉搜索树
//        int pointRow = 0;
//        int pointCol = matrix[0].length - 1;
//
//        while (pointRow < matrix.length && pointCol >= 0) {
//            if (matrix[pointRow][pointCol] == target)
//                return true;
//
//            //判断往左还是往右
//            if (matrix[pointRow][pointCol] < target) {
//                pointRow++;
//            } else {
//                pointCol--;
//            }
//
//        }
//        return false;
//    }
//}

//public class Solution {
//    public static class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//            next = null;
//        }
//    }
//
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        Map<ListNode, Integer> map = new HashMap<>();
//        while (headA != null) {
//            map.put(headA, headA.val);
//            headA = headA.next;
//        }
//        //A节点全部进入，然后遍历B节点，查看哈希是否存在，存在即为正确
//        while (headB != null) {
//            if (map.containsKey(headB)) {
//                return headB;
//            }
//            headB = headB.next;
//        }
//        return null;
//    }
//}

//class Solution {
//    public static class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode() {
//        }
//
//        ListNode(int val) {
//            this.val = val;
//        }
//
//        ListNode(int val, ListNode next) {
//            this.val = val;
//            this.next = next;
//        }
//    }
//
//    public ListNode reverseList(ListNode head) {
//        ListNode prev = null;
//        ListNode current = head;
//        while (current != null) {
//            ListNode next = current.next;
//            current.next = prev;
//            prev = current;
//            current = next;
//        }
//        return prev;
//    }
//}

//class Solution {
//    public class ListNode {
//
//
//        int val;
//        ListNode next;
//
//        ListNode() {
//        }
//
//        ListNode(int val) {
//            this.val = val;
//        }
//
//        ListNode(int val, ListNode next) {
//            this.val = val;
//            this.next = next;
//        }
//    }
//
//    public boolean isPalindrome(ListNode head) {
//        List list = new ArrayList<>();
//        while (head != null) {
//            list.add(head.val);
//            head = head.next;
//        }
//        int indexFront = 0;
//        int indexLast = list.size() - 1;
//        while (indexFront < indexLast) {
//            if (list.get(indexFront++) != list.get(indexLast--))
//                return false;
//        }
//        return true;
//    }
//
//}

//public class Solution {
//    public class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode() {
//        }
//
//        ListNode(int val) {
//            this.val = val;
//        }
//
//        ListNode(int val, ListNode next) {
//            this.val = val;
//            this.next = next;
//        }
//    }
//
//    public ListNode mergeKLists(ListNode[] lists) {
//        return mergeKLists(lists, 0, lists.length);
//    }
//
//    private ListNode mergeKLists(ListNode[] lists, int i, int j) {//合并i到j-1的列表
//        //合并给定区间的链表
//        int m = j - i;
//        if (m == 0) return null;
//        if (m == 1) return lists[i];
//
//        ListNode left = mergeKLists(lists, i, i + m / 2);
//        ListNode right = mergeKLists(lists, i + m / 2, j);
//        return mergeTwoLists(left, right);
//    }
//
//    private ListNode mergeTwoLists(ListNode node1, ListNode node2) {
//        //合并两个链表,每个链表都是有序的
//        ListNode dummy = new ListNode();
//        ListNode cur = dummy;
//        while (node1 != null && node2 != null) {
//            if (node1.val < node2.val) {
//                cur.next = node1;
//                node1 = node1.next;
//            } else {
//                cur.next = node2;
//                node2 = node2.next;
//            }
//            cur = cur.next;
//        }
//        cur.next = node1 != null ? node1 : node2;
//        return dummy.next;
//    }
//}

//class LRUCache {
//    private int capacity;
//    private Map<Integer, Integer> map;
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//        map = new LinkedHashMap<>(capacity, 0.75f, true);
//    }
//
//    public int get(int key) {
//        Integer value = map.get(key);
//        return value == null ? -1 : value;
//    }
//
//    public void put(int key, int value) {
//        map.put(key, value);
//        if (map.size() > capacity) {
//            map.remove(map.keySet().iterator().next());
//        }
//    }
//}

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int currentNum;
    int result;

    public int kthSmallest(TreeNode root, int k) {
        currentNum = k;
        midOrder(root);
        return result;
    }

    private void midOrder(TreeNode root) {
        if (root == null) return;
        midOrder(root.left);//先遍历左子节点
        if (--currentNum == 0) {
            result = root.val;
            return;
        }//然后遍历自己的
        midOrder(root.right);//再遍历右节点
    }

    //验证二叉搜索树
    public boolean isValidBST(TreeNode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean checkBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.left != null && (root.left.val >= root.val || root.left.val <= min)) return false;
        if (root.right != null && (root.right.val <= root.val || root.right.val >= max)) return false;
        return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
    }


    //有序数组转换为二叉搜索树。
    public TreeNode sortedArrayToBST(int[] nums) {
        //调用递归算法构建
        return buildSearchTree(nums, 0, nums.length);
    }

    private TreeNode buildSearchTree(int[] nums, int left, int right) {
        if (left == right) return null;
        int m = (left + right) >>> 1;//三个>是无符号右移。
        return new TreeNode(nums[m], buildSearchTree(nums, left, m), buildSearchTree(nums, m + 1, right));
    }

    //层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) return new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();//先记录下这一层需要处理的数据
            List<Integer> list = new ArrayList<>();
            while (n-- > 0) {
                TreeNode node = queue.poll();
                if (node != null) list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            resultList.add(list);
        }
        return resultList;
    }

    private int result;

    public int diameterOfBinaryTree(TreeNode root) {
        //二叉树的直径，实际上就是求左右子树的深度的最大值，递归
        dfs(root);
        return result;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        result = Math.max(result, left + right);
        return Math.max(left, right) + 1;
    }

    //检查二叉树是否是对称的
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isSymmetric(left.left, right.right) &&
                isSymmetric(left.right, right.left);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        //交换左右子节点
        root.left = root.right;
        root.right = temp;
        root.left = invertTree(root.left);//继续交换孩子节点
        root.right = invertTree(temp);
        return root;
    }
}