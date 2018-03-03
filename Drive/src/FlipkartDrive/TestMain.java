package FlipkartDrive;
import java.util.*;
import java.lang.*;
public class TestMain {
	Map<String,String> hm1=new HashMap<>();
	Map<String,Integer> hm2=new TreeMap<>();
	Queue<userScore> q=new PriorityQueue<>();
	Queue<userScore> q1=new PriorityQueue<>();
	void upsert_User(String s,String c){
		//user u=new user(s,c);
		hm1.put(s, c);
		System.out.println(s+ " added to leaderboard");
	}
	void upsert_Score(String s,int i){
		userScore u=new userScore(s,i);
		q.add(u);
		hm2.put(s, i);
	}
	void getTopNUser(int n){
		int count=0;
		if(hm2.size()<n){
			System.out.println("User on leaderboard is less than "+ n);
			return;
		}
/*		int k=hm2.size()-n;
		for(String obj:hm2.keySet()){
			if(count>=k)
			System.out.print(obj+" ");
			count++;
		}*/
		//for(userScore obj:q){
		System.out.print("Top "+n+" users are :");
		
		while(true){
			userScore p=q.remove();
			q1.add(p);
			System.out.print(p.u+" ");
			count++;
			if(count==n){
				System.out.println();
				break;
			}
		}
		while(q1.size()!=0){
			q.add(q1.remove());
		}
/*		while(q.size()!=0)
			System.out.print(q.remove().u);
		System.out.println();*/
		
	}
	void getUserScoreN(int n){
		int count=0;
		for(String obj:hm2.keySet()){
			if(hm2.get(obj)==n){
				System.out.print(obj+" ");
				count++;
			}
		}
		if(count==0)
			System.out.print("No such user exists");	
		System.out.println();
	}
/*	void getNUserCountry(String c,int n){
		int count=0;
		for(String obj:hm2.keySet()){
			for(String obj1:hm1.keySet()){
				if(obj==obj1&&hm1.get(obj1).equals(c)){
		System.out.print(obj1+" ");
				break;
				}
			}
			count++;
			if(count==n)
				break;
		}
		System.out.println();
	}*/
	void getNUserCountry(String c,int n){
		int count=0;
		int count1=0;
/*		while(true){
			userScore p=q.remove();
			q1.add(p);
			for(String obj1:hm1.keySet()){
				if(p.u.equals(obj1)&&hm1.get(obj1).equals(c)){
					//System.out.print(p.u+" ");
					count1++;
					break;
				}
			}
			//count++;
			if(count1<n){
				System.out.println(n+ " value is greater");
				return;
			}
		}*/
		for(String obj:hm1.keySet()){
			if(hm1.get(obj).equals(c))
				count1++;
		}
		if(count1<n){
			System.out.println(c+ " value is less than "+ n);
			return;
		}
		
		
		
		while(true){
			userScore p=q.remove();
			q1.add(p);
			for(String obj1:hm1.keySet()){
				if(p.u.equals(obj1)&&hm1.get(obj1).equals(c)){
					System.out.print(p.u+" ");
					count++;
					break;
				}
			}
			//count++;
			if(count==n){
				System.out.println();
				break;
			}
		}
		while(q1.size()!=0){
			q.add(q1.remove());
		}
	}
	void printLeaderBoard(){
		System.out.println("Name   Country   Score");
		for(String obj:hm1.keySet()){
			System.out.println(obj+"   "+hm1.get(obj)+"   "+hm2.get(obj)+"   ");
		}
		System.out.println();
		System.out.println();
	}

	public static void main(String[] args) {
		//System.out.println("Hi");
		TestMain m=new TestMain();
		m.upsert_User("Nikhil","India");
		m.upsert_User("Rahul","India");
		m.upsert_Score("Rahul",1);
		m.upsert_Score("Nikhil",5);
		m.upsert_User("Karan","Argentina");
		m.upsert_Score("Karan",1);
		m.upsert_User("Rohit","India");
		m.upsert_Score("Rohit",8);
		m.upsert_User("Ram","US");
		m.upsert_Score("Ram",10);
		m.printLeaderBoard();
		m.getTopNUser(8);
		m.getUserScoreN(8);
		m.getNUserCountry("India",8);
		m.getNUserCountry("Argentina",2);

		
		
		

	}

}
