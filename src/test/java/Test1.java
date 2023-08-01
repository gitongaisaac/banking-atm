public class Test1 extends Test2 {
    int x;

    public Test1() {
        System.out.println("Constructor start");
        x = 30;
        System.out.println(this.account);
        this.account = 20;
        System.out.println(this.account);
        System.out.println("Constructor end");
    }

    public void method1() {
        System.out.println("Output from method " + this.account);
        System.out.println("X = " + this.x);
    }
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.method1();
        System.out.println(test1.account);
    }
}
