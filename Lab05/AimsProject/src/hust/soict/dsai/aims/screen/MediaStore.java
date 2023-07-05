package hust.soict.dsai.aims.screen;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton.*;
import javax.swing.JDialog;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;

public class MediaStore extends JPanel 
{
	private Media media;
	public Cart cart;
	
	public MediaStore(Media media, Cart cart)
	{
		this.media = media;
		this.cart = cart;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		
		JLabel cost = new JLabel("" + media.getCost() + " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton addToCart = new JButton("Add to Cart");
		container.add(addToCart);
		addToCart.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						CartAdding(cart);	
					}
			
				});
		
		JButton playMedia = new JButton("Play");
		
		if(media instanceof Playable)
		{
			
			container.add(playMedia);
			playMedia.addActionListener(new ActionListener()
					{
						@Override
						public void actionPerformed(ActionEvent e) 
						{
							playMedia();
						}
				
					});
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
	}
	
	public void CartAdding(Cart cart) 
	{
		cart.addMedia(media);
        JOptionPane.showMessageDialog(this, "Media added to cart!", "Add to Cart", JOptionPane.INFORMATION_MESSAGE);
        
	}

	JDialog playMedia() {
		JDialog Play = new JDialog();
		Play.setTitle("Play Media");
		Play.add(new JLabel("This media is playing..."));
		Play.setVisible(true);
		return Play;
		
	}
	
	
}
