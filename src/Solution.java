class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int half = arr.length / 2;
        int left = 0, right = arr.length - 1;

        while (true) {
            if (arr[half] > arr[half - 1] && arr[half] < arr[half + 1]) {
                //说明需要往右上山。
                left = half;
                half = (half + right) / 2;

            } else if (arr[half] < arr[half - 1] && arr[half] > arr[half + 1]) {
                //说明需要往左上山。
                right = half;
                half = (half + left) / 2;
            } else {
                //说明已经到达山顶。
                return half;
            }
        }
    }
}