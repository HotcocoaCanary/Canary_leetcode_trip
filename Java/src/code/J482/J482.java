package code.J482;

public class J482 {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();

        String[] strings = s.split("-");

        if (strings.length<1) {
            return "";
        }

        // 计算第一个字符串长度
        int sumLength = 0;
        for (String string : strings) {
            sb.append(string);
            sumLength += string.length();
        }
        int firstLen = sumLength % k;

        if (firstLen == 0) {
            firstLen = k;
        }

        StringBuilder result = new StringBuilder();
        String str = sb.toString();
        result.append(str.substring(0, firstLen).toUpperCase());

        for (int i = firstLen; i < str.length(); i += k) {
            if (!result.isEmpty()) {
                result.append("-");
            }

            // 确保 substring 不会越界
            int end = Math.min(i + k, s.length());
            result.append(str.substring(i, end).toUpperCase());
        }


        return result.toString();

    }
}
