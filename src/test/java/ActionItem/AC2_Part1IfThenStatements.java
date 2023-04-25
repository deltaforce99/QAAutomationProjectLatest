package ActionItem;

public class AC2_Part1IfThenStatements {
    public static void main(String[] args) {

        //declare the numeric variable grade

//when grade range is from 90 to 100 print grade as A
//when grade range is from 80 to less than 90 print grade as B
//when grade range is from 70 to less than 80 print grade as C
//when grade range is from 60 to less than 70 print grade as D
//anything below 60 is F

    int grade =5;

    //print when grade is more than 90 or equal to 90
if (grade >= 90 && grade <= 100) {
    System.out.println("Grade is A");
} else if (grade >= 80 && grade < 90) {
    System.out.println("Grade is B");
} else if (grade >=70 && grade <80) {
    System.out.println("Grade is 70");
}else if (grade >= 60 && grade < 70) {
    System.out.println("Grade is D");
} else{

}//end of conditional statements


    }//end of main
}//end of class

