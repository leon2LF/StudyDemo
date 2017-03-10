package com.cards;

import java.awt.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class StartGame {
	private ArrayList<Card> cardsList;
	private String[] type = {"方片","梅花","黑桃","红桃"};
	private Player AA;
	private Player BB;
	private Scanner input;
	
	public StartGame(){
		this.cardsList = new ArrayList<Card>();
		this.AA = new Player();
		this.BB = new Player();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StartGame sg = new StartGame(); 
		sg.createCards(); 
		sg.shuffle(); 
		sg.addPlayer(); 
		sg.getCardsAndPlay();
		
	}
	
	
	public void createCards(){
		System.out.println("-----创建扑克牌-----");
		
		
		for(int i=0;i<4;i++){ 
			for(int j=2;j<11;j++){ 
			cardsList.add(new Card(type[i],j+"")); 
			} 
			cardsList.add(new Card(type[i],"J")); 
			cardsList.add(new Card(type[i],"Q")); 
			cardsList.add(new Card(type[i],"K")); 
			cardsList.add(new Card(type[i],"A")); 
		} 
		
		System.out.println("--------扑克牌创建成功！---------"); 
		
		for(Card card:cardsList){ 
			System.out.print(card.type+card.num+","); 
			}
		System.out.println();
	}
	
	
	public void shuffle(){ 
		System.out.println("----------开始洗牌----------"); 
		Random random = new Random(); 
		for(int i=0;i<52;i++){ 
			int a = random.nextInt(52); 
			Card carda = cardsList.get(a); 
			Card card0 = cardsList.get(0); 
			//Card temp = card0; 
			//card0 =carda; 
			//carda = temp; 
			cardsList.set(a, card0); 
			cardsList.set(0, carda); 
			} 
		System.out.println("----------洗牌完成----------"); 
	}
	
	public void addPlayer(){ 
		System.out.println("----------创建玩家----------"); 
		System.out.println("请输入第一位玩家的ID和姓名："); 
		int id = 0; 
		while(true){ 
			try{
				System.out.println("输入ID："); 
				id = input.nextInt(); 
				break; 
				}catch(Exception e){ 
					System.out.println("请输入一个整数类型的数字作为ID"); 
					input = new Scanner(System.in); //防止死循环！ 
					} 
			} 
		System.out.println("输入姓名："); 
		String name = input.next(); 
		Player A = new Player(id,name); 
		AA = A; 
		System.out.println("请输入第二位玩家的ID和姓名："); 
		int id2 = 0; 
		while(true){ 
			try{
				System.out.println("输入ID："); 
				id2 = input.nextInt(); 
				break; 
				}catch(Exception e){ 
					System.out.println("请输入一个整数类型的数字作为ID"); 
					input = new Scanner(System.in);//防止死循环！ 
					} 
			} 
		System.out.println("输入姓名："); 
		String name2 = input.next(); 
		Player B = new Player(id2,name2); 
		BB =B; 
		}
		
	
	
	public void getCardsAndPlay(){
		System.out.println("欢迎玩家："+AA.name); 
		System.out.println("欢迎玩家："+BB.name); 
		System.out.println("----------开始发牌----------"); 
		System.out.println("玩家："+AA.name+"拿牌"); 
		Card A1 = cardsList.get(0); 
		System.out.println("玩家："+BB.name+"拿牌"); 
		Card B1 = cardsList.get(1); 
		System.out.println("玩家："+AA.name+"拿牌"); 
		Card A2 = cardsList.get(2); 
		System.out.println("玩家："+BB.name+"拿牌"); 
		Card B2 = cardsList.get(3); 
		System.out.println("----------发牌结束----------"); 
		System.out.println("----------开始游戏----------"); 
		System.out.println("玩家："+AA.name+"的手牌为："+A1.type+A1.num+";"+A2.type+A2.num); 
		System.out.println("玩家："+BB.name+"的手牌为："+B1.type+B1.num+";"+B2.type+B2.num); 
		Card biggerA = new Card(); 
		Card biggerB = new Card(); 
		if(A1.compareTo(A2)>0){ 
			biggerA = A1; 
		}else{ 
			biggerA = A2; 
		} 
		
		if(B1.compareTo(B2)>0){ 
			biggerB = B1;
		}else{ 
			biggerB = B2; 
		} 
		
		if(biggerA.compareTo(biggerB)>0){ 
			System.out.println("获胜者为："+AA.name+"其最大手牌是："+biggerA.type+biggerA.num); 
		}else{ 
			System.out.println("获胜者为："+BB.name+"其最大手牌是："+biggerB.type+biggerB.num); 
		} 
		
	}
	
	
	

}
