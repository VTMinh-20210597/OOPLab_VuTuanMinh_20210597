package hust.soict.dsai.aims.media;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable
{
	private static int nbDigitalVideoDiscs = 0;	
	
	public DigitalVideoDisc(String title) {
		this.title = title;
		++ nbDigitalVideoDiscs;
		this.id = "DVD" + Integer.toString(nbDigitalVideoDiscs);
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		++ nbDigitalVideoDiscs;
		this.id = "DVD" + Integer.toString(nbDigitalVideoDiscs);
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		++ nbDigitalVideoDiscs;
		this.id = "DVD" + Integer.toString(nbDigitalVideoDiscs);
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		++ nbDigitalVideoDiscs;
		this.id = "DVD" + Integer.toString(nbDigitalVideoDiscs);
	}
	
	public boolean isMatchTitle(String title)
	{
		if(this.title == title) return true;
		
		return false;
	}
	
	public boolean isMatchId(String id)
	{
		if(this.id.equals(id)) return true;
		
		return false;
		
	}
	
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	public void play() throws PlayerException 
	{
		if (this.getLength() <= 0) 
		{
			throw new PlayerException("ERROR: DVD length is non-positive!");
		} 
		else 
		{
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
			
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			JPanel p = new JPanel();
			JDialog d = new JDialog();
			JLabel l1 = new JLabel("Now playing: " + this.getTitle());
			JLabel l2 = new JLabel("DVD length: " + this.getLength());
			p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
			l1.setAlignmentX(Component.CENTER_ALIGNMENT);
			l2.setAlignmentX(Component.CENTER_ALIGNMENT);
			d.setTitle("Media Player");
			p.add(Box.createVerticalGlue());
			p.add(l1);
			p.add(l2);
			p.add(Box.createVerticalGlue());
			d.add(p);
			d.setSize(250,100);
			int w = d.getSize().width;
	        int h = d.getSize().height;
	        int x = (dim.width - w) / 2;
	        int y = (dim.height - h) / 2;
			d.setLocation(x, y);
			d.setVisible(true);
		}
	}
	
	@Override
	public String toString() {
		return "DigitalVideoDisc [length=" + length + ", director=" + director + ", id=" + id + ", title=" + title
				+ ", category=" + category + ", cost=" + cost + "]";
	}
	
	
	
}
