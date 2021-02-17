import java.util.LinkedList;

public class SortWith2Stack {

    public void sortWith2Stack(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<>();
        // Write your solution here.
        Integer globalMin;
        int globalMinNum;


        while (!s1.isEmpty()) {
            int sizeS1 = s1.size();

            // shuffle from s1 to s2 to find globalMin
            globalMin = s1.pollLast();
            globalMinNum = 1;
            s2.offerLast(globalMin);
            for (int i = 0; i < sizeS1 - 1; i++) {
                Integer s1Pop = s1.pollLast();
                s2.offerLast(s1Pop);
                if (globalMin > s1Pop) {
                    globalMin = s1Pop;
                } else if (globalMin == s1Pop) {
                    globalMinNum++;
                }

            }

            // shuffle from s2 to s1 except  globalMin
            for (int j = 0; j < sizeS1; j++) {
                Integer s2Pop = s2.pollLast();
                if (s2Pop > globalMin) {
                    s1.offerLast(s2Pop);
                } else if (s2Pop < globalMin) {
                    s2.offerLast(s2Pop);
                }
            }


            // store back globalMin to s2
            for (int k = 0; k < globalMinNum; k++) {
                s2.offerLast(globalMin);
            }

        }
        s1 = s2;
    }
    public static void main(String[] args) {
        LinkedList<Integer> s1 = new LinkedList<>();
        s1.offerLast(2);
        s1.offerLast(1);
        s1.offerLast(1);
        SortWith2Stack solution = new SortWith2Stack();
        solution.sortWith2Stack(s1);

    }

}
