abstract class Test3 {

    public Test3() {
        System.out.println("Constructor start");
        Test2 test1 = new Test2();
        System.out.println(test1.account);
        System.out.println("Constructor end");
    }

}
