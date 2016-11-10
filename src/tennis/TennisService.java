package tennis;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/TennisService")
public class TennisService
{
   TennisDao tennisDao = TennisDao.getInstance();
      
   @GET
   @Path("/players")
   @Produces(MediaType.APPLICATION_JSON)
   public List<Player> getPlayers()
   {
      return tennisDao.getPlayers();
   }	
   
   @POST
   @Path("/players/{id}/setscore")
   @Produces(MediaType.APPLICATION_JSON)
   public void setScore(@PathParam("id") int id)
   {
	  //System.out.println("player id " + id);
	  Score score = Score.getInstance();
      tennisDao.setScore(id, score);      
   }   
   
   @GET
   @Path("/test")
   @Produces(MediaType.APPLICATION_JSON)
   public void test()
   {
      ScoreTest test = ScoreTest.getInstance();
      
      //15
      test.testFifteen();
   }	
   
}
