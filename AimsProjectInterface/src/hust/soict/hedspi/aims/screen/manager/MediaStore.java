package hust.soict.hedspi.aims.screen.manager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;


public class MediaStore extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Media media;
	public MediaStore(Media media) {
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + media.getCost() + " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		if(media instanceof Playable) {
			JButton playButton = new JButton("Play");
			JButton detailButton = new JButton("Details");
			playButton.addActionListener(new playChosenMedia());
			detailButton.addActionListener(new seeMediaDetail());
			container.add(playButton);
			container.add(detailButton);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	private class playChosenMedia implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			media.playDialog();
		}
	}
	
	private class seeMediaDetail implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			
		}
	}
}
