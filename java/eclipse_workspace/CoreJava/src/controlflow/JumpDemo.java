package controlflow;

/**
 * Author :sushank2
 * Date :06-Jul-2026
 * Time :12:08:16 pm
 * Email : saisushankindroji1476@gmail.com
 */

public class JumpDemo {

	public static void main(String[] args) {
		int i,j;

        System.out.println("Break Demo");
        for (i=1;i<=10;i++){
            if(i==6) break; // Terminates the Loop
            System.out.print(i+"\t");
        }
        
        System.out.println();
        System.out.println("Continue Demo");
        for (j=100;j>=90;j--){
            if(j==94)continue; // Skips the current Iteration in the Loop
            System.out.print(j+"\t");
        }

	}
	
}
