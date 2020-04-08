package it.contrader.dto;

public class ProgressDTO {


private int id;
	
    private float cash;
    
    private double time;
    
    private double expectation;
    
    private int Foreing_prodotto;
    
    private String Foreing_proprietario;
     
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

    
    public ProgressDTO(float cash, double expectation, double time,String Foreing_proprietario,int Foreing_prodotto) {
    	this.cash=cash;
    	this.expectation=expectation;
    	this.time=time;
    	this.Foreing_prodotto=Foreing_prodotto;
    	this.setForeing_proprietario(Foreing_proprietario);
    }
    
    
    public ProgressDTO(int id,float cash, double expectation, double time,String Foreing_proprietario,int Foreing_prodotto) {
    	this.id=id;
    	this.cash=cash;
    	this.expectation=expectation;
    	this.time=time;
    	this.Foreing_prodotto=Foreing_prodotto;
    	this.setForeing_proprietario(Foreing_proprietario);
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

	public int getForeing_prodotto() {
		return this.Foreing_prodotto;
	}

	public void setForeing_prodotto(int Foreing_prodotto) {
		this.Foreing_prodotto = Foreing_prodotto;
	}
	@Override
	public String toString() {
		return  id + "\t"  + cash +"\t\t" +   expectation + "\t\t" + time+ "\t"+Foreing_proprietario+ "\t"+Foreing_prodotto; 
    }

	public String getForeing_proprietario() {
		return Foreing_proprietario;
	}

	public void setForeing_proprietario(String foreing_proprietario) {
		Foreing_proprietario = foreing_proprietario;
	}
}
