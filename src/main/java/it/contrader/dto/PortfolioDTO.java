package it.contrader.dto;

public class PortfolioDTO {
	
	private int id;

	private Float totalmoney;
	
	private Float revenue;
	
	private Float outputs;
	
	public PortfolioDTO() {

}
	public PortfolioDTO (Float totalmoney, Float revenue, Float outputs) {
		this.totalmoney = totalmoney;
		this.revenue = revenue;
		this.outputs = outputs;
	}

	public PortfolioDTO (int id, float totalmoney, float revenue, float outputs) {
		this.id = id;
		this.totalmoney = totalmoney;
		this.revenue = revenue;
		this.outputs = outputs;
	}
	public int getId() {
		return this.id;
}

	public void setId(int id) {
		this.id = id;
	}
	
	public Float getOutputs() {
		return this.outputs;
	}

	public void setOutputs(Float outputs) {
		this.outputs = outputs;
	}

    public Float getRevenue() {
		return this.revenue;
	}

	public void setRevenue(Float revenue) {
		this.revenue = revenue;
		
	}
		public void setTotalmoney(Float totalmoney) {
			this.totalmoney = totalmoney;
		}

		public Float getTotalmoney() {
			return totalmoney;
		}
		
@Override
public String toString() {
	return  id + "\t"  + totalmoney +"\t\t" +   revenue + "\t\t" + outputs;
}
}
