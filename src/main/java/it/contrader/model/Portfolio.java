package it.contrader.model;

public class Portfolio {

	private int id;

	private float totalmoney;

	private float revenue;

	private float outputs;

	public Portfolio() {
		
	}

	public Portfolio (float totalmoney, float revenue, float outputs) {
		this.totalmoney = totalmoney;
		this.revenue = revenue;
		this.outputs = outputs;
		
	}

	public Portfolio (int id, float totalmoney, float revenue, float outputs) {
		this.id = id;
		this.totalmoney = totalmoney;
		this.revenue = revenue;
		this.outputs = outputs;
		
	}
	/**
	 * Getter e Setter
	 */
	public int getId() {
		return this.id;
	}
	public void setId(int id)  {
		this.id = id;
	}

	public float getTotalmoney() {
		return this.totalmoney;
	}
	public void setTotalmoney(float totalmoney) {
		this.totalmoney = totalmoney;
	}

	public float getRevenue() {
		return this.revenue;
	}

	public void setRevenue(float revenue) {
		this.revenue = revenue;
	}
	public float getOutputs() {
		return this.outputs;
		
	}
	public void setOutputs(float outputs) {
		this.outputs = outputs;
	}

	public String toString() {
		return id + "\t" + totalmoney + "\t\t" + revenue + "\t\t" + outputs;
	}
	//metodo per il confronto degli oggetti
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Portfolio other = (Portfolio) obj;
		if (id != other.id)
			return false;
		if (totalmoney !=other.totalmoney) 
			return false;
		
		if (revenue != other.revenue) 
			return false;
		
		if (outputs != other.outputs) 
			return false;
		
	return true;
		
	}
}
