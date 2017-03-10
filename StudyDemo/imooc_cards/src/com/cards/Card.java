package com.cards;

public class Card implements Comparable<Card> {

	String type;
	String num;
	
	
	
	public Card() {
		super();
	}



	public Card(String type, String num) {
		super();
		this.type = type;
		this.num = num;
	}



	@Override
	public int compareTo(Card o) {
		// TODO Auto-generated method stub
		if(this.num!=o.num&&this.num!="A"&&o.num!="A") 
			return this.num.compareTo(o.num); 
		if(this.num.toCharArray()[0]=='A'&&o.num.toCharArray()[0]!='A') 
			return 1; 
		if(this.num.toCharArray()[0]!='A'&&o.num.toCharArray()[0]=='A') 
			return -1; 
		if(this.num==o.num){ 
			//我不知道怎么判断花型的大小，但是程序运行结果显示大小顺序没有错：方块<梅花<红桃<黑桃 
			return this.type.compareTo(o.type); 
		} 
		
		return 0; 
		
			
	}

}
