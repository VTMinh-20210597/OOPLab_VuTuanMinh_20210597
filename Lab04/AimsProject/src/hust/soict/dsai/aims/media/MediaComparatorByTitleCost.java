package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media>{
	@Override
	public int compare(Media m1, Media m2) {
		if (m1.getTitle().compareTo(m2.getTitle()) > 0) {
			return 1;
		} else if (m1.getTitle().compareTo(m2.getTitle()) < 0) {
			return -1;
		} 
		return Double.compare(m1.getCost(), m2.getCost());
	}
}
