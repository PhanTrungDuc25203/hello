package hust.soict.hedspi.aims.Aims;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hust.soict.hedspi.aims.cart.Cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
	private static final Scanner scanner = new Scanner(System.in);
	static Store store = new Store();
	static Cart cart = new Cart();
	public static void main(String[] args) {
		
		
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
		
		
		store.addMedia(dvdList);
		store.addMedia(bookList);
		store.addMedia(compactDiscList);
		
		store.print();
		
		
		
		int choice;
		do {
			showMenu();
			System.out.print("Your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character

			switch (choice) {
				case 1:
					viewStore();
					break;
				case 2:
					updateStore();
					break;
				case 3:
					seeCurrentCart();
					break;
				case 0:
					System.out.println("Exiting AIMS. Goodbye!");
					break;
				default:
					System.out.println("Invalid choice. Please choose again.");
			}
		} while (choice != 0);

		scanner.close();
	}

	private static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	private static void viewStore() {
		int choice;
		do {
			storeMenu();
			System.out.print("Your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character

			switch (choice) {
				case 1:
					seeMediaDetails();
					break;
				case 2:
					addMediaToCart();
					break;
				case 3:
					playMedia();
					break;
				case 4:
				cart.print();
					break;
				case 0:
					System.out.println("Returning to main menu.");
					break;
				default:
					System.out.println("Invalid choice. Please choose again.");
			}
		} while (choice != 0);
	}

	private static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}

	private static void seeMediaDetails() {
		System.out.print("Enter a Media's name: ");
		String mediaNameToSearch = scanner.nextLine();
		Media findMedia = store.searchForItemInStore(mediaNameToSearch);
		Store.mediaDetailsMenu();
		if (findMedia!=null){
			mediaDetailsMenu(findMedia);
		}
	}

	public static void mediaDetailsMenu(Media findMedia) {
		int choice;
		do{
			
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
				case 0:
					viewStore();
					break;
				case 1:
					cart.addMedia(findMedia);
					break;
				case 2:
					findMedia.play();
					break;
				default:
					System.out.println("Invalid choice. Please choose again.");
			}
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Add to cart");
			System.out.println("2. Play");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");
			System.out.print("Your choice: ");
		} while (choice != 0);
	}


	private static void addMediaToCart() {
		System.out.println("Enter title of the media: ");
		String title = scanner.nextLine();
		Media findMedia = store.searchForItemInStore(title);
		if (findMedia!=null){
			cart.addMedia(findMedia);
		}
	}

	private static void playMedia() {
		System.out.println("Enter title of the media: ");
		String title = scanner.nextLine();
		Media findMedia = store.searchForItemInStore(title);
		if (findMedia!=null){
			findMedia.play();
		}
	}

	private static void updateStore() {
		// Implement the logic to update store (add/remove media) here
		System.out.println("Enter meida's name: ");
		String mediaNameToSearch = scanner.nextLine();
		//scanner.nextLine();
		
		if(store.searchForItemInStore(mediaNameToSearch) != null) {
			System.out.println("Remove sucessfully!");
			store.removeMedia(store.searchForItemInStore(mediaNameToSearch));
		} else {
			System.out.println("New media to Store:");
			System.out.println("Title: " + mediaNameToSearch);
			
			System.out.println("ID      : ");
			int id = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Category: ");
			String category = scanner.nextLine();
			scanner.nextLine();
			System.out.println("Cost    : ");
			float cost = scanner.nextFloat();
			scanner.nextLine();
			System.out.println("Media's type: ");
			String mediaType = scanner.nextLine();
			scanner.nextLine();
			switch (mediaType) {
			case "DigitalVideoDisc":
			case "DVD":
			case "DVDs":
				System.out.println("Director: ");
				String director = scanner.nextLine(); scanner.nextLine();
				System.out.println("Length  : ");
				int length = scanner.nextInt();
				DigitalVideoDisc newDVD = new DigitalVideoDisc(id, mediaNameToSearch, category, cost, director, length);
				store.addMedia(newDVD);
				break;
			case "CompactDisc":
			case "CD":
			case "CDs":
				System.out.println("Artist: ");
				String artist = scanner.nextLine(); scanner.nextLine();
				
				
				System.out.print("Input track's quantity: ");
				int numberOfTrack = scanner.nextInt();
    			scanner.nextLine(); 
    			List<Track> newTrackList = new ArrayList<Track>();
    			for (int i = 0; i < numberOfTrack; i++) {
    			    System.out.println("Track " + (i + 1) + "'s details: ");
    			    System.out.print("Track's title: ");
    			    String trackTitle = scanner.nextLine();
    			    scanner.nextLine(); // Đọc dòng trống để tiêu hao dấu xuống dòng
    			    System.out.print("Track's length: ");
    			    int trackLength = scanner.nextInt();		        
    			    scanner.nextLine();
    			    newTrackList.add(new Track(trackTitle,trackLength));
    			}
			    
			    CompactDisc newCD = new CompactDisc(id, mediaNameToSearch, category, cost, artist, newTrackList);
			    store.addMedia(newCD);
				break;
			case "Book":
			case "Books":
				System.out.print("Input author's numbre: ");
				int numberOfAuthor = scanner.nextInt();
    			scanner.nextLine();
    			List<String> newAuthorList = new ArrayList<String>();
    			for (int i = 0; i < numberOfAuthor; i++) {
    			    System.out.print("Author's title: ");
    			    String authorName = scanner.nextLine(); scanner.nextLine();
    			    newAuthorList.add(authorName);
    			}
    			
    			Book newBook = new Book(id, mediaNameToSearch, category, cost, newAuthorList );
    			store.addMedia(newBook);
				break;
			}
		}
	}

	private static void seeCurrentCart() {
		int choice;
		do {
			cartMenu();
			System.out.print("Your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character

			switch (choice) {
				case 1:
					// Implement filtering options
					break;
				case 2:
					// Implement sorting options
					System.out.println("Sort items by: ");
					String sortChoice = scanner.nextLine();
					if(sortChoice.equals("Cost")||sortChoice.equals("cost")) {
						cart.sortByCost();
						cart.print();
					}
					if(sortChoice.equals("Title")||sortChoice.equals("title")) {
						cart.sortByTitle();
						cart.print();
					}
					break;
				case 3:
					// Implement logic to remove media from cart
					System.out.print("Enter a Media's name: ");
					String mediaNameToSearch = scanner.nextLine();
					Media findMedia = store.searchForItemInStore(mediaNameToSearch);
					cart.removeMedia(findMedia);
					break;
				case 4:
					// Implement logic to play media from cart
					System.out.print("Enter a Media's name: ");
					String mediaNameToPlay = scanner.nextLine();
					cart.playMedia(store.searchForItemInStore(mediaNameToPlay));
					break;
				case 5:
					// Implement logic to place order
					cart.removeAllMediaInCart();
					cart.print();
					System.out.println("Order placed. Cart is now empty.");
					break;
				case 0:
					System.out.println("Returning to main menu.");
					break;
				default:
					System.out.println("Invalid choice. Please choose again.");
			}
		} while (choice != 0);
	}

	private static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter media in cart");
		System.out.println("2. Sort media in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}
}
