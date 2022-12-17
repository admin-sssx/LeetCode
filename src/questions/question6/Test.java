package questions.question6;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public String convert(String s, int numRows) {
        List<StringBuffer> list = new ArrayList<>();
        for (int i = 0; i < numRows ; i++) {
            list.add(i,new StringBuffer());
        }
        int si = 0;
        char direction = 'd';
        int col = 0;

        if(numRows<2){
            return s;
        }
        while(si<s.length()){
            for (int i = 0; i < numRows-1 ; i++) {
                while(list.get(i).length()<col){
                    list.get(i).append(" ");
                }
                list.get(i).insert(col,s.charAt(si));
                si++;
                if(si>=s.length()){
                    break;
                }
            }
            if(si>=s.length()){
                break;
            }
            for (int i = numRows-1; i > 0 ; i--) {
                while(list.get(i).length()<col){
                    list.get(i).append(" ");
                }
                list.get(i).append(s.charAt(si));
                si++;
                col++;
                if(si>=s.length()){
                    break;
                }
            }
            if(si>=s.length()){
                break;
            }
        }
        StringBuffer str = new StringBuffer() ;
//        for (int k = 0; k <numRows ; k++) {
//            System.out.println(list.get(k));
//            str.append(list.get(k));
//        }

//        System.out.println(str.toString().replace(" ",""));
        return str.toString().replace(" ","");

    }
}

public class  Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s1 = solution.convert("LEETCODEISHIRING",3);
        String s2 = solution.convert("vnmkefzeeijamxsixyusduiftcvvgfxbvjozqndvymxmmpujnobtljyentbtabxvmlwdazaaoxnamhlcymxjxxnmsqisrfoeskhumhvcgieurpypdvycsnokewfvdtbvfkqttnvzvzumqsctocviqmvuiarovvjafbwbotalvualpehfgenwqisbkmpfjaiqeeruxsgsoggdknisryrkilltzayiaizemszmmhgbpogbbrtvpkfxwqsxsrgsbhzqzacmjkpyzvzcmuxdfcbdutammifqpggrikfruurvrqygmxjtamwuizhwhomzwsseexxbtowkgwssucmwqksalbxtplungmtklqlegkqmijhcnvafhtgtufomsizywvlhlynskdgtmpxbkyhstplpubbojdnhyaolabflgmgvddwqdfiwwvmqwphhswosweeyhljpxpkdvjtyqdvnajfyymftivlgbrfidoxcgkfdtybjbyybjeziqgbzdofeimmlbmpjwvorvrczqbcbfejxmmwqbeulqjwtvnetiumgmohepjfwnruadsqgymrrvpmsdtnnnztzoadfmjezaybfstmtifkfvyyyrnlfnhedjkivvoxxoachwqcewmjrkjrexejklppxbxuwott",
                515);
//        System.out.println(s1.equals("LCIRETOESIIGEDHN"));
//        System.out.println(s2.equals("LEETCODEISHIRING"));
//        StringBuffer s = new StringBuffer(5);
//        s.insert(0,"s");
//        int index = 3;
//        while(s.length()< index){
//            s.append("x");
//        }
//        s.insert(index,"3");
//        System.out.println(s);
//        System.out.println(s1.toString());
    }
}