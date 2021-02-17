import java.util.List;
import java.util.LinkedList;

public class FindSubSet {
    public void findSubset(char[] input, int index, StringBuilder solutionPrefix, List<String> ret) {
// index = 0 is initial state, 粉红色：表示直上直下的path
        System.out.println("index is " + index);
        System.out.println("solutionPrefix is " + solutionPrefix);
//        System.out.println("next added element is " + input[index]);
// base case
        if (index == input.length) {
            //System.out.println(solutionPrefix);
            String st = new String();
            st = solutionPrefix.toString();
            ret.add(solutionPrefix.toString());
            return;
        }

//        Line 5.5 // for the current layger, out current status of solutionPrefix


// case 1: add input[index] to the solution prefix
        solutionPrefix.append(input[index]); //吃
        findSubset(input, index + 1, solutionPrefix, ret);
        solutionPrefix.deleteCharAt(solutionPrefix.length() - 1); //🤮
// 为什么要吐出来？都是从5.5加过来的。try case1, case2前必须都是一样的5.5行的状态。solutionPrefix是一个全局变量，必须调回来。

// case 2: do not add input[index] to the solution prefix
        findSubset(input, index + 1, solutionPrefix, ret);

// 如果把这个case移到上面，不吐，也不行。必须吐。
    }

    public static void main(String[] args) {
        FindSubSet solution = new FindSubSet();
        StringBuilder solutionPrefix = new StringBuilder();
        char[] inputStr = new char[] {'a','b','c'};
        List<String> ret = new LinkedList<>();
        solution.findSubset(inputStr,0, solutionPrefix ,ret);


    }

}
