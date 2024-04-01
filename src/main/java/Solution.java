class Solution {
    public String solveEquation(String equation) {
        String[] arr = equation.split("=");
        String left = arr[0];
        String right = arr[1];
        int xCoeffL = 0;
        int constantR = 0;
        int cur = 1000;
        int sign = 1;
        boolean isCoeff = false;

        for(int i = 0; i < left.length(); i++){
            if(i == 0 && left.charAt(i) == '-'){
                sign = -1;
                continue;
            }
            if(Character.isDigit(left.charAt(i))){
                if(cur == 1000){
                    cur = left.charAt(i) - '0';
                }else{
                    cur = cur * 10 + (left.charAt(i) - '0');
                }
            }else if(left.charAt(i) == 'x'){
                if(cur == 1000){
                    cur = 1;
                }
                isCoeff = true;
            }else {
                if(isCoeff){
                    xCoeffL += cur * sign;
                }else{
                    constantR -= cur * sign;
                }
                isCoeff = false;
                cur = 1000;
                if(left.charAt(i) == '-'){
                    sign = -1;
                }else{
                    sign = 1;
                }
            }
        }

        if(isCoeff){
            xCoeffL += cur * sign;
        }else{
            constantR -= cur * sign;
        }
        
        sign = 1;
        isCoeff = false;
        cur = 1000;
        for(int i = 0; i < right.length(); i++){
            if(i == 0 && right.charAt(i) == '-'){
                sign = -1;
                continue;
            }
            if(Character.isDigit(right.charAt(i))){
                if(cur == 1000){
                    cur = right.charAt(i) - '0';
                }else{
                    cur = cur * 10 + (right.charAt(i) - '0');
                }
            }else if(right.charAt(i) == 'x'){
                if(cur == 1000){
                    cur = 1;
                }
                isCoeff = true;
            }else {
                if(isCoeff){
                    xCoeffL -= cur * sign;
                }else{
                    constantR += cur * sign;
                }
                isCoeff = false;
                cur = 1000;
                if(right.charAt(i) == '-'){
                    sign = -1;
                }else{
                    sign = 1;
                }
            }
        }
        if(isCoeff){
            xCoeffL -= cur * sign;
        }else{
            constantR += cur * sign;
        }
        if(xCoeffL == 0 && constantR != 0){
            return "No solution";
        }
        if(xCoeffL == 0){
            return "Infinite solutions";
        }
        int res = constantR / xCoeffL;

        return "x=" + res;


    }
}