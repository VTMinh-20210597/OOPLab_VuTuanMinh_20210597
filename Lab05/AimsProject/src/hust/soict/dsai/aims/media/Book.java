package hust.soict.dsai.aims.media;

import java.util.ArrayList;

import hust.soict.dsai.aims.exception.NonExistingItemException;

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

	public ArrayList<String> getAuthors() 
	{
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
	
	public void removeAuthor(String authorName) throws NonExistingItemException 
	{
		for (String name: this.authors) 
		{
			if (name.toLowerCase().equals(authorName.toLowerCase())) 
			{
				this.authors.remove(name);
				System.out.println(name + " has been removed from the " + this.getTitle() + " list of authors.");
				return;
			}
		}
		throw new NonExistingItemException(authorName + " is not in the list of authors.");
	}

	@Override
	public String getDetails() 
	{
		StringBuffer authorsList = new StringBuffer();
		if (this.authors.size() >= 1) 
		{
			authorsList.append(this.authors.get(0));
			for (int i = 1; i < this.authors.size(); i++) 
			{
				authorsList.append(", " + this.authors.get(i));
			}
		}
		return "Book [authors=" + authorsList + ", id=" + id + ", title=" + title + ", category=" + category + ", cost="
				+ cost + "]";
	}

}
