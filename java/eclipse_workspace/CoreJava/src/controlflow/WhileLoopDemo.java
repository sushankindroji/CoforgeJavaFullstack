package controlflow;

/**
 * Author :sushank2
 * Date :06-Jul-2026
 * Time :10:18:48 am
 * Email : saisushankindroji1476@gmail.com
 */

public class WhileLoopDemo {

    public static void main(String[] args) {

        //Loop Initialization
        int i=1;

        System.out.println("********* Forward Loop *********");
        //Set Condition to Loop
        while(i<=10) {
            System.out.println(i+" - James Gosling");

            //Increment the loop
            i = i+1;
        }

        System.out.println("********* Reverse Loop *********");

        int j=20;

        while(j>=1) {
            System.out.print(j+"\t");
            j=j-1;
        }
    }
}
