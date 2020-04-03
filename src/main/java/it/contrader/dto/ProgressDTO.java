package it.contrader.dto;

public class ProgressDTO {

	private int id;
	private float cash;
	private double expectation;
	private double time;
	
	
	// costruttori
	public ProgressDTO(){
		
		
	}
    
	public ProgressDTO ( float cash,double expectation , double time) {
		this.cash= cash;
		this.expectation=expectation;
		this.time=time;
	}	
	
	public ProgressDTO (int id , float cash,double expectation , double time) {
		this.id=id;
		this.cash= cash;
		this.expectation=expectation;
		this.time=time;
		
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public float getCash() {
		return cash;
	}


	public void setCash(float cash) {
		this.cash = cash;
	}


	public double getExpectation() {
		return expectation;
	}


	public void setExpectation(double expectation) {
		this.expectation = expectation;
	}


	public double getTime() {
		return time;
	}


	public void setTime(double time) {
		this.time = time;
	}
    
	@Override
     public String toString() {
    	 return id + "\t" + cash +"\t\t"+ expectation + "\t\t"+ time;
    	 
     }
     
	
}
