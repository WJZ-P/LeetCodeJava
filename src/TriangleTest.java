import junit.framework.TestCase;

public class TriangleTest extends TestCase {

    // 等价类测试用例
    public void testGeneralTriangle() {
        assertEquals("一般三角形", Triangle.classify(3, 4, 5));
        assertEquals("一般三角形", Triangle.classify(5, 6, 7));
    }

    public void testIsoscelesTriangle() {
        assertEquals("等腰三角形", Triangle.classify(5, 5, 6)); // a=b
        assertEquals("等腰三角形", Triangle.classify(5, 6, 5)); // a=c
        assertEquals("等腰三角形", Triangle.classify(6, 5, 5)); // b=c
    }

    public void testEquilateralTriangle() {
        assertEquals("等边三角形", Triangle.classify(5, 5, 5));
        assertEquals("等边三角形", Triangle.classify(1, 1, 1));
    }

    public void testInvalidInput() {
        assertEquals("无效输入", Triangle.classify(0, 1, 2));   // 零值
        assertEquals("无效输入", Triangle.classify(-3, 4, 5)); // 负值
    }

    public void testInvalidTriangle() {
        assertEquals("无效三角形", Triangle.classify(1, 2, 3));    // 1+2=3
        assertEquals("无效三角形", Triangle.classify(10, 5, 3));  // 5+3<10
        assertEquals("无效三角形", Triangle.classify(1, 1, 2));   // 1+1=2 (边界情况)
    }

    // JUnit 3 测试入口
    public static void main(String[] args) {
        junit.textui.TestRunner.run(TriangleTest.class);
    }
}