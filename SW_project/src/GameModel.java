import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class GameModel {
	private  final String filePath = "games.txt";
	private Vector<Game> games;
	
	GameModel(){
		games =  new Vector<Game>();
		loadGames();
	}
	
	public void loadGames(){
		try {
			Scanner scan = new Scanner(new File(filePath), "UTF-8");
			
			int numOfGames = Integer.parseInt(scan.nextLine());
			for(int i=0; i<numOfGames; i++){
				String name = scan.nextLine();
				String subject = scan.nextLine();
				String category = scan.nextLine();
				int numOfQuestions = Integer.parseInt(scan.nextLine());
				String[] questionsData;
				int[] correctAnswers = new int[numOfQuestions];
				if(category.equals("MCQ")){
					questionsData = new String[numOfQuestions*5];
					for(int j=0; j<numOfQuestions*5 ; j++){
						String data = scan.nextLine();
						questionsData[j] = data;
					}
				}else{ // True-False
					questionsData = new String[numOfQuestions];
					for(int j=0; j<numOfQuestions ; j++){
						String data = scan.nextLine();
						questionsData[j] = data;
					}	
				}
			
				for(int j=0; j<numOfQuestions; j++){
					correctAnswers[j] = Integer.parseInt(scan.nextLine());
				}
				
				Game game = new Game(name, subject, category, numOfQuestions, questionsData, correctAnswers);
				
				games.add(game);
			
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Vector<Game> getGames() {
		return games;
	}

	public void setGames(Vector<Game> games) {
		this.games = games;
	}

	public void saveGamesData(){
		FileWriter writer;
		try {
			writer = new FileWriter(filePath);
			BufferedWriter buffer = new BufferedWriter(writer);
			
			buffer.write(((Integer)games.size()).toString());
			buffer.newLine();
			
			for(int i=0; i<games.size(); i++){
				buffer.write(games.get(i).getName());
				buffer.newLine();
				
				buffer.write(games.get(i).getSubject());
				buffer.newLine();
				
				buffer.write(games.get(i).getCategory());
				buffer.newLine();
				
				buffer.write(((Integer)games.get(i).getNumOfQuestions()).toString());
				buffer.newLine();
				
				for(int j=0; j<games.get(i).getQuestionsData().length; j++){
					buffer.write(games.get(i).getQuestionsData()[j]);
					buffer.newLine();
				}
				
				for(int j=0; j<games.get(i).getCorrectAnswers().length; j++){
					buffer.write(((Integer)games.get(i).getCorrectAnswers()[j]).toString());
					buffer.newLine();
				}
			}
			
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void addGame(Game g){
		games.add(g);
	}
}
