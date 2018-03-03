package FlipkartDrive;

//import test.assignDriver;
import java.lang.*;

public class userScore implements Comparable {
	String u;
	int score;
	userScore(String u,int score){
		this.u=u;
		this.score=score;
	}
	public int compareTo(Object o){
		userScore a=(userScore)o;
		if(this.score==a.score)
			return 0;
		else if(this.score<a.score)
			return 1;
		else 
			return -1;
	}
}
