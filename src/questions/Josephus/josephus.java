package questions.Josephus;
//排队枪毙！最后一个留下来的人的编号！
public class josephus {
    public static int f(int n,int k){
        if(n==1) return 0;
        return (f(n-1,k)+k)%n;
    }
    public static void main(String[] args) {
        System.out.println(f(10,3));
    }
}
