public class Dashatizer {

    /** my solution */
    public static String dashatize(int num) {
        String answer = "";
        String[] numStrArr = Integer.toString(num).replace("-", "").split("");
        for (int i=0; i<numStrArr.length; i++) {
            if (i==numStrArr.length-1) {
                answer = answer + numStrArr[i];
            } else {
                if (Integer.parseInt(numStrArr[i+1])%2==0 && (Integer.parseInt(numStrArr[i])%2==0)) {
                    answer = answer + numStrArr[i];
                } else {
                    answer = answer + numStrArr[i] + "-";
                }
            }
        }
        return answer;
    }
}