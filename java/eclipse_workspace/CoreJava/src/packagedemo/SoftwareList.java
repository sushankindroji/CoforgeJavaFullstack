/**
 * Author : Sushank
 * Date   : 09-Jul-2026
 * Time   : 3:38:04 PM
 * Email  : saisushankindroji1476@gmail.com
 */

package packagedemo;

public class SoftwareList {

    public static void main(String[] args) {

        Database db1 = new Database();
        OperatingSystem os1 = new OperatingSystem();

        System.out.println("********* Database Software *********");
        db1.printDatabaseSoftware();

        System.out.println("\n********* Operating System Software *********");
        os1.listSoftware();
    }
}