package tennis;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "players")
public class Player implements Serializable
{
   private static final long serialVersionUID = 1L;
   private int id;
   private String name;   
   private int tennisScore = 0;
   private int score = 0;
   private int games = 0; //int
   private String game = null; //String
   private int sets = 0;
   private int matches = 0;

   public Player(){}
   
   public Player(int id, String name, int tennisScore, int score, int games, int sets, int matches){
      this.id = id;
      this.name = name;      
      this.tennisScore = tennisScore;
      this.score = score;
      this.games = games;
      this.sets = sets;      
      this.matches = matches;
   }

   public int getId() {
      return id;
   }

   @XmlElement
   public void setId(int id) {
      this.id = id;
   }
   public String getName() {
      return name;
   }
   
   @XmlElement
   public void setName(String name) {
      this.name = name;
   }
   
   public int getTennisScore()
   {
	   return this.tennisScore;
   }
   
   @XmlElement
   public void setTennisScore(int tennisScore)
   {
	  this.tennisScore = tennisScore;
   }
   
   public int getScore()
   {
	   return this.score;
   }
   
   @XmlElement
   public void setScore(int score)
   {
	   if (score == 1)
		   this.score++;
	   else if (score == 0)
		   this.score = 0;
   }
   
   public String getGame()
   {
	   return game;
   }
   
   @XmlElement
   public void setGame(String game)
   {	   
	   this.game = game;
   }
   
   public int getGames()
   {
	   return this.games;
   }
   
   @XmlElement
   public void setGames(int game)
   {
	   if (game == 1) this.games++;
	   else if (game == 0) this.games = 0;
   }
   
   public int getSets()
   {
	   return sets;
   }
   
   @XmlElement
   public void setSets(int set)
   {
	   if (set == 1) this.sets++;
	   else if (set == 0) this.sets = 0;
   }
   
   public int getMatches()
   {
	   return this.matches;
   }
   
   @XmlElement
   public void setMatches(int match)
   {
	   if (match == 1) this.matches++;
   }
   
} 