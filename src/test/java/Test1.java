import java.util.Scanner;

public class Test1 extends Test2 {
    int x;

    public void intX() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter X: ");

        this.x = scanner.nextInt();

        Test2 test2 = new Test2();
        test2.x = this.x;
        test2.thisX();

        Test2 test22 = new Test2();

        System.out.println("X is: " + this.x);
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.intX();
    }
}
