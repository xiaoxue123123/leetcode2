public class PowerOfTwo {
    public boolean powerOfTwo(int number){
        if (number <= 0) {
            return false;
        }
        int count = 0;
        while (number > 0) {
            count += number & 1;
            number >>>= 1;
        }
        return count == 1;
    }

    public static void main(String[] args){
        int i = 3;
        System.out.println(i&1);
        short a = -1;
        char b = (char) a;
        System.out.println("a" + a + "b" + b);
        String sab = 1 + "b";
        String sa = "1b";
        System.out.println(sab == sa );

    }
}
