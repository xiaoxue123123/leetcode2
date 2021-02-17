package DFS;

import java.util.ArrayList;
import java.util.List;

public class IfPairs {
    public List<String> ifPairs(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        DFS(n, 0, sb, result);
        // post processing, print
        return result;
    }

    private void DFS(int n, int left, StringBuilder sb, List<String> result) {
        // base case
        if (sb.length() == n * 2) {
            result.add(format(sb));
            return;
        }
        // case 1: left {
        if (left < n) {
            sb.append("{");
            DFS(n, left + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        // case 2: right }
        if (sb.length() - left < left) {
            sb.append("}");
            DFS(n, left, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    // indent: 下一层是做括号的话要缩进
    private String format(StringBuilder s) {
        int indent = 0;
        String print = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                for (int j = 0; j < indent; j++) {
                    print += "  "; // two space
                }
                print += "if {\n";
                indent++; // indent = indentation for next {. if next is }, indent--.
            } else {
                indent--;
                for (int j = 0; j < indent; j++) {
                    print += "  ";// two space
                }
                print += "}\n";
            }
        }
        return print;
    }

    public static void main(String[] args) {
        IfPairs s = new IfPairs();
        List<String> l = s.ifPairs(2);
        for (String str: l) {
            System.out.println(str);
        }
    }
}
