/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author XiaoxuShen
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     * 
     * Add a number to array and if there is carry increase array size. 
---------------------------------------------------------------------- 
For example input = {7,3,5,3,9} convert this to number 73539, add 1 so it becomes 73540 and convert to array {7,3,5,4,0}. 
Array can be of any length, so you can't always represent array in form of in-built number format. 
So you have to do this summation in-place. Also, how would you increase array size in-case input = {9,9,9} so output = (1,0,0,0} 
Assume, all elements of arrays are between 0 and 9.
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        // TODO code application logic here
        int[] test = {1,2,3,4,5};
        
        System.out.println(AddNumToArray(test, 5555));
        System.out.println();
    }
    public static int[] AddNumToArray(int[] Array, int AddNumber){
        int carry = 0;
        int[] newArray;
        int ii = Array.length;
        //get every digit of AddNumber and add into array. 
        //from last digit of Array traverse back see if there are digit exceed 10, if it is add array to next digit. If the last digit 
        //has carry one. Make a new array and copy array's elements into new array after the first element which is number one. 
        while(AddNumber != 0){
            Array[ii - 1] += AddNumber%10;
            ii--;
            AddNumber = AddNumber/10;
        }
        for(int jj = Array.length - 1; jj > 0; jj--){
            if(Array[jj] >= 10){
                Array[jj] = Array[jj] - 10;
                if(jj - 1 > 0){
                Array[jj - 1] += 1;
                }else{
                    carry = 1;
                }
            }
        }
        if(carry == 1){
            newArray = new int[Array.length + 1];
            for (int kk = 0; kk < newArray.length; kk++){
                if(kk == 0){
                    newArray[kk] = 1;
                }else{
                    newArray[kk] = Array[kk - 1];
                }
            }
            return newArray;
        }
        return Array;
    }
}
