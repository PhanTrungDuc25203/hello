package hust.soict.hedspi.aims.media;

import java.util.Comparator;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	public int getId() {
		return id;
	}
	
	public String getIdInString() {
		return id+"";
	}
	
	public void setId(int id) {
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
	
	public Media(int id, String title, String category, float cost) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	
	
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    
	@Override
	public String toString() {
		return "Media [id=" + id + ", title=" + title + ", category=" + category + ", cost=" + cost + "]";
	}

	public void play() {
		// TODO Auto-generated method stub
		
	}

	public void playDialog() {
			
	}
}
