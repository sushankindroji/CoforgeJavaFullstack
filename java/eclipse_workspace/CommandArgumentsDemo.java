/** Java Program to pass Command Line Arguments
* at Run time from Command Prompt
*/

class CommandArgumentsDemo
{
    public static void main(String[] args)
    {
        // Declaration of variables
        int num1, num2, sum;
        String name;

        // Read command-line arguments
        name = args[0];
        num1 = Integer.parseInt(args[1]);
        num2 = Integer.parseInt(args[2]);

        // Calculate sum
        sum = num1 + num2;

        // Display output
        System.out.println("The Sum of 2 Numbers is : " + sum);
        System.out.println("This is " + name + " from Coforge Training Batch");
    }
}