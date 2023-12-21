package hust.soict.hedspi.test.cart.CartTest;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.cart.Cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;


public class CartTest {
	public static void main(String args[]) {
		Cart cart = new Cart();
		
		
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1001,"Lion King","Animation",19.95f,"Roger Allers",87);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(1002,"Star Wars","Science Fiction",24.95f,"George Lucas",78);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc(1003,"Aladin","Animation",54.95f,"Group of makers",123);		
		DigitalVideoDisc dvdList[] = {
				new DigitalVideoDisc(1004,"Lion King","Animation",59.95f,"Roger Allers",87),
				new DigitalVideoDisc(1005,"Alien Conquer","Science Fiction",222.95f,"George Lucas",78),
				new DigitalVideoDisc(1006,"Aladin","Animation",151.95f,"Group of makers",123),
				new DigitalVideoDisc(1007,"Cinderalla","Animation",20.13f,"Group of makers",200),
				new DigitalVideoDisc(1008,"Avenger: End game","Action",123.95f,"Group of makers",300),
		};
		
		
		
		List<String> authors1 = new ArrayList<>(List.of("Nam Cao"));
        List<String> authors2 = new ArrayList<>(List.of("Dale Carnegie"));
        List<String> authors3 = new ArrayList<>(List.of("Jennifer Kahnweiler"));
        List<String> authors4 = new ArrayList<>(List.of("Nguyễn Hữu Đa"));
        List<String> authors5 = new ArrayList<>(List.of("Ban Hà Bằng", "Nguyễn Đức Nghĩa"));
		Book bookList[] = {
				new Book(2001, "Vợ Nhặt", "Truyện ngắn", 10.00f, authors1),
				new Book(2002, "Đắc nhân tâm", "Tham khảo", 500.00f, authors2),
				new Book(2003, "Sức mạnh của sự thầm lặng", "Tham khảo", 900.00f, authors3),
				new Book(2004, "Thỏ và Rùa", "Dân gian", 6.00f, authors4),
				new Book(2005, "Lập trình C++", "Lập trình", 20.00f, authors5),
		};
		bookList[0].addAuthor("Hello");
		bookList[1].addAuthor("Dale Carnegie");
		bookList[2].addAuthor("Jennifer Kahnweiler");
//		bookList[3].addAuthor("Nguyễn Hữu Đa");
//		bookList[4].addAuthor("Ban Hà Bằng");
//		bookList[4].addAuthor("Nguyễn Đức Nghĩa");
//		bookList[4].addAuthor("Trương Thị Diệu Linh");
		
		
		
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
		 	trackList3.add(new Track("Tím điệp hồng", 200));
		 	trackList3.add(new Track("Hồng nhan", 300));
		 List<Track> trackList4 = new ArrayList<Track>();
		 	trackList4.add(new Track("Thunder", 100));
		 	trackList4.add(new Track("My Heart", 200));
		 	trackList4.add(new Track("Waiting for love", 300));
		 	trackList4.add(new Track("The night", 400));
		CompactDisc compactDiscList[] = {
				new CompactDisc(3001, "Alan Walker", "EDM", 142.90f, "Alan Walker", trackList1),
				new CompactDisc(3002, "Taylor Swift", "Pop", 230.23f, "Taylor Swift", trackList2),
				new CompactDisc(3003, "Golden Music", "Bolero", 14.00f, "Artist1", trackList3),
				new CompactDisc(3004, "NCS", "EDM", 320.0f, "Avicii", trackList4),
		};
		//compactDiscList[0].addTrack("Monster");
		
		

		cart.addMedia(dvd1);
		cart.addMedia(dvd2);
		cart.addMedia(dvd3);
		cart.addMedia(dvdList);
		cart.addMedia(bookList);
		cart.addMedia(compactDiscList);
		
		
		
		cart.print();
		System.out.println("Total cost:" + cart.totalCost());
		
		
		
		cart.sortByTitle();
		cart.print();
		cart.sortByCost();
		cart.print();
		System.out.println("Aladins: " + cart.search("Aladins"));
		System.out.println("Star Wars: " + cart.search("Star Wars"));
		System.out.println("Lập trình C++: " + cart.search("Lập trình C++"));		
		
		dvdList[0].play();
		System.out.println();
		compactDiscList[3].play();
		System.out.println();
		cart.playMedia(bookList[2]);		
	}
}
