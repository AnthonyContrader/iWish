package it.contrader.model;

public class Progress {


 // attributi della classe
	
	private int id;
	
    private float cash;
    
    private double time;
    
    private double expectation;
    
    private String Foreing_prodotto;

    



   // costruttori 

public Progress() {
	
}


public Progress(float cash, double expectation, double time) {
	
	this.setCash(cash);
	this.setExpectation(expectation);
	this.setTime(time);
	
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

public String getForeing_prodotto() {
	return this.Foreing_prodotto;
}

public void setForeing_prodotto(String Foreing_prodotto) {
	this.Foreing_prodotto = Foreing_prodotto;
}



@Override
public String toString() {
	return id+"\t"+ cash+"\t\t"+ expectation +"\t\t"+time;
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
	if (Foreing_prodotto == null) {
		if (other.Foreing_prodotto != null)
			return false;
	} else if (!Foreing_prodotto.equals(other.Foreing_prodotto))
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