public class Triangle {

    public static String classify(int a, int b, int c) {
        // 输入验证
        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println("输入无效");
            return "无效输入";
        }

        // 三角形不等式验证
        if (!((a + b > c) && (a + c > b) && (b + c > a))) {
            System.out.println("不满足三角形不等式，是无效三角形");
            return "无效三角形";
        }

        // 分类判断
        if (a == b && b == c) {
            System.out.println("该三角形是等边三角形，边长为：" + a);
            return "等边三角形";
        } else if (a == b || b == c || a == c) {
            System.out.println("该三角形是等腰三角形");
            return "等腰三角形";
        } else {
            System.out.println("该三角形是一般三角形");
            return "一般三角形";
        }
    }
}