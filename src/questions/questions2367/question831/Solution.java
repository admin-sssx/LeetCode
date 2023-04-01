package questions.questions2367.question831;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一条个人信息字符串 s ，可能表示一个 邮箱地址 ，也可能表示一串 电话号码 。返回按如下规则 隐藏 个人信息后的结果：
 *
 * 电子邮件地址：
 *
 * 一个电子邮件地址由以下部分组成：
 *
 * 一个 名字 ，由大小写英文字母组成，后面跟着
 * 一个 '@' 字符，后面跟着
 * 一个 域名 ，由大小写英文字母和一个位于中间的 '.' 字符组成。'.' 不会是域名的第一个或者最后一个字符。
 * 要想隐藏电子邮件地址中的个人信息：
 *
 * 名字 和 域名 部分的大写英文字母应当转换成小写英文字母。
 * 名字 中间的字母（即，除第一个和最后一个字母外）必须用 5 个 "*****" 替换。
 * 电话号码：
 *
 * 一个电话号码应当按下述格式组成：
 *
 * 电话号码可以由 10-13 位数字组成
 * 后 10 位构成 本地号码
 * 前面剩下的 0-3 位，构成 国家代码
 * 利用 {'+', '-', '(', ')', ' '} 这些 分隔字符 按某种形式对上述数字进行分隔
 * 要想隐藏电话号码中的个人信息：
 *
 * 移除所有 分隔字符
 * 隐藏个人信息后的电话号码应该遵从这种格式：
 * "***-***-XXXX" 如果国家代码为 0 位数字
 * "+*-***-***-XXXX" 如果国家代码为 1 位数字
 * "+**-***-***-XXXX" 如果国家代码为 2 位数字
 * "+***-***-***-XXXX" 如果国家代码为 3 位数字
 * "XXXX" 是最后 4 位 本地号码
 *  
 * 示例 1：
 *
 * 输入：s = "LeetCode@LeetCode.com"
 * 输出："l*****e@leetcode.com"
 * 解释：s 是一个电子邮件地址。
 * 名字和域名都转换为小写，名字的中间用 5 个 * 替换。
 * 示例 2：
 *
 * 输入：s = "AB@qq.com"
 * 输出："a*****b@qq.com"
 * 解释：s 是一个电子邮件地址。
 * 名字和域名都转换为小写，名字的中间用 5 个 * 替换。
 * 注意，尽管 "ab" 只有两个字符，但中间仍然必须有 5 个 * 。
 * 示例 3：
 *
 * 输入：s = "1(234)567-890"
 * 输出："***-***-7890"
 * 解释：s 是一个电话号码。
 * 共计 10 位数字，所以本地号码为 10 位数字，国家代码为 0 位数字。
 * 因此，隐藏后的电话号码应该是 "***-***-7890" 。
 * 示例 4：
 *
 * 输入：s = "86-(10)12345678"
 * 输出："+**-***-***-5678"
 * 解释：s 是一个电话号码。
 * 共计 12 位数字，所以本地号码为 10 位数字，国家代码为 2 位数字。
 * 因此，隐藏后的电话号码应该是 "+**-***-***-7890" 。
 *
 * 提示：
 *
 * s 是一个 有效 的电子邮件或者电话号码
 * 如果 s 是一个电子邮件：
 * 8 <= s.length <= 40
 * s 是由大小写英文字母，恰好一个 '@' 字符，以及 '.' 字符组成
 * 如果 s 是一个电话号码：
 * 10 <= s.length <= 20
 * s 是由数字、空格、字符 '('、')'、'-' 和 '+' 组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/masking-personal-information
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    boolean isEmail(String s) {
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '@') {
                return true;
            }
        }
        return false;
    }

    int getEmailFlagIndex(String s) {
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '@') {
                return i;
            }
        }
        return index;
    }
    public String maskPII(String s) {
        int emailFlagIndex = getEmailFlagIndex(s);
        //getEmailFlagIndex 可以用 s.indexOf() 代替
        if(emailFlagIndex>-1) {
            final String EMAIL_STAR = "*****";
            int nameLastIndex = emailFlagIndex - 1;
            //邮件脱敏处理
            s = s.toLowerCase();
            StringBuilder emailBuilder = new StringBuilder();
            emailBuilder.append(s.charAt(0))
                    .append(EMAIL_STAR)
                    .append(s.charAt(nameLastIndex));
            for (int i = emailFlagIndex; i < s.length(); i++) {
                emailBuilder.append(s.charAt(i));
            }
            return emailBuilder.toString();
        } else {
            //电话脱敏处理
//            //如果国家代码为 0 位数字
//            final String PREFIX_0 = "***-***-%s";
//
//            //如果国家代码为 1 位数字
//            final String PREFIX_1 = "+*-***-***-%s";
//
//            //如果国家代码为 2 位数字
//            final String PREFIX_2 = "+**-***-***-%s";
//
//            //如果国家代码为 3 位数字
//            final String PREFIX_3 = "+***-***-***-%s";
//            可以考虑正则表达式直接替换出数字外的分隔符。
//            s = regex_replace(s, regex("[^0-9]"), "");
            final String[] PREFIX_ARR= {"***-***-%s","+*-***-***-%s","+**-***-***-%s","+***-***-***-%s"};

            Set<Character> phoneSplit = new HashSet<>();
            phoneSplit.add('+');
            phoneSplit.add('-');
            phoneSplit.add('(');
            phoneSplit.add(')');
            phoneSplit.add(' ');
            //char [] phoneSplit = {'+', '-', '(', ')', ' '};
            int phoneLength = s.length();
            StringBuilder suffix = new StringBuilder();
            for (int i = s.length() -1 ; i >= 0; i--) {
                if(phoneSplit.contains(s.charAt(i))) {
                    phoneLength--;
                } else {
                    if(suffix.length()<4) {
                        suffix.insert(0,s.charAt(i));
                    }
                }
            }
            return String.format(PREFIX_ARR[phoneLength-10],suffix);
        }
    }
    @Test
    public void test() {
//        String s = new String("AsD@23.cOm");
//        String s2 = s.toLowerCase();
//        System.out.println(s);
//        System.out.println(s2);
        String str = maskPII("AsD@23.cOm");
        System.out.println(str);

        String str2 = maskPII("1(234)567-890");
        System.out.println(str2);
    }
}
