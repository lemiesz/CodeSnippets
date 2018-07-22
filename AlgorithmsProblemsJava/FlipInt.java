public class FlipInt {
    public int flitInt(int x) {
        String xString = Integer.toString(x);
        int isNegative = 1;
        if(x < 0) {
            isNegative = -1;
            xString = xString.replace("-","");
        }
        String resultString = "";
        for(int i = xString.length() - 1; i >= 0; i--) {
            resultString += xString.charAt(i);
        }

        int result;
        try {
            result = Integer.parseInt(resultString);
        } catch(NumberFormatException e) {
            result = 0;
        }

        return isNegative * result;
    }

    public int flipIntInPlace(int x) {
        long result = 0;
        int isNegative = 1;
        if(x < 0) {
            isNegative = -1;
            x = x * -1;
        } 
        while(x > 0) {
            int lastDigit = x % 10;
            result = (result * 10) + lastDigit;
            x = x / 10;
        }

        return result <= Integer.MAX_VALUE ? (int) (isNegative * result) : 0;
    }
}