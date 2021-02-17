public class StackOverFlow {
    public static void print (int x) {
        if (x <= 0) {
            return;
        }
        print(x - 1);
        System.out.println(x);
        // return;
    }
    public static void main(String[] args) {
        StackOverFlow.print(10);
    }

}
