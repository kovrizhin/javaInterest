package codewar;

public class Maskify {
    public static String maskify(String str) {
        StringBuilder res = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if(length - i <= 4){
                res.append(str.charAt(i));
            } else {
                res.append("#");
            }
        }
        return res.toString();
    }
}

