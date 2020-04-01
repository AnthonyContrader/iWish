package it.contrader.dto;

import java.sql.Date;


public class CategoryDTO {
	
		private int id;
		private String name;		
		private String description;		
		private Date date;		
		private int rating;		
		private String tags;
		
		
		public CategoryDTO() {
			
		}		

		public CategoryDTO (String name, String description, Date date, int rating, String tags) {
			this.name = name;
			this.description = description;
			this.date = date;
			this.rating = rating;
			this.tags = tags;
		}

		public CategoryDTO (int id, String name, String description, Date date, int rating, String tags) {
			this.id = id;
			this.name = name;
			this.description = description;
			this.date = date;
			this.rating = rating;
			this.tags = tags;
		}
		
		public int getId() {
			return this.id;
		}
		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}


		public String getDescription() {
			return this.description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
		
		public Date getDate() {
			return this.date;
		}
		
		public void setDate_create(Date date) {
			this.date = date;
		}
		
		public int getRating() {
			return this.rating;
		}
		
		public void setRating(int rating) {
			this.rating = rating;
		}
		
		public void setTags(String tags) {
			this.tags = tags;
		}

		public String getTags() {
			return tags;
		}

		@Override
		public String toString() {
			return  id + "\t"  + name +"\t\t" +  description + "\t\t" + date + "\t\t" + rating + "\t\t" + tags;
		}


}
