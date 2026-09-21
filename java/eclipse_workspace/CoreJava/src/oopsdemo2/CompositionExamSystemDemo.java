/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :10:22:15 am
 * Email : saisushankindroji1476@gmail.com
 */


package oopsdemo2;

public class CompositionExamSystemDemo {

	public static void main(String[] args) {


		Exam ocjpExam = new Exam(
				"OCJP Certification",
				120,
				"Java Basics, OOP, Collections, Exceptions",
				60
				);

		System.out.println("----- OCJP Exam Details -----");
		ocjpExam.displayExamDetails();

		System.out.println();

		Exam microsoftExam = new Exam(
				"Microsoft Certification",
				150,
				"C#, .NET, Azure Fundamentals",
				50
				);

		System.out.println("----- Microsoft Exam Details -----");
		microsoftExam.displayExamDetails();

	}

}