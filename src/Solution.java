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

import java.beans.PropertyEditorSupport;
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

//class Solution {
//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode() {
//        }
//
//        TreeNode(int val) {
//            this.val = val;
//        }
//
//        TreeNode(int val, TreeNode left, TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//    }
//
//    //腐烂的橘子
//    public int orangesRotting(int[][] grid) {
//        int turns = 0;
//        Queue<int[]> queue = new ArrayDeque<>();
//        int row = grid.length;
//        int col = grid[0].length;
//        //第一轮，先加入所有的腐烂橘子
//        boolean hasFresh = false;
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (grid[i][j] == 1) {
//                    hasFresh = true;
//                }
//                if (grid[i][j] == 2) {
//                    queue.offer(new int[]{i, j});
//                }
//            }
//        }
//
//        if (!hasFresh) return 0;//根本没有新鲜的橘子！
//
//        //剩下对腐烂橘子进行遍历即可
//        while (!queue.isEmpty()) {
//            turns++;
//            int n = queue.size();
//            for (int i = 0; i < n; i++) {
//                //下面对本次的橘子进行腐烂蔓延！
//                int[] cur = queue.poll();
//                int x = cur[0];
//                int y = cur[1];
//
//                //先判断边界问题
//                //开始往四周蔓延吧！
//                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
//                    grid[x - 1][y] = 2;
//                    queue.offer(new int[]{x - 1, y});
//                    System.out.println("往上腐烂了" + (x - 1) + "," + y);
//                }
//                if (x + 1 < grid.length && grid[x + 1][y] == 1) {
//                    grid[x + 1][y] = 2;
//                    queue.offer(new int[]{x + 1, y});
//                    System.out.println("往下腐烂了" + (x + 1) + "," + y);
//                }
//                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
//                    grid[x][y - 1] = 2;
//                    queue.offer(new int[]{x, y - 1});
//                    System.out.println("往左腐烂了" + x + "," + (y - 1));
//                }
//                if (y + 1 < grid[0].length && grid[x][y + 1] == 1) {
//                    grid[x][y + 1] = 2;
//                    queue.offer(new int[]{x, y + 1});
//                    System.out.println("往右腐烂了" + x + "," + (y + 1));
//                }
//            }
//            System.out.println("本轮污染结束，总轮数" + turns);
//        }
//        //到此为止，已经尽可能地蔓延完毕了。接下来遍历看看有没有没有腐烂的橘子
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (grid[i][j] == 1) return -1;
//            }
//        }
//        return turns-1;
//    }
//
//    int count = 0;
//
//    public int numIslands(char[][] grid) {
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == '1') {
//                    dfs(grid, i, j);
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//
//    private void dfs(char[][] grid, int i, int j) {
//        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') return;
//        grid[i][j] = '2';//插棋子
//        dfs(grid, i - 1, j);//上
//        dfs(grid, i + 1, j);//下
//        dfs(grid, i, j - 1);//左
//        dfs(grid, i, j + 1);//右
//    }
//
//    //二叉树的最近公共祖先
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null || root == p || root == q) return root;
//
//        TreeNode left = lowestCommonAncestor(root.left, p, q);
//        TreeNode right = lowestCommonAncestor(root.right, p, q);
//
//        if (left != null && right != null) return root;
//        return left == null ? right : left;
//    }
//
//    int ans = Integer.MIN_VALUE;
//
//    //二叉树中的最大路径和
//    public int maxPathSum(TreeNode root) {
//        dfs3(root);
//        return ans;
//    }
//
//    private int dfs3(TreeNode root) {
//        if (root == null) return 0;
//        int left = dfs3(root.left);
//        int right = dfs3(root.right);
//        //更新答案
//        ans = Math.max(ans, left + right + root.val);
//        return Math.max(Math.max(left, right) + root.val, 0);
//    }
//
//    //路径总和III
//    int result1 = 0;
//    Map<Long, Integer> map = new HashMap<>();
//
//    public int pathSum(TreeNode root, int targetSum) {
//        map.put(0L, 1);
//        dfs(root, 0, targetSum);
//        return result1;
//    }
//
//    private void dfs(TreeNode root, long s, int targetSum) {
//        if (root == null) return;
//        //遍历到当前节点，那么sum总和应该加上当前节点
//        s += root.val;
//        //检查结果
//        result1 += map.getOrDefault(s - targetSum, 0);
//        map.merge(s, 1, Integer::sum);
//        //根节点到当前节点的路径和为s，往map里key为s的值+1，说明根节点往下路径和为s的路径又多了一条。
//        dfs(root.left, s, targetSum);
//        dfs(root.right, s, targetSum);
//        //最重要的是要记得恢复现场
//        map.merge(s, -1, Integer::sum);
//    }
//
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        int n = inorder.length;
//        Map<Integer, Integer> map = new HashMap<>(n);
//        for (int i = 0; i < n; i++) {
//            map.put(inorder[i], i);//开区间
//        }
//        return dfs(preorder, 0, n, 0, n, map);
//    }
//
//    private TreeNode dfs(int[] preorder, int preL, int preR, int inL, int inR, Map<Integer, Integer> map) {
//        if (preL == preR) return null;//空节点
//
//        int leftNum = map.get(preorder[preL]) - inL;
//        TreeNode left = dfs(preorder, preL + 1, preL + 1 + leftNum, inL, inL + leftNum, map);
//        TreeNode right = dfs(preorder, preL + 1 + leftNum, preR, inL + leftNum + 1, inR, map);
//        return new TreeNode(preorder[preL], left, right);
//    }
//
//    //二叉树展开为链表
//    TreeNode head = null;
//
//    public void flatten(TreeNode root) {
//        if (root == null) return;
//        flatten(root.right);
//        flatten(root.left);
//        root.right = head;
//        root.left = null;
//        head = root;
//    }
//
//
//    //二叉树的右视图
//    public List<Integer> rightSideView(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        if (root == null) return result;
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            int n = queue.size();//当前队列内的元素
//            while (--n >= 0) {
//                TreeNode node = queue.poll();
//                if (node.left != null) queue.add(node.left);
//                if (node.right != null) queue.add(node.right);
//                if (n == 0) result.add(node.val);
//            }
//        }
//        return result;
//    }
//
//    int currentNum;
//    int result;
//
//    public int kthSmallest(TreeNode root, int k) {
//        currentNum = k;
//        midOrder(root);
//        return result;
//    }
//
//    private void midOrder(TreeNode root) {
//        if (root == null) return;
//        midOrder(root.left);//先遍历左子节点
//        if (--currentNum == 0) {
//            result = root.val;
//            return;
//        }//然后遍历自己的
//        midOrder(root.right);//再遍历右节点
//    }
//
//    //验证二叉搜索树
//    public boolean isValidBST(TreeNode root) {
//        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
//    }
//
//    private boolean checkBST(TreeNode root, long min, long max) {
//        if (root == null) return true;
//        if (root.left != null && (root.left.val >= root.val || root.left.val <= min)) return false;
//        if (root.right != null && (root.right.val <= root.val || root.right.val >= max)) return false;
//        return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
//    }
//
//
//    //有序数组转换为二叉搜索树。
//    public TreeNode sortedArrayToBST(int[] nums) {
//        //调用递归算法构建
//        return buildSearchTree(nums, 0, nums.length);
//    }
//
//    private TreeNode buildSearchTree(int[] nums, int left, int right) {
//        if (left == right) return null;
//        int m = (left + right) >>> 1;//三个>是无符号右移。
//        return new TreeNode(nums[m], buildSearchTree(nums, left, m), buildSearchTree(nums, m + 1, right));
//    }
//
//    //层序遍历
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        List<List<Integer>> resultList = new ArrayList<>();
//        if (root == null) return new ArrayList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            int n = queue.size();//先记录下这一层需要处理的数据
//            List<Integer> list = new ArrayList<>();
//            while (n-- > 0) {
//                TreeNode node = queue.poll();
//                if (node != null) list.add(node.val);
//                if (node.left != null) queue.add(node.left);
//                if (node.right != null) queue.add(node.right);
//            }
//            resultList.add(list);
//        }
//        return resultList;
//    }
//
//    public int diameterOfBinaryTree(TreeNode root) {
//        //二叉树的直径，实际上就是求左右子树的深度的最大值，递归
//        dfs(root);
//        return result;
//    }
//
//    public int dfs(TreeNode root) {
//        if (root == null) return 0;
//        int left = dfs(root.left);
//        int right = dfs(root.right);
//        result = Math.max(result, left + right);
//        return Math.max(left, right) + 1;
//    }
//
//    //检查二叉树是否是对称的
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) return true;
//        return isSymmetric(root.left, root.right);
//    }
//
//    public boolean isSymmetric(TreeNode left, TreeNode right) {
//        if (left == null && right == null) return true;
//        if (left == null || right == null) return false;
//        if (left.val != right.val) return false;
//        return isSymmetric(left.left, right.right) &&
//                isSymmetric(left.right, right.left);
//    }
//
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) return null;
//        TreeNode temp = root.left;
//        //交换左右子节点
//        root.left = root.right;
//        root.right = temp;
//        root.left = invertTree(root.left);//继续交换孩子节点
//        root.right = invertTree(temp);
//        return root;
//    }
//}

//class Solution {
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        List<Integer>[] map = new ArrayList[numCourses];
//        Arrays.setAll(map, o -> new ArrayList<>());
//
//        //初始化map，一个邻接表
//        for (int[] pre : prerequisites) {
//            map[pre[0]].add(pre[1]);
//        }
//        int[] colors = new int[numCourses];
//        //遍历每个课程看是否有环
//        for (int i = 0; i < numCourses; i++) {
//            if (colors[i] == 0)//只访问没有访问过的课程
//            {
//                if (!dfs(map, colors, i)) return false;
//            }
//        }
//        return true;
//    }
//
//    private boolean dfs(List<Integer>[] map, int[] color, int index) {
//        color[index] = 1;//正在访问当前课程
//
//        //遍历该课程的每个先修课程
//        List<Integer> list = map[index];
//        for (int preCourse : list) {
//            if (color[preCourse] == 2) continue;//跳出循环
//            if (color[preCourse] == 1) return false;//访问到了遍历中的数据，说明有环。
//            //如果先修课程还没被遍历过，就进行遍历
//            if (!dfs(map, color, preCourse)) return false;//dfs失败，说明找到了环
//        }
//        //这个课程的先修课程遍历完毕，设置成2
//        color[index] = 2;
//        //上面执行完都没错误，说明没问题
//        return true;
//    }
//}

//class Trie {
//
//    public static class Node {
//        Node[] son = new Node[26];
//        boolean end;
//    }
//
//    private final Node root = new Node();
//
//    public void insert(String word) {
//        Node cur = root;
//        for (char c : word.toCharArray()) {
//            int index = c - 'a';
//            if (cur.son[index] == null) {
//                cur.son[index] = new Node();
//            }
//            cur = cur.son[index];
//        }
//        cur.end = true;
//    }
//
//    public boolean search(String word) {
//        Node cur = root;
//        for (char c : word.toCharArray()) {
//            int index = c - 'a';
//            if (cur.son[index] == null) return false;
//            cur = cur.son[index];
//        }
//        return cur.end;
//    }
//
//    public boolean startsWith(String prefix) {
//        Node cur = root;
//        for (char c : prefix.toCharArray()) {
//            int index = c - 'a';
//            if (cur.son[index] == null) return false;
//            cur = cur.son[index];
//        }
//        return true;
//    }
//}

//class Solution {
//    public List<List<Integer>> permute(int[] nums) {
//        //创建一个答案列表
//        List<List<Integer>> ans = new ArrayList<>();
//        //Boolean数组，标志这个数字是否被使用
//        boolean[] used = new boolean[nums.length];
//        List<Integer> singleResult = Arrays.asList(new Integer[nums.length]);
//        dfs(0, used, nums, singleResult, ans);
//        return ans;
//    }
//
//    private void dfs(int index, boolean[] used, int[] nums, List<Integer> res, List<List<Integer>> ans) {
//        if (index == nums.length)//递归达到终点了
//        {
//            ans.add(new ArrayList<>(res));
//            return;
//        }
//        //没结束，尝试所有可用的数字
//        for (int i = 0; i < nums.length; i++) {
//            if (!used[i]) {
//                //这个数字仍未被使用
//                res.set(index, nums[i]);
//                used[i] = true;
//                dfs(index + 1, used, nums, res, ans);
//                used[i] = false;
//            }
//        }
//    }
//}

//class Solution {
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> ans = new ArrayList<>();
//        List<Integer> res = new ArrayList<>();
//        dfs(nums, res, 0, ans);
//        return ans;
//    }
//
//    private void dfs(int[] nums, List<Integer> res, int index, List<List<Integer>> ans) {
//        if (index == nums.length) {
//            //递归结束，写入结果
//            ans.add(new ArrayList<>(res));//复制一份结果写入，不然全部指向同一个对象了
//            return;
//        }
//        //分两种情况，一种取当前值，一种不取当前值
//        dfs(nums, new ArrayList<>(res), index + 1, ans);//不取当前值直接往后递归
//        res.add(nums[index]);//取当前值，继续往后递归
//        dfs(nums, new ArrayList<>(res), index + 1, ans);
//    }
//}

//class Solution {
//    public static final String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//    public char[] res;//结果char数组
//    private char[] nums;
//    List<String> ans = new ArrayList<>();
//
//    public List<String> letterCombinations(String digits) {
//        if (digits.isEmpty()) return ans;
//        res = new char[digits.length()];
//        this.nums = digits.toCharArray();
//        dfs(0);
//        return ans;
//    }
//
//    private void dfs(int index) {
//        if (index == nums.length) {
//            ans.add(new String(res));
//            return;
//        }
//        for (char c : map[nums[index] - '0'].toCharArray()) {
//            res[index] = c;
//            dfs(index + 1);
//        }
//    }
//}

//class Solution {
//    List<List<Integer>> ans = new ArrayList<>();
//    int[] candidates;
//
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<Integer> res = new ArrayList<>();
//        this.candidates = candidates;
//        dfs(res, target, 0, 0);
//        return ans;
//    }
//
//    private void dfs(List<Integer> res, int target, int index, int currentSum) {
//        if (currentSum > target) return;
//        if (currentSum == target) {
//            ans.add(new ArrayList<>(res));
//            return;
//        }
//        for (int i = index; i < candidates.length; i++) {
//            //先尝试加上当前下标的数
//            res.add(candidates[i]);
//            //然后递归
//            dfs(res, target, i, currentSum + candidates[i]);
//            //恢复现场，移除刚才添加的值
//            res.remove(res.size() - 1);
//
//        }
//    }
//}

//class Solution {
//    private List<String> ans = new ArrayList<>();
//    private int maxLength;
//    public List<String> generateParenthesis(int n) {
//        this.maxLength = n * 2;
//        dfs("(", n - 1, 1);
//        return ans;
//    }
//
//    private void dfs(String s, int num, int unclosed) {
//        if (s.length() == maxLength) {
//            ans.add(s);
//            return;
//        }
//        //每次递归可以有两个不同结果，一个是加(，一个是加)。
//        if (unclosed > 0) //仍然有未闭合的左括号，那就可以dfs加一个右括号
//            dfs(s + ")", num, unclosed - 1);
//        if (num > 0)
//            dfs(s + "(", num - 1, unclosed + 1);
//    }
//}

//class Solution {
//    public boolean exist(char[][] board, String word) {
//        //先找到开头第一个词
//        char[] chars = word.toCharArray();
//        boolean[][] used = new boolean[board.length][board[0].length];
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                if (board[i][j] == chars[0]) {
//                    //找到开头了，深度遍历
//                    used[i][j] = true;
//                    if (dfs(word.toCharArray(), 1, board, used, i, j)) {
//                        return true;
//                    }
//                    used[i][j] = false;
//                }
//            }
//        }
//        return false;
//    }
//
//    private boolean dfs(char[] word, int charIndex, char[][] board, boolean[][] used, int x, int y) {
//        if (charIndex == word.length)//说明找到了
//            return true;
//
//        //下面dfs查找
//        char targetChar = word[charIndex];
//        if (x - 1 >= 0 && board[x - 1][y] == targetChar && !used[x - 1][y]) {//往上查找
//            used[x - 1][y] = true;//设置为使用中。
//            if (dfs(word, charIndex + 1, board, used, x - 1, y)) {
//                return true;
//            }
//            used[x - 1][y] = false;//恢复现场
//        }
//        if (x + 1 <= board.length - 1 && board[x + 1][y] == targetChar && !used[x + 1][y]) {//往下查找
//            used[x + 1][y] = true;//设置为使用中。
//            if (dfs(word, charIndex + 1, board, used, x + 1, y)) {
//                return true;
//            }
//            used[x + 1][y] = false;//恢复现场
//        }
//        if (y - 1 >= 0 && board[x][y - 1] == targetChar && !used[x][y - 1]) {//往左查找
//            used[x][y - 1] = true;//设置为使用中。
//            if (dfs(word, charIndex + 1, board, used, x, y - 1)) {
//                return true;
//            }
//            used[x][y - 1] = false;//恢复现场
//        }
//        if (y + 1 <= board[0].length - 1 && board[x][y + 1] == targetChar && !used[x][y + 1]) {//往右查找
//            used[x][y + 1] = true;//设置为使用中。
//            if (dfs(word, charIndex + 1, board, used, x, y + 1)) {
//                return true;
//            }
//            used[x][y + 1] = false;//恢复现场
//        }
//        return false;
//    }
//}

//class Solution {
//    private String s;
//    private List<List<String>> ans = new ArrayList<>();
//    private final List<String> res = new ArrayList<>();
//
//    public List<List<String>> partition(String s) {
//        this.s = s;
//        dfs(0, 0);
//        return ans;
//    }
//
//    private void dfs(int i, int start) {
//        if (i == s.length()) {
//            ans.add(new ArrayList<>(res));
//            return;
//        }
//        //下面有两种情况，一种是在这里分隔，另一种情况就是不在这里分割
//
//        //在这里分割，那么必须保证前面是回文串
//        if (checkSubString(start, i)) {
//            res.add(s.substring(start, i + 1));//因为是左闭右开区间，就必须i+1
//            dfs(i + 1, i + 1);
//            res.remove(res.size() - 1);//恢复现场
//        }
//
//        //不在这里分割，让这个子串和后面的组成更大的子串
//        if (i < s.length() - 1)
//            dfs(i + 1, start);
//    }
//
//    boolean checkSubString(int start, int end) {
//        char[] chars = s.toCharArray();
//        while (start < end) {
//            if (chars[start] != chars[end])
//                return false;
//            start++;
//            end--;
//        }
//        return true;
//    }
//}

//class Solution {
//    private List<List<String>> ans = new ArrayList<>();
//    //先来个长度为n的数组，判断每一行的哪一列放置过皇后，用来放置结果
//    private int[] place;
//    //记录第c列上是否放置过皇后
//    private boolean[] onPath;
//    //维护两个boolean数组，查看主对角线和副对角线是否已经有了皇后
//    private boolean[] diagMain;//主对角线：/方向
//    private boolean[] diagSub;//副对角线：\方向
//    private int queenNums;//皇后数量
//
//    public List<List<String>> solveNQueens(int n) {
//        this.queenNums = n;
//        this.place = new int[n];
//        this.onPath = new boolean[n];
//        this.diagMain = new boolean[2 * n - 1];
//        this.diagSub = new boolean[2 * n - 1];
//        dfs(0);
//        return ans;
//    }
//
//    private void dfs(int r) {//r代表当前到了哪个行
//        if (r == this.queenNums) {//已经找到了全部皇后的位置
//            List<String> newAns = new ArrayList<>(queenNums);//预分配空间
//            for (int c : place) {
//                char[] newRow = new char[queenNums];
//                Arrays.fill(newRow, '.');
//                newRow[c] = 'Q';
//                newAns.add(new String(newRow));
//            }
//            ans.add(newAns);
//            return;
//        }
//        //下面开始本次遍历。
//
//        //遍历所有的列，看能不能放置皇后！
//        for (int column = 0; column < queenNums; column++) {
//            //下面进行条件判断
//            if (!onPath[column] &&//当前列还没放过皇后
//                    !diagMain[r + column] &&//主对角线上没冲突
//                    !diagSub[r - column + queenNums - 1]//副对角线上也没冲突
//            ) {
//                //可以放皇后辣！
//                onPath[column] = diagMain[r + column] = diagSub[r - column + queenNums - 1] = true;
//                place[r] = column;
//                //然后继续dfs找可能
//                dfs(r + 1);
//                //然后我们恢复现场
//                onPath[column] = diagMain[r + column] = diagSub[r - column + queenNums - 1] = false;
//                place[r] = 0;//这里其实没必要，因为满足上面的条件就会直接覆盖掉。
//            }
//        }
//    }
//}

//class Solution {
//    public int searchInsert(int[] nums, int target) {
//        int left = 0, right = nums.length - 1;
//        int mid;
//        while (left <= right) {
//            mid = (left + right) / 2;
//            if (nums[mid] == target) return mid;
//            if (nums[mid] < target) {
//                left = mid + 1;
//            } else right = mid - 1;
//        }
//        return left;
//    }
//}

//class Solution {
//    public boolean searchMatrix(int[][] matrix, int target) {
//        //先从第一列判断出目标数可能所在的行
//        int left = 0, right = matrix.length - 1;
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            if (matrix[mid][0] == target) return true;
//            if (matrix[mid][0] < target) {
//                left = mid + 1;
//            } else right = mid - 1;
//        }
//        //right所在的下标就是我们要找的
//        int row = (left + right) / 2;
//        left = 0;
//        right = matrix[0].length - 1;
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            if (matrix[row][mid] == target) return true;
//            if (matrix[row][mid] < target) {
//                left = mid + 1;
//            } else right = mid - 1;
//        }
//        return false;
//    }
//}

//class Solution {
//    public int[] searchRange(int[] nums, int target) {
//        if (nums.length == 0) return new int[]{-1, -1};
//        int left = 0, right = nums.length - 1;
//        int mid = 0;
//        while (left <= right) {
//            mid = (left + right) / 2;
//            if (nums[mid] == target) break;
//            if (nums[mid] < target) left = mid + 1;
//            else right = mid - 1;
//        }
//        //下面开始找左右两个端点
//        if (nums[mid] != target) return new int[]{-1, -1};
//        left = right = mid;
//        while (left - 1 >= 0 && nums[left - 1] == target) left--;
//        while (right + 1 < nums.length && nums[right + 1] == target) right++;
//
//        return new int[]{left, right};
//    }
//}

//class Solution {
//    public int search(int[] nums, int target) {
//        //思路，通过判断mid值跟数组最后一个值的大小比较，判断target和mid的位置相对关系。
//        int left = 0, right = nums.length - 1;
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            if (nums[mid] == target) return mid;
//            if (target > nums[nums.length - 1] && nums[nums.length - 1] > nums[mid])//目标值在第一递增段，当前mid在第二，target在mid左边
//                right = mid - 1;
//            else if (target <= nums[nums.length - 1] && nums[nums.length - 1] < nums[mid]) {//目标第二递增，当前第一递增
//                left = mid + 1;
//            } else {
//                //都不符合，说明二者在同一递增段
//                if (target < nums[mid]) right = mid - 1;
//                else left = mid + 1;
//            }
//        }
//        return -1;
//    }
//}

//class Solution {
//    public int findMin(int[] nums) {
//        int left = 0, right = nums.length - 1;
//        int end = nums[nums.length - 1];
//        int mid;
//        while (left <= right) {
//            mid = (left + right) >>> 1;
//            if (nums[mid] > end) {//当前位置在第一递增区，最小值还在右边
//                left = mid + 1;
//            } else right = mid - 1;
//        }
//        return nums[left];
//    }
//}

//class Solution {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int totalLength = nums1.length + nums2.length;
//        //看总长度是奇数还是偶数
//        if (totalLength % 2 == 1)//是奇数，返回中间那个
//        {
//            return getKthElement(nums1, nums2, totalLength / 2 + 1);
//        } else
//            return (getKthElement(nums1, nums2, totalLength / 2) + getKthElement(nums1, nums2, totalLength / 2 + 1)) / 2.0;
//    }
//
//    private int getKthElement(int[] nums1, int[] nums2, int k) {
//        int index1 = 0, index2 = 0;
//        int len1 = nums1.length, len2 = nums2.length;
//
//        while (true) {
//            if (index1 == len1) {
//                //说明第一个数组找不到数了，肯定在第二个数组里面
//                return nums2[index2 + k - 1];
//            } else if (index2 == len2) {
//                return nums1[index1 + k - 1];
//            }
//            if (k == 1) {
//                //遍历到这里k为1，直接比较两个数组当前遍历到下标的大小
//                return Math.min(nums1[index1], nums2[index2]);
//            }
//            //计算在num1和num2中要比较的元素索引
//            int half = k / 2;
//            //为了防止索引越界，取index+half和数组长度的最小值
//            int newIndex1 = Math.min(index1 + half, len1) - 1;
//            int newIndex2 = Math.min(index2 + half, len2) - 1;
//            //获取对应元素值
//            int pivot1 = nums1[newIndex1];
//            int pivot2 = nums2[newIndex2];
//
//            if (pivot1 <= pivot2) {
//                //左边的数字小于等于右边的
//                k -= newIndex1 - index1 + 1;
//                index1 = newIndex1 + 1;
//            } else {
//                k -= newIndex2 - index2 + 1;
//                index2 = newIndex2 + 1;
//            }
//        }
//    }
//}

//class Solution {
//    public boolean isValid(String s) {
//        Map<Character, Character> map = new HashMap<>();
//        map.put('{', '}');
//        map.put('(', ')');
//        map.put('[', ']');
//        Deque<Character> queue = new ArrayDeque<>();
//        for (char c : s.toCharArray()) {
//            if (map.containsKey(c)) queue.push(c);//是左符号，入栈
//            else {
//                if (queue.isEmpty()) return false;
//                char last = queue.pop();
//                if (!map.containsKey(last)) return false;//拿出来的是右符号
//                if (map.get(last) != c) return false;//左右符号不匹配
//            }
//        }
//        return queue.isEmpty();
//    }
//}

//class MinStack {
//    private final Deque<int[]> stack = new ArrayDeque<>();
//
//    public MinStack() {
//        stack.push(new int[]{0, Integer.MAX_VALUE});
//    }
//
//    public void push(int val) {
//        stack.push(new int[]{val, Math.min(val, getMin())});
//    }
//
//    public void pop() {
//        stack.pop();
//    }
//
//    public int top() {
//        return stack.peek()[0];
//    }
//
//    public int getMin() {
//        return stack.peek()[1];
//    }
//}

//class Solution {
//    public String decodeString(String s) {
//        Deque<Integer> numStack = new ArrayDeque<>();
//        Deque<String> stringStack = new ArrayDeque<>();
//        StringBuilder res = new StringBuilder();
//        int num = 0;
//        for (char c : s.toCharArray()) {
//            if (c == '[') {
//                numStack.push(num);
//                stringStack.push(res.toString());
//                num = 0;
//                res = new StringBuilder();
//            } else if (c == ']') {
//                int repeatTime = numStack.pop();
//                String string = stringStack.pop();
//                StringBuilder builder = new StringBuilder();
//                for (int i = 0; i < repeatTime; i++) {
//                    builder.append(res);
//                }
//                res = new StringBuilder(string + builder);
//            } else if (c >= '0' && c <= '9') {
//                num = num * 10 + Integer.parseInt(c + "");
//            } else {
//                res.append(c);
//            }
//        }
//        return res.toString();
//    }
//}

//class Solution {
//    public int[] dailyTemperatures(int[] temperatures) {
//        Deque<Integer> stack = new ArrayDeque<>();
//        int[] ans = new int[temperatures.length];
//        for (int i = 0; i < temperatures.length; i++) {
//            int temperature = temperatures[i];
//            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
//                int j = stack.pop();
//                ans[j] = i - j;
//            }
//            stack.push(i);
//        }
//        return ans;
//    }
//}

//class Solution {
//    public int largestRectangleArea(int[] heights) {
//        int ans = 0;
//        Deque<Integer> stack = new ArrayDeque<>();
//        int n = heights.length;
//        stack.push(-1);
//        for (int i = 0; i <= n; i++) {
//            int curHeight = i < n ? heights[i] : -1;
//            while (stack.peek() != -1 && curHeight < heights[stack.peek()]) {
//                int index = stack.pop();
//                ans = Math.max(ans, heights[index] * (i - stack.peek() - 1));
//            }
//            stack.push(i);
//        }
//        return ans;
//    }
//}

//class Solution {
//    public int findKthLargest(int[] nums, int k) {
//        int left = 0, right = nums.length - 1;
//        while (true) {
//            int pivot = partition(nums, left, right);
//            if (pivot == k - 1) return nums[pivot];
//            if (pivot < k - 1) left = pivot + 1;
//            else right = pivot - 1;
//        }
//    }
//
//    private int partition(int[] nums, int left, int right) {
//        int pivot = nums[left];//取左边当锚点
//        int originalPoint = left;
//        left += 1;
//        while (left <= right) {
//            if (nums[left] < pivot && nums[right] > pivot) {
//                int temp = nums[left];
//                nums[left] = nums[right];
//                nums[right] = temp;
//                left++;
//                right--;
//            }
//            if (nums[left] >= pivot) left++;
//            if (nums[right] <= pivot) right--;
//        }//递归完毕，
//        int temp = nums[originalPoint];
//        nums[originalPoint] = nums[right];
//        nums[right] = temp;
//        return right;
//    }
//}

//class Solution {
//    public int[] topKFrequent(int[] nums, int k) {
//        Map<Integer, Integer> map = new HashMap<>();
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return map.get(o1) - map.get(o2);
//            }
//        });
//
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//
//        for (int key : map.keySet()) {
//            if (priorityQueue.size() < k) {
//                priorityQueue.add(key);
//            } else {
//                if (map.get(key) > map.get(priorityQueue.peek())) {
//                    priorityQueue.remove();
//                    priorityQueue.add(key);
//                }
//            }
//        }
//        int[] result = new int[k];
//        for (int i = 0; i < k; i++) {
//            result[i] = priorityQueue.remove();
//        }
//        return result;
//    }
//}

//class MedianFinder {
//    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();//最小堆
//    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
//
//    //约定两边数量一样的时候，放在最小堆
//    public MedianFinder() {
//    }
//
//    public void addNum(int num) {
//        if (minHeap.size() == maxHeap.size()) {
//            maxHeap.add(num);
//            minHeap.add(maxHeap.poll());
//        } else {
//            minHeap.offer(num);
//            maxHeap.offer(minHeap.poll());
//        }
//    }
//
//    public double findMedian() {
//        if (minHeap.size() == maxHeap.size()) {
//            return (minHeap.peek() + maxHeap.peek()) / 2.0;
//        } else return minHeap.peek();
//    }
//}

//class Solution {
//    public int maxProfit(int[] prices) {
//        int cost = Integer.MAX_VALUE;
//        int profit = 0;
//        for (int price : prices) {
//            cost = Math.min(cost, price);
//            profit = Math.max(profit, price - cost);
//        }
//        return profit;
//    }
//}

//class Solution {
//    public boolean canJump(int[] nums) {
//        int maxIndex = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (i > maxIndex) return false;
//            maxIndex = Math.max(maxIndex, i + nums[i]);
//        }
//        return true;
//    }
//}

//class Solution {
//    public int jump(int[] nums) {
//        int currentBridge = 0;
//        int maxBridge = 0;
//        int ans = 0;
//        for (int i = 0; i < nums.length - 1; i++) {
//            maxBridge = Math.max(maxBridge, i + nums[i]);
//            if (i == currentBridge) {//到达最大长度，必须搭桥了
//                currentBridge = maxBridge;
//                ans++;
//            }
//
//        }
//        return ans;
//    }
//}

//class Solution {
//    public List<Integer> partitionLabels(String s) {
//        int[] lastIndex = new int[26];
//        List<Integer> ans = new ArrayList<>();
//        for (int i = 0; i < s.length(); i++) {
//            lastIndex[s.charAt(i) - 'a'] = i;
//        }
//        //遍历完毕，开始统计
//        int start = 0, end = 0;
//        for (int i = 0; i < s.length(); i++) {
//            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
//            if (end == i) {
//                //说明当前可以合并区间了
//                ans.add(end - start + 1);
//                start = i + 1;
//            }
//        }
//        return ans;
//    }
//}

//class Solution {
//    public int climbStairs(int n) {
//        //这里用递归+状态计算
//        int[] memory = new int[n + 1];
//        return dfs(n, memory);
//    }
//
//    private int dfs(int n, int[] memory) {
//        if (n <= 1) return 1;
//        if (memory[n] != 0) return memory[n];
//        return memory[n] = dfs(n - 1, memory) + dfs(n - 2, memory);
//    }
//}

//class Solution {
//    public List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> ans = new ArrayList<>();
//        ans.add(List.of(1));
//        for (int i = 1; i < numRows; i++) {
//            List<Integer> res = new ArrayList<>();
//            res.add(1);
//            for (int j = 1; j < i; j++) {
//                res.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
//            }
//            //最后一行还是1
//            res.add(1);
//            ans.add(res);
//        }
//        return ans;
//    }
//}

//class Solution {
//    private int[] memory;
//    private int[] nums;
//
//    public int rob(int[] nums) {
//        this.nums = nums;
//        this.memory = new int[nums.length];
//        Arrays.fill(memory, -1);
//        return dfs(nums.length - 1);
//    }
//
//    private int dfs(int n) {
//        if (n < 0) return 0;
//        else {
//            if (memory[n] != -1) return memory[n];
//            int res = Math.max(dfs(n - 1), dfs(n - 2) + nums[n]);
//            return memory[n] = res;
//        }
//    }
//}

//class Solution {
//    public int lengthOfLongestSubstring(String s) {
//        Map<Character, Integer> map = new HashMap<>();
//        int result = 0;
//        int leftIndex = -1;
//        for (int i = 0; i < s.length(); i++) {
//            if (map.containsKey(s.charAt(i))) {
//                leftIndex = Math.max(leftIndex, map.get(s.charAt(i)));
//            }
//            result = Math.max(result, i - leftIndex);
//            map.put(s.charAt(i), i);
//        }
//        return result;
//    }
//}

//class Solution {
//    private static int[][] memory = new int[101][10001];
//
//    static {
//        for (int[] mem : memory) {
//            Arrays.fill(mem, -1);
//        }
//    }
//
//    public int numSquares(int n) {
//        return dfs((int) Math.sqrt(n), n);
//    }
//
//    public int dfs(int currentNum, int sum) {
//        if (currentNum <= 0) {
//            return sum == 0 ? 0 : Integer.MAX_VALUE;
//        }
//        if (memory[currentNum][sum] != -1) return memory[currentNum][sum];
//        if (sum < currentNum * currentNum) {
//            //当前的数字的平方已经大于总和了，只能不选当前数字了
//            return memory[currentNum][sum] = dfs(currentNum - 1, sum);
//        }
//
//        //下面开始递归，有两种情况，要么选当前的数字，要么不选。
//        return memory[currentNum][sum] = Math.min(dfs(currentNum - 1, sum), dfs(currentNum, sum - currentNum * currentNum) + 1);
//        //这里最后的+1非常关键！表示如果选了当前数字，那么就+1，作为结果的res处理。
//    }
//}

//class Solution {
//    private int[] coins;
//    private int[] memory;
//
//    public int coinChange(int[] coins, int amount) {
//        int[] dp = new int[amount + 1];
//        Arrays.fill(dp, amount + 1);
//        dp[0] = 0;//找零0块，不需要硬币。
//        //开始遍历辣！
//        for (int i = 0; i <= amount; i++) {
//            //外层循环是对amount进行循环。
//            for (int j = 0; j < coins.length; j++) {
//                if (coins[j] <= i) {
//                    //当前的这个硬币的面值小于要找零的钱钱
//                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
//                }
//            }
//        }
//        return dp[amount] == amount + 1 ? -1 : dp[amount];
//    }
//
//}

//class Solution {
//    public boolean wordBreak(String s, List<String> wordDict) {
//        int leftIndex = 0;
//        boolean isMatch = false;
//        int maxWordLength = 0;
//        for (String word : wordDict) {
//            maxWordLength = Math.max(maxWordLength, word.length());
//        }
//
//        //用set方便查找，hashmap应该也可以，但不需要键值对
//        Set<String> set = new HashSet<>(wordDict);
//        boolean[] canMatch = new boolean[s.length() + 1];
//        canMatch[0] = true;//跟上一题一样，设置初始值
//        for (int i = 1; i <= s.length(); i++) {//这里i相当于右边界，且是开区间
//            for (int j = i - 1; j >= Math.max(0, i - maxWordLength); j--) {
//                if (canMatch[j] && set.contains(s.substring(j, i))) {
//                    //找到啦！
//                    canMatch[i] = true;
//                    break;
//                }
//            }
//        }
//        return canMatch[s.length()];
//    }
//}

//第一题
import java.util.Scanner;
import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        int T = in.nextInt(); //T组测试数据
        for (int x = 0; x < T; x++) {
            //这里是每一轮的测试数据

            int n = in.nextInt();
            long[] array = new long[n];
            int minIndex = -1;
            long minValue = Long.MAX_VALUE;
            Map<Long, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                //这里录入数据
                array[i] = in.nextLong();
                if (array[i] < minValue) {
                    minValue = array[i];
                    minIndex = i;
                }
                map.put(array[i], i);//key存储值，value是输入时候的索引
            }
            //下面我们对数组去排个序
            long[] sortedArray = new long[n];
            for (int i = 0; i < n; i++) {
                sortedArray[i] = array[i];
            }
            Arrays.sort(sortedArray);

            int walkLeft = 0, walkRight = 0;
            //数据录入完毕！并且找到了最小的元素的下标
            int currentIndex = map.get(sortedArray[0]);
            for (int i = 1; i < map.size(); i++) {
                int newIndex = map.get(sortedArray[i]);
                if (newIndex < currentIndex) walkLeft++;
                else walkRight++;

                currentIndex = newIndex;
            }
            System.out.println(walkRight + " " + walkLeft);
        }
    }
}
//第二题
import java.util.Scanner;
import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            //t轮数据
            int n = in.nextInt();
            String s = in.nextLine();
            s = in.nextLine();
            //System.out.println("当前拿到的字符串是"+s);
            char[] chars = s.toCharArray();
            //对char进行排序？
            char[] sortedChars = s.toCharArray();
            Arrays.sort(sortedChars);
            //创建一个哈希表，查看是否有重复出现的字母。
            Map<Character, Integer> map = new HashMap<>();
            boolean hasDuplicate = false;//看char里是否有重复出现过的字母，因为即使排序好也需要
            //进行一次交换操作，因此如果没有重复出现的字母，进行交换是不能做到保序的。
            for (char c : chars) {
                if (!map.containsKey(c)) map.put(c, 1);
                else {
                    hasDuplicate = true;
                    break;
                }
            }

            int notMatch = 0;
            for (int i = 0; i < n; i++) {
                if (notMatch >= 3) break;
                if (chars[i] != sortedChars[i]) notMatch++;
            }
            //判断
            if(notMatch==0){
                //说明排序前后是一致的，此时需要看是否有重复字母可以用来交换，没有的话就不行了
                if(hasDuplicate) System.out.println("YES");
                else System.out.println("NO");
            }
            else if(notMatch==2){
                //排序前后，恰好两个顺序不一样，那么交换它们就行，所以是可以的。
                System.out.println("YES");
            }
            else System.out.println("NO");//都不属于就不行了
        }
    }
}