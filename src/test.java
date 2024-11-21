public class test {
    public static boolean isPowerOfThree(int n) {
        return n > 0 && (Math.log(n) / Math.log(3)) ==
                Math.floor(Math.log(n) / Math.log(3));
    }
    public static void main(String[] args) {

        System.out.println(isPowerOfThree(243));
    }
}
