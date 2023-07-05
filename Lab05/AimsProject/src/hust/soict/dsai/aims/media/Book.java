package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class Book extends Media
{
	private ArrayList<String> authors = new ArrayList<String>();
	private static int nbBook = 0;	

	
	public Book(String title, String category, float cost)
	{
		this.title = title;
		this.category = category;
		this.cost = cost;
		
		++nbBook;
		this.id = "B"  + Integer.toString(nbBook);
	}
	
	public Book(String title, String category, float cost, ArrayList<String> authors) 
	{
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.authors = authors;
		++nbBook;
		this.id = "B"  + Integer.toString(nbBook);
	}

	public ArrayList<String> getAuthors() {
	return authors;}

	public void setAuthors(ArrayList<String> authors) 
	{
	this.authors = authors;
	}
	
	public void addAuthor(String authorName)
	{
		if(authors.contains(authorName))
		{
			System.out.println("This author already exist");
			return;
		}
		
		authors.add(authorName);
		
		System.out.println("This author has been added");
	}
	
	public void removeAuthor(String authorName)
	{
		if(!authors.contains(authorName))
		{
			System.out.println("This author doesn't exist");
			return;
		}
		
		authors.remove(authorName);
		System.out.println("This author has been deleted");
		
		return;
	}

	@Override
	public String toString() {
		return "Book [authors=" + authors + ", id=" + id + ", title=" + title + ", category=" + category + ", cost="
				+ cost + "]";
	}
}
