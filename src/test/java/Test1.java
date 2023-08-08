public class Test1 extends Test3 {
        @Override
        public int calc() {
            int result = super.calc();

            return result + 30;
        }

    @Override
    public int sum() {
        return super.sum() + 30;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        System.out.println(test1.calc());
        System.out.println(test1.sum());
    }
}
