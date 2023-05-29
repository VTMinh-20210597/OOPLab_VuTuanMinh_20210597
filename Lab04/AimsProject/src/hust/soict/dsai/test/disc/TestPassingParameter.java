package hust.soict.dsai.test.disc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter 
{

	public static void main(String[] args) 
	{
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDVD, cinderellaDVD);
		
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
	}
	
	public static void swap(Object o1, Object o2)
	{
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title)
	{
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}

	public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) 
	{
	    int temp_Id = dvd1.getId();
	    String temp_Title = dvd1.getTitle();
	    String temp_Category = dvd1.getCategory();
	    String temp_Director = dvd1.getDirector();
	    int temp_Length = dvd1.getLength();
	    float temp_Cost = dvd1.getCost();
	    
	    dvd1.setId(dvd2.getId());
	    dvd1.setTitle(dvd2.getTitle());
	    dvd1.setCategory(dvd2.getCategory());
	    dvd1.setDirector(dvd2.getDirector());
	    dvd1.setLength(dvd2.getLength());
	    dvd1.setCost(dvd2.getCost());
	    
	    dvd2.setTitle(temp_Title);
	    dvd2.setId(temp_Id);
	    dvd2.setCategory(temp_Category);
	    dvd2.setDirector(temp_Director);
	    dvd2.setLength(temp_Length);
	    dvd2.setCost(temp_Cost);
	}

	
}
