import java.lang.Math;

public class Grade {

    public char gradeLetter(int credit, String number){

        double num = Math.ceil(Double.parseDouble(number));
        char grade = 'Z';

        if(credit == 3){
            if(num >= 240 && num <= 300)
                grade = 'A';
            else if(num >= 210 && num<= 239)
                grade = 'B';
            else if(num >= 180 && num<= 209)
                grade = 'C';
            else if (num< 180 && num >= 0)
                grade = 'F';
        }

        if(credit == 4){
            if(num >= 320 && num <= 400)
                grade = 'A';
            else if(num >= 280 && num<= 319)
                grade = 'B';
            else if(num >= 240 && num<= 279)
                grade = 'C';
            else if (num< 240 && num >= 0)
                grade = 'F';
        }

        if(grade == 'Z') {
            if(num < 0)
                System.out.println("Invalid number " + number + " that exceeds lower bound");
            else
                System.out.println("Invalid number " + number + " that exceeds upper bound");
        }

        return grade;
    }
}
