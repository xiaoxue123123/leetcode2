import java.util.*;

public class FindAllAnagram {
    public List<Integer> allAnagrams(String s, String l) {
        List<Integer> result = new LinkedList<>();
        if (l.length() == 0) {
            return result;
        }
        if (s.length() > l.length()) {
            return result;
        }

        Map<Character, Integer> map = countMap(s);
        int match = 0;
        for (int i = 0; i < l.length(); i++) {
            char tmp = l.charAt(i);
            Integer count = map.get(tmp);
            if (count != null) {
                map.put(tmp, count - 1);
                if (count == 1) {
                    match++;
                }
            }
            if (i >= s.length()) {
                tmp = l.charAt(i - s.length());
                count = map.get(tmp);
                if (count != null) {
                    map.put(tmp, count + 1);
                    if (count == 0) {
                        match--;
                    }
                }
            }
            if (match == map.size()) {
                result.add(i - s.length() + 1);
            }
        }
        return result;
    }

    private Map<Character, Integer> countMap(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char ch: s.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null) {
                map.put(ch, 1);
            } else {
                map.put(ch, count + 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        FindAllAnagram s = new FindAllAnagram();
        List<Integer> result = s.allAnagrams("ab","abcba");
        System.out.print(result.toString());
    }
}
