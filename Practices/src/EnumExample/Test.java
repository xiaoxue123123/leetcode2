package EnumExample;

public class Test {
    public static void main(String args[]) {
        RainbowColor color = RainbowColor.RED;
        RainbowColor[] colors = RainbowColor.values();
        for (RainbowColor c : colors) {
            System.out.println(c);
            System.out.println(c.ordinal());
        }

        RainbowColor color1 = RainbowColor.valueOf("RED");
        System.out.println(color1);

        System.out.println(color1 == color);

        try {
           System.out.println(RainbowColor.valueOf("red"));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException");
        } finally {
            System.out.println("no matter there is exception or not, caught or not, this will be printed");
        }
    }
}
