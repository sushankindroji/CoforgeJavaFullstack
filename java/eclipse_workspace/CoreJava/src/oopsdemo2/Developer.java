/**
 * Author :sushank2
 * Date :07-Jul-2026
 * Time :3:17:29 pm
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo2;

public class Developer extends Employee {

	private String skillSet;
	private String projectName;

	//generate constructor using fields
	public Developer(int empId, String name, String skillSet, String projectName) {
		super(empId, name); //call parent class constructor by passing empId and name
		this.skillSet = skillSet;
		this.projectName = projectName;
	}

	// method to display developer details
	public void displayDeveloperDetails() {
		System.out.println("Skill Set: " + skillSet);
		System.out.println("Project Name: " + projectName);
	}

}