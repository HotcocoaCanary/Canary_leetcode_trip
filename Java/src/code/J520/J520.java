package code.J520;

public class J520 {

    private boolean isAllUppercase(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLowerCase(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isAllLowercase(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isFirstUppercase(String str) {
        if(Character.isUpperCase(str.charAt(0))){
            for (int i = 1; i < str.length(); i++) {
                if (Character.isUpperCase(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean detectCapitalUse(String word) {
        return isAllLowercase(word) || isFirstUppercase(word) || isAllUppercase(word);
    }
}
