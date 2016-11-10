package tennis;
import java.util.ArrayList;
import java.util.List;

public class TennisDao
{
  //instance
  private static TennisDao instance = null;	
  public List<Player> players = null;
	
  //Singleton
  public static TennisDao getInstance()
  {
      if (instance == null){
         instance = new TennisDao();
      }
      return instance;
  }
    
  public List<Player> getPlayers()
  {
	   this.setData(); 
	   return players;
  }
  
  //setScore
  public void setScore(int id, Score score)
  {	  
	  //setScore		  	  
	  players.get(id).setScore(1);
	  
	  //Players  	  
	  Player player1 = players.get(0);
	  Player player2 = players.get(1);
	 	  
	  //Tennis Scores
	  score.computeTennisScore(player1);
	  score.computeTennisScore(player2);
	  	  	  
	  //Deuce
	  score.computeDeuce(player1, player2);
	  
	  //Advantage
	  score.computeAdvantage(player1, player2);
	  score.computeAdvantage(player2, player1);
	 
	  //Game
	  score.computeGame(player1, player2);
	  score.computeGame(player2, player1);
	  	 
	  //Set
	  score.computeSet(player1, player2);
	  score.computeSet(player2, player1);
	  
	  //Match
	  score.computeMatch(player1);
	  score.computeMatch(player2);	
  }
  
  //Populate the data
  public void populate()
  {
	  players = new ArrayList<Player>();
	  
	  Player player1 = new Player(0, "JOUEUR 1", 0, 0, 0, 0, 0);      
	  players.add(player1);
      //saveUserList(userList);  
	  
	  Player player2 = new Player(1, "JOUEUR 2", 0, 0, 0, 0, 0);
	  players.add(player2);
  }
  
  //setData
  public void setData()
  {	
	  if (players == null)
	  {
		 this.populate();
	  }
  }
	 
}
