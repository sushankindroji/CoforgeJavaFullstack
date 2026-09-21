/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :10:16:26 am
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo2;

public class Exam {

	private String examName;
	private int duration;
	private QuestionPaper questionPaper; // Composition (HAS-A)

	public Exam(String examName, int duration, String syllabus, int totalQuestions) {
		this.examName = examName;
		this.duration = duration;

		// Create QuestionPaper object
		this.questionPaper = new QuestionPaper(syllabus, totalQuestions);
	}

	public void displayExamDetails() {
		System.out.println("Exam Name         : " + examName);
		System.out.println("Duration (Minutes): " + duration);
		questionPaper.displayQuestionPaperDetails();
	}
}
