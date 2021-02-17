package ThreadAndLocks;

public class ExampleB {
    public static void main(String args[]) {
        ThreadExample instance = new ThreadExample();
        instance.start();

        while (instance.count != 5) {
            try {
                Thread.sleep(2000);
                System.out.println("hi");
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
    }
}
