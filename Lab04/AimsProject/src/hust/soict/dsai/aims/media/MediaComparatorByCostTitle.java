package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
	@Override
	public int compare(Media m1, Media m2) {
		int compareCost = Double.compare(m1.getCost(), m2.getCost());
	if (compareCost == 0) {
		if (m1.getTitle().compareTo(m2.getTitle()) < 0) {
			return -2;
		} else if (m1.getTitle().compareTo(m2.getTitle()) > 0){
			return 1;
		} else {
			return 0;
		}
	} else {
		return Double.compare(m1.getCost(), m2.getCost());
	}
	}
}
