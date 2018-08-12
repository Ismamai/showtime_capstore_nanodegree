package com.iblesa.util;

import com.iblesa.api.data.EventData;
import com.iblesa.api.models.Classification;
import com.iblesa.api.models.Dates;
import com.iblesa.api.models.Embedded_;
import com.iblesa.api.models.Event;
import com.iblesa.api.models.Image;
import com.iblesa.api.models.Location;
import com.iblesa.api.models.Start;
import com.iblesa.api.models.Venue_;

import java.util.List;

public class EventExtractor {
    public static Venue_ getVenue(Event event) {
        Embedded_ embedded = event.getEmbedded();
        Venue_ result = null;
        if (embedded != null
                && embedded.getVenues() != null
                && embedded.getVenues().size() != 0) {
            result = embedded.getVenues().get(0);
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

    public static Start getDate(Event event) {
        Start resultDate = null;
        if (event.getDates() != null) {
            Dates dates = event.getDates();
            if (dates.getStart() != null) {
                resultDate = dates.getStart();
            }
        }
        return resultDate;
    }

    public static EventData extractEventData(Event event) {
        String id = event.getId();
        String name = event.getName();
        Start start = getDate(event);

        String date = null;
        String time = null;
        String venue = null;
        String venue_lat = null;
        String venue_long = null;
        String genre = null;
        String subGenre = null;
        String segment = null;
        String image;

        if (start != null) {
            if (start.getLocalDate() != null) {
                date = start.getLocalDate();
            }
            if (start.getLocalTime() != null) {
                time = start.getLocalTime();
            }
        }

        Venue_ aVenue = getVenue(event);
        if (aVenue != null) {
            venue = aVenue.getName();
            Location location = aVenue.getLocation();
            if (location != null) {
                venue_lat = location.getLatitude();
                venue_long = location.getLongitude();
            }
        }

        List<Classification> classifications = event.getClassifications();

        if (classifications != null && classifications.size() > 0) {
            Classification classification = classifications.get(0);
            segment = classification.getSegment().getName();

            genre = classification.getGenre().getName();

            subGenre = classification.getSubGenre().getName();

        }
        image = getImage(event);

        return new EventData(id, name, date, time, venue,
                venue_lat, venue_long, genre, subGenre, segment, image);
    }


}
