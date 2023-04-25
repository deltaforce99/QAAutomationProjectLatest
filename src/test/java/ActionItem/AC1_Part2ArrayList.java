package ActionItem;

import java.util.ArrayList;

public class AC1_Part2ArrayList {
    public static void main(String[] args) {
    ArrayList<String> country = new ArrayList<>();
        country.add("Egypt");
        country.add("Argentina");
        country.add("China");
        country.add("Russia");
    //create an arraylist of countryCode(s)
        ArrayList<String> countryCode = new ArrayList<>();
        countryCode.add("20");
        countryCode.add("54");
        countryCode.add("86");
        countryCode.add("7");

        //loop the entire list of countries using for loop
        for (int i = 0; i <countryCode.size(); i++) {


            //Print out the country code
            System.out.println("My country is " + country.get(i) + " And my country code is " + countryCode.get(i));

        }//end of loop



    }//end of main
}//end of class
