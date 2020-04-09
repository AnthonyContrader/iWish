package it.contrader.model;

public class Progress {


 // attributi della classe
	
	private int id;
	
    private float cash;
    
    private double time;
    
    private double expectation;
    
    private int Foreign_prodotto;
    
    private String Foreign_proprietario;

    
    



   // costruttori 

public Progress() {
	
}


public Progress(float cash, double expectation, double time) {
	
	this.setCash(cash);
	this.setExpectation(expectation);
	this.setTime(time);
	
}

public Progress(float cash, double expectation, double time, int Foreign_prodotto ,String Foreign_proprietario) {
	this.setId(id);
	this.setCash(cash);
	this.setExpectation(expectation);
	this.setTime(time);
	this.setForeign_prodotto(Foreign_prodotto);
	this.setForeign_proprietario(Foreign_proprietario);
}

public Progress(int id,float cash, double expectation, double time, int Foreign_prodotto,String Foreign_proprietario ) {
	this.setId(id);
	this.setCash(cash);
	this.setExpectation(expectation);
	this.setTime(time);
	this.setForeign_prodotto(Foreign_prodotto);
	this.setForeign_proprietario(Foreign_proprietario);
}

public Progress(int id, float cash, double expectation, double time) {
	this.setId(id);
	this.setCash(cash);
	this.setExpectation(expectation);
	this.setTime(time);
	
}




// getter e setter


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

public String getForeign_proprietario() {
	return this.Foreign_proprietario;
}

public void setForeign_proprietario(String Foreign_proprietario) {
	this.Foreign_proprietario = Foreign_proprietario;
}

@Override
public String toString() {
	return id+"\t"+ cash+"\t\t"+ expectation +"\t\t"+time+"\t"+Foreign_proprietario+"\t"+Foreign_prodotto;
}





@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Progress other = (Progress) obj;
	if (Foreign_prodotto != other.Foreign_prodotto)
		return false;
	if (Foreign_proprietario == null) {
		if (other.Foreign_proprietario != null)
			return false;
	} else if (!Foreign_proprietario.equals(other.Foreign_proprietario))
		return false;
	if (Float.floatToIntBits(cash) != Float.floatToIntBits(other.cash))
		return false;
	if (Double.doubleToLongBits(expectation) != Double.doubleToLongBits(other.expectation))
		return false;
	if (id != other.id)
		return false;
	if (Double.doubleToLongBits(time) != Double.doubleToLongBits(other.time))
		return false;
	return true;
}







}