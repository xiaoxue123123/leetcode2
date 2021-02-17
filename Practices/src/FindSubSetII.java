import java.util.ArrayList;
import java.util.List;
public class FindSubSetII {
    public List<String> subSets(String set) {
        // Write your solution here.
        List<String> output = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        findSubset(set,0,str,output);
        return output;
    }

    private void findSubset(String input, int index, StringBuilder solutionPrefix, List output)
    {
        if (index == input.length()) {
            output.add(solutionPrefix.toString());
            return;
        }

// add the letter
        solutionPrefix.append(input.charAt(index));
        findSubset(input, index + 1, solutionPrefix,output);
        solutionPrefix.deleteCharAt(solutionPrefix.length() - 1);

// not add the letter
        findSubset(input,index + 1,solutionPrefix,output);

    }
    public static void main(String[] args) {
        FindSubSetII sol = new FindSubSetII();
        List<String> str = sol.subSets("abc");

    }
}
