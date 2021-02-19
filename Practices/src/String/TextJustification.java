package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        /**
         data structure:
         - wordPtr: linear scan words
         - fill prev lines:
         - add a word, a space until if adding more word will exceed maxWidth
         - calculate gap between maxWidth and end of last word
         - add space into gap
         - add string to result list
         - fill last line:
         - add all rest of words but still can't satisfy maxWidth
         - add words
         - add space to fill maxWidth

         prev line:
         - no space before first word, or after last word
         - space is evenly distributed between words, and left justified if can't.


         last line:
         - left justified




         **/

        int index = 0;
        int last = 0;
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        while (last < words.length) {
            int curLen = 0;
            last = index;
            while (last < words.length && curLen <= maxWidth) {
                curLen += words[last].length();
                curLen += 1;
                last++;
            }
            //System.out.println(last);
            int numGap = last - index - 2;



            // last line
            if(curLen <= maxWidth || numGap == 0) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    sb.append(" ");
                }

                for (int i = 0; i < maxWidth - curLen; i++) {
                    sb.append(" ");
                }
                result.add(sb.toString());


            } else { // prev lines
                curLen = curLen - words[last - 1].length() - 2;
                last = last - 2;

                // update gap space
                // System.out.println(last + "  " + index);
                // System.out.println(curLen);

                int remainder = maxWidth - curLen;
                int space = remainder / numGap;
                int rest = remainder % numGap;
                //System.out.println("rest" + rest);
                // build cur line
                int restUsed = 0;
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    sb.append(" ");
                    for (int j = index; j < space; j++) {
                        sb.append(" ");
                    }
                    if (restUsed < rest) {
                        sb.append(" ");
                        restUsed++;
                    }
                }
                sb.append(words[last]);
                index = last + 1;
                result.add(sb.toString());
                sb = new StringBuilder();

            }
        }

        return result;

    }

    public static void main(String[] args) {
        TextJustification s = new TextJustification();
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        List<String> ans = s.fullJustify(words, 16);
        System.out.println(ans);
    }
}