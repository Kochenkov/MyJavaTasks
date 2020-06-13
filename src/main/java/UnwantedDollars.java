import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnwantedDollars {

    /** my solution */
    public static double moneyValue(String money) {
        Pattern pattern = Pattern.compile("-{0,1}[0-9]*\\.{0,1}[0-9]*");
        Matcher matcher = pattern.matcher(money);
        double answer = 0.0;
        String str = "";
        while (matcher.find()) {
            str = str + money.substring(matcher.start(), matcher.end());
        }
        if (str.length()>0) {
            if (str.length()!=1 || !str.contains("-")) {
                answer = Double.parseDouble(str);
            }
        }
        return answer;
    }

    /** best practice
    public static double moneyValue(String money){
        try {
            return Double.parseDouble(money.replaceAll("[ $]", ""));
        }
        catch(NumberFormatException e) {
            return 0.0;
        }
    }
     */
}