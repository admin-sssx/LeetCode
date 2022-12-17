package questions.question5;

import util.Srand;

import java.util.function.Consumer;

class Solution {
    /**
     * 暴力破解，遍历所有子串，找出最长的回文串
     * 时间复杂度O(n^3)
     * @param str
     * @return
     */

    public static String f1(String str) {
        String target = "";
        int count =1 ;
        /**
         * 按照子串长短输出子串
         */
        int len = str.length();

        while(len>0){
            for (int i = 0; i <= str.length() ; i++) {
                boolean flag = true;
                int j = i+len;
                if(j>str.length()){
                    break;
                }
                String tmp = str.substring(i,j);
                System.out.print("string:::");
                System.out.println(tmp);
                int k=0;
                int l=tmp.length()-1;
                while(k<l){
                    if(tmp.charAt(k)!=tmp.charAt(l)){
                        flag=false;
                    }
                    k++;
                    l--;
                    count++;
                }
                if(flag==true){
                    System.out.println("the target ::"+tmp);
                    target = tmp;
//                    j=str.length();
                    len=-1;
                    break;
                }

            }
            len--;
        }
        System.out.println("target="+target+",count = "+count+",length="+str.length());
        return target;
    }

    /**
     * 动态规划
     *      jb1          a2            b3       a4          d5
     * i b1  b1         b1a2         b1a2b3   b1a2b3a4   b1a2b3a4d5
     *  a2  a2b1         a2           a2b3     a2b3a4     a2b3a4d5
     *  b3  b3a2b1      a2b3         b3        b3a4       b3a4d5
     *  a4  a4b3a2b1    a2b3a4       b3a4       a4       a4d5
     *  d5  d5  a2b3a4d5     b3a4d5   a4d5         d5
     *
     *  此种虽然用到了动态规划，这并不是最优的动态规划,空间复杂度过高
     * @return
     */
    public static String f2(String s) {
        int count = 1;
        String target = "";
        int maxi = 0;
        int maxj = 0;
        String[][] data = new String[s.length()][s.length()];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length() ; i++) {
            for (int j = 0; j < s.length(); j++) {
                if(i<j) {
                    data[i][j] = data[i][j-1]+charArray[j];
                } else if(i>j) {
                    data[i][j]  = charArray[i]+data[i-1][j];
                } else {
                    data[i][j] =  Character.toString(charArray[i]);
                }
                if(data[i][j].equals(data[j][i])) {
                    if(data[i][j].length()>target.length()) {
                        target = data[i][j];
                        maxi = i;
                        maxj = j;
                    }
                }
                count++;
            }
        }
        System.out.print("("+maxi+","+maxj+")");
        System.out.println("target="+target+",count = "+count+",length="+s.length());
        return target;
    }

    /**
     * 动态规划2
     * @param s
     * @return
     */
    public static String f3(String s) {
        int count = 0 ;
        if(s.length()<2) {
            return s;
        }
        char str[] = s.toCharArray();
        boolean data[][] = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            data[i][i] = true;
        }
        int maxLen =1;
        int maxi = 0;
        int maxj = 0;
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if(j==37) {
                    System.out.print("");

                }
                if(str[i]==str[j]) {
                    System.out.print("("+i+","+j+")");

                    if(j-i == 1) {
                        data[i][j] = true;
                    } else {
                        data[i][j] = data[i+1][j-1];
                    }
                } else {
                    data[i][j] = false;
                }
                if(data[i][j] == true) {
                    if(maxLen < (j-i + 1)) {
                        maxLen = j-i + 1;
                        maxi = i;
                        maxj = j;
                    }
                }
                count++;
            }
        }

//        for (int i = 0; i < s.length(); i++) {
//            for (int j = 0; j < s.length(); j++) {
//                if(data[i][j] == true)
//                    System.out.print("("+i+","+j+")");
//            }
//            System.out.println();
//        }
        System.out.println("target="+s.substring(maxi,maxi+maxLen)+",count = "+count+",length="+s.length());
        return s.substring(maxi,maxi+maxLen);
    }


    static int f3count = 0;

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        char[] cs = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {// 最后一个字符没必要枚举了
            for (int j = i + 1; j < len; j++) {
                // 最长回文串：长度>之前的max，且，是回文串
                if (j - i + 1 > maxLen && isPalindrome(cs, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                } else {
                    f3count++;
                }
            }
        }
        System.out.println("target="+s.substring(begin, begin + maxLen)+",count = "+f3count+",length="+s.length());
        return s.substring(begin, begin + maxLen);
    }

    private static boolean isPalindrome(char[] cs, int i, int j) {
        while (i < j) {
            if (cs[i] != cs[j]) {
                return false;
            }
            i++;
            j--;
            f3count++;
        }
        return true;
    }

    public String reverseOnlyLetters(String s) {
//        int maxlen=0;
//        String temp="";
//        for(int i=0;i<s.length()-1;i++){
//            for(int j=i+1;j<s.length();j++)
//            {
//
//                if(temp.indexOf(s.charAt(i)) != -1 ){
//                    maxlen = temp.length();
//                    continue;
//                }
//                temp=s.substring(i,j);
//
//            }
//        }
//
        return s;
    }
}
public class Test {
    public static void main(String[] args) {
//        Solution sol =  new Solution();
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.next();
//        System.out.println(sol.reverseOnlyLetters(s));
        /**
         * 输出所有子串
         */
        Srand srand = new Srand();
        String str = srand.srandStrLower(5);
        System.out.println(str);
        for (int i = 0; i <= str.length() ; i++) {
            for (int j = i; j <= str.length(); j++) {
                System.out.println(str.substring(i,j));
            }
        }
//        str = "daomdukomcayjwgmmetypncdeixarhbectjcwftjjtwjrctixtrsehegwlfotpljeeqhntacfihecdjysgfmxxbjfeskvvfqdoedfxriujnoeteleftsjgdsagqvcgcdjbxgmguunhbjxyajutohgbdwqtjghdftpvidkbftqbpeahxbfyamonazvubzirhqseetaneptnpjbtrtitttxsyjckjvwtrmuwgidkofvobrwrffzrpnxbectsydbvswstfiqranjzhsebjnmprjoirqkgttahrivkcjtitdcpohwwerwgrdivqbltfnigavydxpmitttjjzyrmpaptkczzgnsovebvxezkkovgqegctxacvjfqwtiycnhartzczcgosiquhmdbljjzyrnmffcwnkyzytnsvyzayrieqyrfpxintbbiyrawxlguzaisedwabpzvevlejadztuclcpwvonehkhknicdksdcnjfaoeaqhcdkdtywilwewadcnaprcasccdcnvdgjdqirrsqwzhqqorlhbgpelpupdvuynzybcqkffnnpocidkkigimsa";
        str = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        str = "babad";

        str = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
//        str = "aacabdkacaa";
//        Solution.f1(str);
//        Solution.f2(str);
        Solution.f3(str);
        /**
         * 判断子串是否为回文串
         */
//        System.out.println(str);
//        System.out.println(str.substring(1,2));
        Consumer consumer =(x)->{

        };
    }
}
