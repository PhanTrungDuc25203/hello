package hust.soict.hedspi.test.store.StoreTest;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

public class StoreTest {
	public static void main(String args[]) {
		DigitalVideoDisc dvdList[] = {
				new DigitalVideoDisc(1004,"Lion King","Animation",59.95f,"Roger Allers",87),
				new DigitalVideoDisc(1005,"Alien Conquer","Science Fiction",222.95f,"George Lucas",78),
				new DigitalVideoDisc(1006,"Aladin","Animation",151.95f,"Group of makers",123),
				new DigitalVideoDisc(1007,"Cinderalla","Animation",20.13f,"Group of makers",200),
				new DigitalVideoDisc(1008,"Avenger: End game","Action",123.95f,"Group of makers",300),
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
	CompactDisc compactDiscList[] = {
			new CompactDisc(3001, "Alan Walker", "EDM", 142.90f, "Alan Walker", trackList1),
			new CompactDisc(3002, "Taylor Swift", "Pop", 230.23f, "Taylor Swift", trackList2),
			new CompactDisc(3003, "Golden Music", "Bolero", 14.00f, "Artist1", trackList3),
			new CompactDisc(3004, "NCS", "EDM", 320.0f, "Avicii", trackList4),
	};
		
		Store store = new Store();
		
		store.addMedia(dvdList);
		store.addMedia(bookList);
		store.addMedia(compactDiscList);
		store.print();
	}
}
