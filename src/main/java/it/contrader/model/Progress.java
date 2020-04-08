package it.contrader.model;

public class Progress {


 // attributi della classe
	
	private int id;
	
    private float cash;
    
    private double time;
    
    private double expectation;
    
    private int Foreing_prodotto;
    
    private String Foreing_proprietario;

    
    



   // costruttori 

public Progress() {
	
}


public Progress(float cash, double expectation, double time) {
	
	this.setCash(cash);
	this.setExpectation(expectation);
	this.setTime(time);
	
}

public Progress(float cash, double expectation, double time,String Foreing_proprietario, int Foreing_prodotto ) {
	this.setId(id);
	this.setCash(cash);
	this.setExpectation(expectation);
	this.setTime(time);
	this.setForeing_prodotto(Foreing_prodotto);
	this.setForeing_proprietario(Foreing_proprietario);
}

public Progress(int id,float cash, double expectation, double time,String Foreing_proprietario, int Foreing_prodotto ) {
	this.setId(id);
	this.setCash(cash);
	this.setExpectation(expectation);
	this.setTime(time);
	this.setForeing_prodotto(Foreing_prodotto);
	this.setForeing_proprietario(Foreing_proprietario);
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

public int getForeing_prodotto() {
	return this.Foreing_prodotto;
}

public void setForeing_prodotto(int Foreing_prodotto) {
	this.Foreing_prodotto = Foreing_prodotto;
}

public String getForeing_proprietario() {
	return this.Foreing_proprietario;
}

public void setForeing_proprietario(String Foreing_proprietario) {
	this.Foreing_proprietario = Foreing_proprietario;
}

@Override
public String toString() {
	return id+"\t"+ cash+"\t\t"+ expectation +"\t\t"+time+"\t"+Foreing_proprietario+"\t"+Foreing_prodotto;
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
	if (Foreing_prodotto != other.Foreing_prodotto)
		return false;
	if (Foreing_proprietario == null) {
		if (other.Foreing_proprietario != null)
			return false;
	} else if (!Foreing_proprietario.equals(other.Foreing_proprietario))
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