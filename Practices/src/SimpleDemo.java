public class SimpleDemo {
    static class Simple {
        public int value;

        public Simple(int val) {
            this.value = val;
        }
    }

    public static void main(String[] args) {
        int x = 5;
        changeValue(x);
        System.out.print(x + ", ");

        Simple s1 = new Simple(5);
        changeValue1(s1);
        System.out.print(s1.value + ", ");

        Simple s2 = new Simple(5);
        changeValue2(s2);
        System.out.print(s2.value + ", ");

        Simple s3 = new Simple(5);
        changeValue3(s3);
        System.out.print(s3.value);
    }

    private static void changeValue(int y) {
        y = 10;
    }

    private static void changeValue1(Simple simple) {
        Simple newSimple = new Simple(10);
        simple = newSimple;
    }

    private static void changeValue2(Simple simple) {
        simple.value = 10;
    }

    private static Simple changeValue3(Simple simple) {
        Simple newSimple = new Simple(10);
        return newSimple;
    }
}
