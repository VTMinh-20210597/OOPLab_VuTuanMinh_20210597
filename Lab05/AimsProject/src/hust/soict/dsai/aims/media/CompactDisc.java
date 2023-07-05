package hust.soict.dsai.aims.media;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.*;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable
{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	private int DiscLength;
	private static int nbCompactDisc = 0;	
	

	public CompactDisc(String title, String category, String artist, float cost) 
	{
		this.title = title;
		this.category = category;
		this.artist = artist;
		this.cost = cost;
		++nbCompactDisc;
		this.id = "CP"  + Integer.toString(nbCompactDisc);
	}



	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track track_name)
	{
		if(tracks.contains(track_name))
		{
			System.out.println("This track already exists");
			return;
		}
		
		tracks.add(track_name);
		System.out.println("This track has been added");
	}
	
	public void removeTrack(Track track_name)
	{
		if(!tracks.contains(track_name))
		{
			System.out.println("This track doesn't exist");
			return;
		}
		
		tracks.remove(track_name);
		return;
	}
	
	public int getLength()
	{
		for(int i = 0; i < tracks.size(); ++i)
		{
			Track track_i = tracks.get(i);
			DiscLength += track_i.getLength();
			
		}
		
		return DiscLength;
	}
	
	public void play() throws PlayerException 
	{
		if (this.getLength() <= 0) 
		{
			throw new PlayerException("ERROR: CD length is non-positive!");
		} 
		else 
		{
			System.out.println("Playing CD: " + this.getTitle());
			
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			JPanel p = new JPanel();
			JDialog d = new JDialog();
			JLabel l1 = new JLabel("Now playing: " + this.getTitle());
			p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
			l1.setAlignmentX(Component.CENTER_ALIGNMENT);
			d.setTitle("Media Player");
			p.add(Box.createVerticalGlue());
			p.add(l1);
			p.add(Box.createVerticalGlue());
			d.add(p);
			d.setSize(250,100);
			int w = d.getSize().width;
	        int h = d.getSize().height;
	        int x = (dim.width - w) / 2;
	        int y = (dim.height - h) / 2;
			d.setLocation(x, y);
			d.setVisible(true);
			
			for (Track track: this.tracks) 
			{
				try 
				{
					track.play();
				} catch (PlayerException e) 
				{
					throw e;
				}
			}
		}
	}



	@Override
	public String toString() {
		return "CompactDisc [artist=" + artist + ", tracks=" + tracks + ", DiscLength=" + DiscLength + ", length="
				+ length + ", director=" + director + ", id=" + id + ", title=" + title + ", category=" + category
				+ ", cost=" + cost + "]";
	}
	
	

}
