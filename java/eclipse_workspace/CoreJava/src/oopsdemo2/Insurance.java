/**
 * Author :sushank2
 * Date :07-Jul-2026
 * Time :4:48:36 pm
 * Email : saisushankindroji1476@gmail.com
 */


package oopsdemo2;

public class Insurance {
	
	String policyHolderName;
	double premiumAmount;
	
	 
	 void setPolicyDetails(String name, double premium) {
	     policyHolderName = name;
	     premiumAmount = premium;
	 }

	 void displayPolicyDetails() {
	     System.out.println("Policy Holder Name : " + policyHolderName);
	     System.out.println("Premium Amount     : " + premiumAmount);
	 }
}

//Child class 1
class LifeInsurance extends Insurance {

int policyTerm;

void setLifeInsuranceDetails(int term) {
   policyTerm = term;
}

void displayLifeInsuranceDetails() {
   super.displayPolicyDetails();
   System.out.println("Policy Term (Years): " + policyTerm);
}
}


//Child class 2
class HealthInsurance extends Insurance {

double coverageAmount;

void setHealthInsuranceDetails(double coverage) {
   coverageAmount = coverage;
}

void displayHealthInsuranceDetails() {
   displayPolicyDetails();
   System.out.println("Coverage Amount    : " + coverageAmount);
}
}


class VehicleInsurance extends Insurance {

String vehicleType;

void setVehicleInsuranceDetails(String type) {
   vehicleType = type;
}

void displayVehicleInsuranceDetails() {
   displayPolicyDetails();
   System.out.println("Vehicle Type       : " + vehicleType);
}}