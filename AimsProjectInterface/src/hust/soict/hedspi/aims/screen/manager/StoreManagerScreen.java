package hust.soict.hedspi.aims.screen.manager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;
public class StoreManagerScreen extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Store store = new Store();
	Container cp = getContentPane();
	
	/**
	 * Create north area
	 */
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	/**
	 * create menuBar
	 */
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenuItem menuItem = new JMenuItem("View store");
		menuItem.addActionListener(new ViewStoreForDetail()); 
		menu.add(menuItem);
		
		JMenu smUpdateStore = new JMenu("Update Store");
		
		menu.add(smUpdateStore);
		
		JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	AddDVDScreen.main(null);
            }
        });
        
        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	AddBookScreen.main(null);
            }
        });
        
        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	AddCDScreen.main(null);
            }
        });
        
        smUpdateStore.add(addDVDItem);
        smUpdateStore.add(addBookItem);
        smUpdateStore.add(addCDItem);
        
        
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	/**
	 * create header
	 */
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		
		return header;
	}
	
	/**
	 * create center area
	 */
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 2, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for(int i = 0; i < store.getStoreQuantity(); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}	
		
		return center;
	}
	
	/**
	 * view store menuItem's action
	 */
	private class ViewStoreForDetail implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			getContentPane().removeAll();
			cp.add(createNorth(), BorderLayout.NORTH);
			JScrollPane scrollPane = new JScrollPane(createCenter());
			cp.add(scrollPane);
			cp.add(scrollPane, BorderLayout.CENTER);
			revalidate();
			repaint();
		}
	}
	
	/**
	 * create Screen
	 */
	public StoreManagerScreen(Store store) {
		StoreManagerScreen.store = store;
		
		
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		JScrollPane scrollPane = new JScrollPane(createCenter());
		cp.add(scrollPane);
		cp.add(scrollPane, BorderLayout.CENTER);
		
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/**
	 * launch the Screen
	 */
	public static void main(String[] args) {
		StoreManagerScreen.databaseInput();
		store.print();
		new StoreManagerScreen(store);
	}
	
	/**
	 * initialize the database
	 */
	private static void databaseInput() {
		DigitalVideoDisc dvdList[] = {
				new DigitalVideoDisc(1001,"Lion King","Animation",59.95f,"Roger Allers",311),
				new DigitalVideoDisc(1002,"Alien Conquer","Science Fiction",222.95f,"George Lucas",154),
				new DigitalVideoDisc(1003,"Aladin","Animation",151.95f,"Group of makers",183),
				new DigitalVideoDisc(1004,"Cinderalla","Animation",20.13f,"Stan Lee",135),
				new DigitalVideoDisc(1005,"Avenger: End game","Action",76.95f,"Stan Lee",254),
				new DigitalVideoDisc(1006,"Đại chiến Thái Bình Dương","Action",123.95f,"John Hankerson",143),
				new DigitalVideoDisc(1007,"Upin & Ipin","Action",12.95f,"Kenchana",186),
				new DigitalVideoDisc(1008,"Avenger: Infinity War","Action",166.95f,"Stan Lee",254),
				new DigitalVideoDisc(1009,"Avatar","Fantasy",432.95f,"Stan Lee",498),
				new DigitalVideoDisc(1010,"Avatar II","Fantasy",487.95f,"Stan Lee",687),
				new DigitalVideoDisc(1011,"Kẻ Ăn Hồn","Horor",32.95f,"Stan Lee",154),
		};
		
		
		
		List<String> authors1 = List.of("Nam Cao");
		List<String> authors2 = List.of("Dale Carnegie");
		List<String> authors3 = List.of("Jennifer Kahnweiler");
		List<String> authors4 = List.of("Nguyễn Hữu Đa");
		List<String> authors5 = List.of("Ban Hà Bằng", "Nguyễn Đức Nghĩa");
		Book bookList[] = {
				new Book(2001, "Vợ Nhặt", "Truyện ngắn", 10.00f, authors1),
				new Book(2002, "Đắc nhân tâm", "Tham khảo", 500.00f, authors2),
				new Book(2003, "Sức mạnh của sự thầm lặng", "Tham khảo", 900.00f, authors3),
				new Book(2004, "Thỏ và Rùa", "Dân gian", 6.00f, authors4),
				new Book(2005, "Lập trình C++", "Lập trình", 20.00f, authors5),
		};
		 List<Track> trackList1 = new ArrayList<Track>();
		 	trackList1.add(new Track("Alone", 100));
		 	trackList1.add(new Track("Alone II", 200));
		 	trackList1.add(new Track("Faded", 300));
		 	trackList1.add(new Track("Unity", 400));
		 	trackList1.add(new Track("i'm on my way", 500));
		 List<Track> trackList2 = new ArrayList<Track>();
			 trackList2.add(new Track("Lover", 100));
			 trackList2.add(new Track("Hello", 200));
		 List<Track> trackList3 = new ArrayList<Track>();
		 	trackList3.add(new Track("Tàu anh qua núi", 100));
		 	trackList3.add(new Track("Sầu tím điệp hồng", 200));
		 	trackList3.add(new Track("Hồng nhan", 300));
		 List<Track> trackList4 = new ArrayList<Track>();
		 	trackList4.add(new Track("Thunder", 100));
		 	trackList4.add(new Track("My Heart", 200));
		 	trackList4.add(new Track("Waiting for love", 300));
		 	trackList4.add(new Track("The night", 400));
		 List<Track> trackList5 = new ArrayList<Track>();
		 	trackList5.add(new Track("Yoruni Kakeru",120));
		 	trackList5.add(new Track("Sakura",130));
		 	trackList5.add(new Track("Anata ni deaete yokatta",100));
		 CompactDisc compactDiscList[] = {
				new CompactDisc(3001, "Alan Walker", "EDM", 142.90f, "Alan Walker", trackList1),
				new CompactDisc(3002, "Taylor Swift", "Pop", 230.23f, "Taylor Swift", trackList2),
				new CompactDisc(3003, "Golden Music", "Bolero", 14.00f, "Artist1", trackList3),
				new CompactDisc(3004, "NCS", "EDM", 320.0f, "Avicii", trackList4),
				new CompactDisc(3005, "Nhac Nhat hay nhat", "Pop", 321.654f, "Yoshikage", trackList5),
		};
		
		store.addMedia(dvdList);
		store.addMedia(bookList);
		store.addMedia(compactDiscList);
	}
	
}
