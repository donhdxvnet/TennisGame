package tennis;

//Compute the score
public class Score
{
	private static Score instance = null;	
	
	//getInstance
	public static Score getInstance()
	{
		if (instance == null){
			instance = new Score();
		}
		return instance;
	}
	
	public void computeTennisScore(Player player)
	{		  
		int score = player.getScore(); //Score
		switch (score)
		{
			case 1: player.setTennisScore(15);
			break;
			
			case 2: player.setTennisScore(30);
			break;
			
			case 3: player.setTennisScore(40);
			break;
		}
	}
	
	public void computeDeuce(Player playerA, Player playerB)
	{		 
		//Scores
		int score1 = playerA.getScore();
		int score2 = playerB.getScore();
		
		//Case 1: DEUCE
		if (score1 >= 3 && score2 >= 3 && score1 == score2)
		{
			//System.out.println("CASE 1");
			playerA.setGame("deuce");
			playerB.setGame("deuce");
		}
	}
	
	public void computeAdvantage(Player playerA, Player playerB)
	{
		//Case 2: ADVANTAGE		
		int score1 = playerA.getScore();
		int score2 = playerB.getScore();
		
		if (score1 >= 3)
		{		  
			//System.out.println("CASE 2");
			if (score1 - 1 == score2){
				playerA.setGame("advantage");
				playerB.setGame(null);
			}
		}
	}
	
	public void computeGame(Player playerA, Player playerB)
	{
		//Case 3: GAME
		int score1 = playerA.getScore();
		int score2 = playerB.getScore();
		
		if (score1 >= 4)
		{
			//System.out.println("CASE 3");
			if (score2 == 0 || score1 - score2 >= 2)
			{
				playerA.setGames(1);
				playerA.setScore(0);
				playerA.setTennisScore(0);
				playerA.setGame(null);

				playerB.setScore(0);
				playerB.setTennisScore(0);
				playerB.setGame(null);				
			}
		}
	}
		
	public void computeSet(Player playerA, Player playerB)
	{
		//Case 6: SET
		int games1 = playerA.getGames();
		int games2 = playerB.getGames();

		if (games1 >= 6)
		{
			if (games1 - games2 >= 2)
			{
				//System.out.println("CASE 6.1");
				playerA.setSets(1);				
				playerA.setGames(0);
				playerA.setScore(0);
				playerA.setTennisScore(0);
				playerA.setGame(null);
				
				playerB.setGames(0);
				playerB.setScore(0);
				playerB.setTennisScore(0);
				playerB.setGame(null);
			}			
		}
	}
	
	public void computeMatch(Player player)
	{
		 int sets = player.getSets();		 
		 if (sets == 3)
		 {
			player.setMatches(1);
			player.setSets(0);				
			player.setGames(0);
			player.setScore(0);
			player.setTennisScore(0);
			player.setGame(null);
		 }		 
	}
	
}
