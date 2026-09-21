/**
 * Author : sushank2
 * Date : 10-Jul-2026
 * Time : 12:05:41 pm
 * Email : saisushankindroji1476@gmail.com
 */

package collectionsdemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayerList {

    private ArrayList<String> playerArray;
    private List<String> subList;

    public PlayerList() {

        playerArray = new ArrayList<>();
        subList = new ArrayList<>();
    }

    // Add players
    public void addPlayer() {

        playerArray.add("Martina");
        playerArray.add("Serena");
        playerArray.add("Venus");
        playerArray.add("Serena");
        playerArray.add("Sachin");
        playerArray.add("Dravid");
        playerArray.add("Ganguly");
        playerArray.add("Laxman");

        System.out.println("Players added successfully.\n");
    }

    // Display players
    public void display() {

        System.out.println("****************************************");
        System.out.println("Display Players using Iterator");
        System.out.println("****************************************");

        Iterator<String> itr = playerArray.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println();
    }

    // Search player
    public void search() {

        System.out.println("****************************************");
        System.out.println("Search Player");
        System.out.println("****************************************");

        System.out.println("First occurrence of \"Serena\" : "
                + playerArray.indexOf("Serena"));

        System.out.println("Last occurrence of \"Serena\"  : "
                + playerArray.lastIndexOf("Serena"));

        System.out.println();
    }

    // Extract SubList
    public void extract() {

        System.out.println("****************************************");
        System.out.println("Extract Sub List");
        System.out.println("****************************************");

        subList = playerArray.subList(4, playerArray.size());

        System.out.println("Sub List : " + subList);

        System.out.println();
    }
}