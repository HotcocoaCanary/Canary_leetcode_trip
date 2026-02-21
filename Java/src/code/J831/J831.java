package code.J831;

import java.util.Locale;

public class J831 {

    // 邮箱正则匹配规则
    // 一个 名字 ，由大小写英文字母组成，后面跟着
    // 一个 '@' 字符，后面跟着
    // 一个 域名 ，由大小写英文字母和一个位于中间的 '.' 字符组成。'.' 不会是域名的第一个或者最后一个字符。
    String emailSchema = "^[a-zA-Z]+@[a-zA-Z]+\\.[a-zA-Z]+$";

    // 电话号正则匹配规则
    // 电话号码可以由 10-13 位数字组成
    // 后 10 位构成 本地号码
    // 前面剩下的 0-3 位，构成 国家代码
    // 利用 {'+', '-', '(', ')', ' '} 这些 分隔字符 按某种形式对上述数字进行分隔
    String phoneSchema = "^(?=(?:\\D*\\d){10,13}\\D*$)[+()\\s-]*\\d[\\d+()\\s-]*$";

    public String maskPII(String s) {
        if (s.matches(emailSchema)) {
            return maskEmail(s);
        }
        if (s.matches(phoneSchema)) {
            return maskPhone(s);
        }
        return s;
    }

    private String maskPhone(String s) {
        String phone = s.replaceAll("[+\\-()\\s]", "");
        int phoneLen = phone.length();
        String maskPhone = phone.substring(phoneLen - 4, phoneLen);
        return switch (phoneLen) {
            case 10 -> "***-***-" + maskPhone;
            case 11 -> "+*-***-***-" + maskPhone;
            case 12 -> "+**-***-***-" + maskPhone;
            case 13 -> "+***-***-***-" + maskPhone;
            default -> s;
        };
    }

    private String maskEmail(String s) {
        StringBuilder sb = new StringBuilder();
        String str = s.toLowerCase();
        String name = str.split("@")[0];
        String maskName = name.charAt(0) + "*****" + name.charAt(name.length() - 1);
        sb.append(maskName);
        sb.append("@");
        sb.append(str.split("@")[1]);
        return sb.toString();
    }
}
