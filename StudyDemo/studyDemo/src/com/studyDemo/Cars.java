package com.studyDemo;

public  class Cars {
	public int id;
	public String name;
	public float price;
	public float carryingCapacity;
	public int carryingSeat;
	
	
	@Override
	public String toString() {
		if(carryingCapacity==0){
			return(id+ "\t" + name + "\t" + price + "元/天\t载客" + carryingSeat +"位");
		}else if(carryingSeat == 0){
			return(id+ "\t" + name + "\t" + price + "元/天\t载货" + carryingCapacity +"吨");
		}else{
			return(id+ "\t" + name + "\t" + price + "元/天\t载货" + carryingSeat +"位" + carryingCapacity +"吨");
		}
		
	}
		
	

}
