/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :10:16:56 am
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo2;

public class QuestionPaper {

    private String syllabus;
    private int totalQuestions;

    public QuestionPaper(String syllabus, int totalQuestions) {
        this.syllabus = syllabus;
        this.totalQuestions = totalQuestions;
    }

    public void displayQuestionPaperDetails() {
        System.out.println("Syllabus          : " + syllabus);
        System.out.println("Total Questions   : " + totalQuestions);
    }
}

