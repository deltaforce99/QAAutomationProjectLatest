package ActionItem;

public class AC1_LinearArray {
    public static void main(String[] args) {


        //declare a new string variable
        String[] regions = new String[]{"Brazil", "Argentina", "Canada", "UK"};
        //store the areaCode values
        int[] areaCode = new int[]{352, 326, 704, 214};

        //loop it
        for (int i = 0; i < areaCode.length; i++){

            //
            System.out.println(" My region is " + regions[i] +  " and my area code is " + areaCode[i]);
        }//end of loop

    }//end of main
}//end of class
