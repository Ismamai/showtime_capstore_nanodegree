package com.iblesa.util;

import com.iblesa.api.models.Embedded_;
import com.iblesa.api.models.Event;
import com.iblesa.api.models.Image;

import java.util.List;

public class EventExtractor {
    public static String getVenue(Event event) {
        Embedded_ embedded = event.getEmbedded();
        String result = null;
        if (embedded != null
                && embedded.getVenues() != null
                && embedded.getVenues().size() != 0) {
            result = embedded.getVenues().get(0).getName();
        }
        return result;
    }

    public static String getImage(Event event) {
        List<Image> images = event.getImages();
        String smaller_image = null;
        String ratio = "3_2";
        int min_size = Integer.MAX_VALUE;
        for (Image image : images) {
            if (ratio.equals(image.getRatio())) {
                if (image.getWidth() < min_size) {
                    min_size = image.getWidth();
                    smaller_image = image.getUrl();
                }
            }
        }
        return smaller_image;
    }

}
