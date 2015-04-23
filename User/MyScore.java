
public class MyScore {
	
	private Integer score;
	
	private Integer numCorrect;
	
	private Integer totalQuestions;
	
	public Integer getScore(){
		return score;
	}
	
	public void calculateScore(){
		
		score = numCorrect/totalQuestions;
	}

}
