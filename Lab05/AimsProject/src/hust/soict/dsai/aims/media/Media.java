package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media 
{

	protected String id;
	protected String title;
	protected String category;
	protected float cost;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	public Media() 
	{
		
	}
	


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public float getCost() {
		return cost;
	}


	public void setCost(float cost) {
		this.cost = cost;
	}
	
	@Override
	public boolean equals(Object media_i) 
	{
		if (media_i instanceof Media) 
		{
			try 
			{
				Media that = (Media) media_i;
				return this.title.toLowerCase().equals(that.getTitle().toLowerCase());
			} 
			catch (NullPointerException e1) 
			{
				return false;
			} 
			catch (ClassCastException e2) {
				return false;
			}
		} else 
		{
			return false;
		}
	}



	public abstract String getDetails();

	
}
