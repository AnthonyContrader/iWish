package it.contrader.model; // dove è inserito il package

public class Progress {   //  nome della classe

// definiamo gli attributi del progresso
	
	private int id; // rende privati gli attributi
	
	private double time; // tempo trascorso  da quando raccogli i soldi
	
	private double expectation; // previsione 
	
	private float cash; // soldi risparmiati fino ad ora

	// inseriamo i costruttori per costruire oggetti Progress
	// con diversi parametri 


	public Progress () {   // costruttore vuoto
		
	}
// costruttore a 3 variabili
    public Progress ( double time, double expectation,float cash) {
    	this.cash=cash;
    	this.time=time;
    	this.expectation=expectation;
    	
    }
// costruttore a 4 variabili 
    
    public Progress (int id, double time, double expectation,float cash) {
    	this.id=id;
    	this.time=time;
    	this.cash=cash;
    	this.expectation=expectation;
    	
    }
    
    // get e set
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTime() {
		return this.time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public float getCash() {
		return this.cash;
	}
	public void setCash(float cash) {
		this.cash = cash;
	}

	public double getExpectation() {
		return this.expectation;
	}
	public void setExpectation(double expectation) {
		this.expectation = expectation;
	}
    
	
	//Trasforma un oggetto in una stringa
		@Override
		public String toString() {
			return  id + "\t"  + cash +"\t\t" +   expectation + "\t\t" + time;
		}
   // metodo per il confronto degli oggetti
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass()!=obj.getClass())
			return false;
		Progress other = (Progress) obj; //???????????
		if(id!=other.id)
			return false;
		if (cash!=other.cash)
			return false;
		if(time!=other.time)
			return false;
		if (expectation	!= other.expectation)
			return false;
		
	
		return true;
	
	}

}
	
    
	



