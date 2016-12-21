import java.util.Scanner;

public class Game {
	private String name;
	private String subject;
	private String category;
	private int numOfQuestions;
	private String[] questionsData;   // questions and possible answers
	private int[] correctAnswers;  // numbers from 1 to 4 in MCQ & 0 or 1 in true-false
	
	Game(String n, String s, String c, int q, String[] data, int[] answers){
		name = n;
		subject = s;
		category = c;
		numOfQuestions = q;
		questionsData = data;
		correctAnswers = answers;
	}
	
	Game(){
		name = "";
		subject = "";
		category = "";
		numOfQuestions = 0;
		questionsData = null;
		correctAnswers = null;
	}
	

	
	public Game choose(String name, GameModel gameModel){
		for(int i=0; i<gameModel.getGames().size(); i++){
			if(name.equals(gameModel.getGames().get(i).getName()))
				return gameModel.getGames().get(i);
		}
		
		return null;
	}
	
	public int play(){
		int[] userAnswers = new int[numOfQuestions];
		int score = 0;
		Scanner scan = new Scanner(System.in);
		
		// Display questions and take answers from user:
		if(category.equals("MCQ")){
			for(int i=0, j=0; i<numOfQuestions*5; i+=5, j++){
				System.out.println(questionsData[i] + "\n" + questionsData[i+1] + "\n" + questionsData[i+2] + "\n"
									+ questionsData[i+3] + "\n" + questionsData[i+4] + "\n");
				userAnswers[j] = scan.nextInt();
			}
		}else{
			for(int i=0; i<numOfQuestions; i++){
				System.out.println(questionsData[i] + "\n" + questionsData[i+1] + "\n" + questionsData[i+2] + "\n"
									+ questionsData[i+3] + "\n" + questionsData[i+4] + "\n");
				userAnswers[i] = scan.nextInt();
			}
		}
		
		// Calculate score:
		for(int i=0; i<numOfQuestions; i++){
			if(userAnswers[i] == correctAnswers[i])
				score++;
		}
		
		scan.close();
		return score;
	}
	
	public void createGame(){
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Name: ");
		this.setName(scan.nextLine());
		
		System.out.print("Subject: ");
		this.setSubject(scan.nextLine());
		
		System.out.print("Category: ");
		this.setCategory(scan.nextLine());
		
		System.out.print("Number of Questions: ");
		this.setNumOfQuestions(Integer.parseInt(scan.nextLine()));
		
		if(this.getCategory().equals("MCQ")){
			String[] questionsData = new String[this.getNumOfQuestions()*5];
			int[] correctAnswers = new int[this.getNumOfQuestions()];
			for(int i=0, j=0; i<this.getNumOfQuestions()*5; i+=5, j++){
				System.out.println("Enter question #" + (j+1) + " and its possible answers each on a separate line:");
				questionsData[i] = scan.nextLine();
				questionsData[i+1] = scan.nextLine();
				questionsData[i+2] = scan.nextLine();
				questionsData[i+3] = scan.nextLine();
				questionsData[i+4] = scan.nextLine();
				System.out.print("Enter correct answer number: ");
				correctAnswers[j] = Integer.parseInt(scan.nextLine());
			}
			this.setQuestionsData(questionsData);
			this.setCorrectAnswers(correctAnswers);
		}else{
			String[] questionsData = new String[this.getNumOfQuestions()];
			int[] correctAnswers = new int[this.getNumOfQuestions()];
			for(int i=0; i<this.getNumOfQuestions(); i++){
				System.out.println("Enter question #" + (i+1) + " and its correct answer each on a separate line:");
				questionsData[i] = scan.nextLine();
				correctAnswers[i] = Integer.parseInt(scan.nextLine());
			}
			this.setQuestionsData(questionsData);
			this.setCorrectAnswers(correctAnswers);
		}
		
		scan.close();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getNumOfQuestions() {
		return numOfQuestions;
	}

	public void setNumOfQuestions(int numOfQuestions) {
		this.numOfQuestions = numOfQuestions;
	}

	public String[] getQuestionsData() {
		return questionsData;
	}

	public void setQuestionsData(String[] questionsData) {
		this.questionsData = questionsData;
	}

	public int[] getCorrectAnswers() {
		return correctAnswers;
	}

	public void setCorrectAnswers(int[] correctAnswers) {
		this.correctAnswers = correctAnswers;
	}
	
	
}
