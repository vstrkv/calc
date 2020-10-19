import java.util.Scanner;
public class calcJM {
    public static void main(String[] args){
        CalcOff calcOff = new CalcOff();
        String[] str = new String[3];
        String[] strA = calcOff.scan();   //считываем значения

        if(strA.length != 3){ // я чувствую как это плохо, но я вот такой костыль сделал
            str[0] = "-1";
            str[1] = "+";
            str[2] = "-1";
        }
        else{ str = strA;}

        boolean flag = calcOff.terms(str[0]); // true -Rim; false -Arab
        if(flag)    //расчет по римски
        {
            flag = calcOff.terms(str[2]);  //вторая проверка
            if(flag){
                int num1 = calcOff.convert(str[0]);
                int num2 = calcOff.convert(str[2]);
                if((num1>0 && num1 < 11)&&(num2>0 && num2 < 11)){
                    int res = calcOff.ans(num1, num2, str[1]);
                    if(res == -188){
                        System.out.print("ERROR");
                    }
                    else calcOff.invConvert(res);
                }
            }
            else System.out.println("ERROR");
        }
        else{     //расчет по арабски
            flag = calcOff.terms(str[2]);
            if(flag) System.out.println("ERROR");
            else{
                int num1 = Integer.parseInt(str[0]);
                int num2 = Integer.parseInt(str[2]);
                if((num1>0 && num1 < 11)&&(num2>0 && num2 < 11)){
                    int res = calcOff.ans(num1, num2, str[1]);
                    if(res == -188){
                        System.out.print("ERROR");
                    }
                    else System.out.print(res);
                }
                else System.out.println("ERROR");
            }
        }
    }

}
class CalcOff {

    String[] scan() { //считываем данные
        Scanner str = new Scanner(System.in);
        String string = str.nextLine();
        String[] strAp;
        String del = " ";
        strAp = string.split(del);

        return strAp;
    }

    boolean terms(String s) { // провека условия
        return s.equals("I") || s.equals("II") || s.equals("III") || s.equals("IV") || s.equals("V") ||
                s.equals("VI") || s.equals("VII") || s.equals("VIII") || s.equals("IX") || s.equals("X");
    }

    int convert(String num) {
        int num1;

        if (num.equals("I")) num1 = Integer.parseInt("1");
        else if (num.equals("II")) num1 = Integer.parseInt("2");
        else if (num.equals("III")) num1 = Integer.parseInt("3");
        else if (num.equals("IV")) num1 = Integer.parseInt("4");
        else if (num.equals("V")) num1 = Integer.parseInt("5");
        else if (num.equals("VI")) num1 = Integer.parseInt("6");
        else if (num.equals("VII")) num1 = Integer.parseInt("7");
        else if (num.equals("VIII")) num1 = Integer.parseInt("8");
        else if (num.equals("IX")) num1 = Integer.parseInt("9");
        else if (num.equals("X")) num1 = Integer.parseInt("10");
        else num1 = 11;
        return num1;

    }

    void invConvert(int res) {
        int num = res / 10;
        if (res < 0) {
            System.out.print("-");
            res = -res;
        }
        if (num == 0) System.out.print("");
        else if (num == 1) System.out.print("X");
        else if (num == 2) System.out.print("XX");
        else if (num == 3) System.out.print("XXX");
        else if (num == 4) System.out.print("XL");
        else if (num == 5) System.out.print("L");
        else if (num == 6) System.out.print("LX");
        else if (num == 7) System.out.print("LXX");
        else if (num == 8) System.out.print("LXXX");
        else if (num == 9) System.out.print("XC");
        else if (num == 10) System.out.print("C");
        else System.out.print("ERROR");

        num = res - num * 10;

        if (num == 0 && res < 10) System.out.print("nulla");// беда с ответом 0 // nulla - ноль на Латинском

        if (num == 0) System.out.print("");
        else if (num == 1) System.out.print("I");
        else if (num == 2) System.out.print("II");
        else if (num == 3) System.out.print("III");
        else if (num == 4) System.out.print("IV");
        else if (num == 5) System.out.print("V");
        else if (num == 6) System.out.print("VI");
        else if (num == 7) System.out.print("VII");
        else if (num == 8) System.out.print("VIII");
        else if (num == 9) System.out.print("IX");
        else System.out.print("ERROR");

    }

    int ans(int a, int b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> -188; //недостежимое значение
        };
    }
}