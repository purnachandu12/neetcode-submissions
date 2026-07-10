class Solution {
    public String intToRoman(int num) {
        StringBuffer s1=new StringBuffer();
        while(num>0){
            if(num>=1000){
                s1.append("M");
                num=num-1000;
            }
            else if(num>=500){
                if(num>=900 && num<=1000){
                    s1.append("CM");
                    num=num-900;
                    continue;
                }
                s1.append("D");
                num=num-500;
            }
            else if(num>=100){
                if(num>=400){
                    s1.append("CD");
                    num=num-400;
                    continue;
                }
                s1.append("C");
                num=num-100;
            }
            else if(num>=50){
                if(num>=90){
                    s1.append("XC");
                    num=num-90;
                    continue;
                }
                s1.append("L");
                num=num-50;
            }
            else if(num>=10){
                if(num>=40){
                    s1.append("XL");
                    num=num-40;
                    continue;
                }
                s1.append("X");
                num=num-10;
            }
            else if(num>=5){
                if(num==9){
                    s1.append("IX");
                    num=num-9;
                    continue;
                }
                s1.append("V");
                num=num-5;
            }
            else if(num>=1){
                if(num==4){
                    s1.append("IV");
                    num=num-4;
                    continue;
                }
                s1.append("I");
                num=num-1;
            }
        }
        return s1.toString();
    }
}