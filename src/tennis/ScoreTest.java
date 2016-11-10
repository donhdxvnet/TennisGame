package tennis;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

//Compute the score
public class ScoreTest
{
	private static ScoreTest instance = null;
	private List<Player> players = null;
	
	//getInstance
	public static ScoreTest getInstance()
	{
		if (instance == null){
			instance = new ScoreTest();
		}
		return instance;
	}
	
	//Populate the data
	  private void populate()
	  {
		  players = new ArrayList<Player>();
		  
		  Player player1 = new Player(0, "JOUEUR 1", 0, 0, 0, 0, 0);      
		  players.add(player1);
		  //saveUserList(userList);  
		  
		  Player player2 = new Player(1, "JOUEUR 2", 0, 0, 0, 0, 0);
		  players.add(player2);
	  }
		
	public void testFifteen()
	{
		this.populate();		
		
		Player player = players.get(0);
		player.setScore(1);
		Score score = Score.getInstance();
		score.computeTennisScore(player);
		int tennisScore = player.getTennisScore();
		
		int tennisScoreTest = 15;				
		assertEquals(tennisScoreTest, tennisScore);
	}
	
	public void testThirty()
	{
		this.populate();		
		
		Player player = players.get(0);
		player.setScore(2);
		Score score = Score.getInstance();
		score.computeTennisScore(player);
		int tennisScore = player.getTennisScore();
		
		int tennisScoreTest = 30;				
		assertEquals(tennisScoreTest, tennisScore);
	}
	
	public void testForty()
	{
		this.populate();		
		
		Player player = players.get(0);
		player.setScore(3);
		Score score = Score.getInstance();
		score.computeTennisScore(player);
		int tennisScore = player.getTennisScore();
		
		int tennisScoreTest = 40;				
		assertEquals(tennisScoreTest, tennisScore);
	}
	
	public void testDeuce()
	{
		this.populate();	
		
		Player player1 = players.get(0);
		player1.setScore(3);
		
		Player player2 = players.get(0);
		player2.setScore(3);
				
		Score score = Score.getInstance();
		score.computeDeuce(player1, player2);
		assertEquals(player1.getGame(), "deuce");
		assertEquals(player2.getGame(), "deuce");
	}
	
	public void testAdvantage()
	{
		this.populate();	
		
		Player player1 = players.get(0);
		player1.setScore(4);
		
		Player player2 = players.get(0);
		player2.setScore(3);
				
		Score score = Score.getInstance();
		score.computeAdvantage(player1, player2);
		assertEquals(player1.getGame(), "advantage");
		assertEquals(player2.getGame(), "");
	}
		
	public void testGame()
	{
		this.populate();	
		
		Player player1 = players.get(0);
		player1.setScore(5);
		
		Player player2 = players.get(0);
		player2.setScore(3);
				
		Score score = Score.getInstance();
		score.computeGame(player1, player2);
		assertEquals(player1.getGames(), 1);
		assertEquals(player2.getGames(), 0);
	}
	
	public void testSet()
	{
		this.populate();	
		
		Player player1 = players.get(0);
		player1.setGames(6);
		
		Player player2 = players.get(0);
		player2.setGames(4);
				
		Score score = Score.getInstance();
		score.computeSet(player1, player2);
		assertEquals(player1.getSets(), 1);
		assertEquals(player2.getSets(), 0);
	}
	
	public void testMatch()
	{
		this.populate();	
		
		Player player = players.get(0);
		player.setSets(3);
						
		Score score = Score.getInstance();
		score.computeMatch(player);
		assertEquals(player.getMatches(), 1);
	}
}
