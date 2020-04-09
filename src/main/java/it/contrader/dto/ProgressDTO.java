package it.contrader.dto;

public class ProgressDTO {


private int id;
	
    private float cash;
    
    private double time;
    
    private double expectation;
    
    private int Foreign_prodotto;
    
    private String Foreign_proprietario;
     
    public ProgressDTO() {
    	
    }
    
    public ProgressDTO(float cash, double expectation, double time) {
    	this.cash=cash;
    	this.expectation=expectation;
    	this.time=time;
    	
    }
    public ProgressDTO(int id,float cash, double expectation, double time) {
    	this.cash=cash;
    	this.expectation=expectation;
    	this.time=time;
    	this.id=id;
    }

    
    public ProgressDTO(float cash, double expectation, double time,int Foreign_prodotto,String Foreign_proprietario) {
    	this.cash=cash;
    	this.expectation=expectation;
    	this.time=time;
    	this.Foreign_prodotto=Foreign_prodotto;
    	this.Foreign_proprietario= Foreign_proprietario;
    }
    
    
    public ProgressDTO(int id,float cash, double expectation, double time,int Foreign_prodotto,String Foreign_proprietario) {
    	this.id=id;
    	this.cash=cash;
    	this.expectation=expectation;
    	this.time=time;
    	this.Foreign_prodotto=Foreign_prodotto;
    	this.Foreign_proprietario=Foreign_proprietario;
    }
    
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getCash() {
		return this.cash;
	}

	public void setCash(float cash) {
		this.cash = cash;
	}

	public double getTime() {
		return this.time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public double getExpectation() {
		return this.expectation;
	}

	public void setExpectation(double expectation) {
		this.expectation = expectation;
	}

	public int getForeign_prodotto() {
		return this.Foreign_prodotto;
	}

	public void setForeign_prodotto(int Foreign_prodotto) {
		this.Foreign_prodotto = Foreign_prodotto;
	}
	@Override
	public String toString() {
		return  id + "\t"  + cash +"\t\t" +   expectation + "\t\t" + time+ "\t"+Foreign_proprietario+ "\t"+Foreign_prodotto; 
    }

	public String getForeign_proprietario() {
		return Foreign_proprietario;
	}

	public void setForeign_proprietario(String Foreing_proprietario) {
		this.Foreign_proprietario = Foreing_proprietario;
	}
}
