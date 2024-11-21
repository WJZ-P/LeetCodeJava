//class Solution {
//    public int sum(int num1, int num2) {
//        return num1 + num2;
//    }
//}

//2469. 温度转换
//class Solution {
//    public double[] convertTemperature(double celsius) {
//        return new double[]{celsius+273.15,celsius*1.8+32};
//    }
//}

//2413. 最小偶倍数
//class Solution {
//    public int smallestEvenMultiple(int n) {
//        if (n <= 2) return 2;
//        return (2 * n) / gcd(n, 2);
//    }
//
//    private int gcd(int a, int b) {
//        while (b != 0) {
//            int temp = b;
//            b = a % b;
//            a = temp;
//        }
//        return a;
//    }
//}

//class Solution {
//    public int countGoodTriplets(int[] arr, int a, int b, int c) {
//        int result = 0;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i+1; j < arr.length; j++) {
//                for (int k = j+1; k < arr.length; k++) {
//                    if (Math.abs(arr[i] - arr[j]) <= a &&
//                            Math.abs(arr[j] - arr[k]) <= b &&
//                            Math.abs(arr[i] - arr[k]) <= c)
//                        result++;
//                }
//            }
//        }
//        return result;
//    }
//}