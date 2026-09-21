/**
 * Author :sushank2
 * Date :07-Jul-2026
 * Time :4:52:07 pm
 * Email : saisushankindroji1476@gmail.com
 */



package oopsdemo2;

public class HierarchicalInheritanceDemo {

	public static void main(String[] args) {

		LifeInsurance life = new LifeInsurance();
		life.setPolicyDetails("Ravi Kumar", 12000);
		life.setLifeInsuranceDetails(20);
		System.out.println("----- Life Insurance -----");
		life.displayLifeInsuranceDetails();

		System.out.println();

		HealthInsurance health = new HealthInsurance();
		health.setPolicyDetails("Anita Sharma", 8000);
		health.setHealthInsuranceDetails(500000);
		System.out.println("----- Health Insurance -----");
		health.displayHealthInsuranceDetails();

		System.out.println();

		VehicleInsurance vehicle = new VehicleInsurance();
		vehicle.setPolicyDetails("Suresh Rao", 6000);
		vehicle.setVehicleInsuranceDetails("Car");
		System.out.println("----- Vehicle Insurance -----");
		vehicle.displayVehicleInsuranceDetails();
	}
}
