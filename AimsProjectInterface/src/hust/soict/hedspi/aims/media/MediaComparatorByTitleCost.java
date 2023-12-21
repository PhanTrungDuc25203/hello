package hust.soict.hedspi.aims.media;
import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media media1, Media media2) {
        //Ưu tiên sắp xếp theo title, nếu title giống nhau thì xếp theo cost
        int titleComparison = media1.getTitle().compareTo(media2.getTitle());


        if (titleComparison == 0) {
            return Double.compare(media2.getCost(), media1.getCost());
        }

        return titleComparison;
    }
}