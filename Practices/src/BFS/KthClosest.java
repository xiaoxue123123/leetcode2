package BFS;

import java.util.*;

public class KthClosest {
    public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
        // create a minHeap to store List<Integer> with comparator compares dist
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(10, new Comparator<List<Integer>>(){
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                long d1 = dist(o1, a, b, c);
                long d2 = dist(o2, a, b, c);
                if (d1 == d2) {
                    return 0;
                }
                return d1 < d2 ? -1 : 1;
            }
        });

        Set<List<Integer>> set = new HashSet<>();
        List<Integer> cur = Arrays.asList(0,0,0);
        set.add(cur);
        minHeap.offer(cur);
        while (k > 0) {
            cur = minHeap.poll();
            System.out.println(a[cur.get(0)] + " " + b[cur.get(1)] + " " + c[cur.get(2)]);
            List<Integer> n = Arrays.asList(cur.get(0) + 1, cur.get(1), cur.get(2));
            if (n.get(0) < a.length && set.add(n)) {
                minHeap.offer(n);
            }

            n = Arrays.asList(cur.get(0), cur.get(1) + 1, cur.get(2));
            if (n.get(1)< b.length && set.add(n)) {
                minHeap.offer(n);
            }

            n = Arrays.asList(cur.get(0), cur.get(1), cur.get(2) + 1);
            if (n.get(2) < c.length && set.add(n)) {
                minHeap.offer(n);
            }
            k--;
        }
        cur.set(0,a[cur.get(0)]);
        cur.set(1,b[cur.get(1)]);
        cur.set(2,c[cur.get(2)]);
        return cur;
    }

    private long dist(List<Integer> point, int[] a, int[] b, int[] c) {
        long result = 0;
        result += a[point.get(0)] * a[point.get(0)];
        result += b[point.get(1)] * b[point.get(1)];
        result += c[point.get(2)] * c[point.get(2)];
        return result;

    }

    public static void main(String[] args) {
        KthClosest s = new KthClosest();
        int[] a = new int[]{1,2,3};
        int[] b = new int[]{2,4};
        int[] c = new int[]{1,2};
        List<Integer> result = s.closest(a,b,c,10);
        System.out.println(result);
    }


}

