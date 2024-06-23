package com.files.entites;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.files.entites.TourPackage;

public class TourPackageTest {

    @Test
    public void testTourPackageGettersAndSetters() {
        TourPackage tourPackage = new TourPackage();
        
        tourPackage.setFromLocation("New York");
        tourPackage.setToLocation("Los Angeles");
        tourPackage.setHotelName("Holiday Inn");
        tourPackage.setHotelLocation("Downtown");
        tourPackage.setNearbyLandmark("Central Park");
        tourPackage.setRoomType("Deluxe");
        tourPackage.setNumberOfRooms("2");
        tourPackage.setPetFriendly("Yes");
        tourPackage.setFoodChoice("Veg");
        tourPackage.setTravelMode("Flight");
        tourPackage.setNumberOfDays("5");
        tourPackage.setNumberOfNights("4");
        tourPackage.setPrice("1500");

        assertEquals("New York", tourPackage.getFromLocation());
        assertEquals("Los Angeles", tourPackage.getToLocation());
        assertEquals("Holiday Inn", tourPackage.getHotelName());
        assertEquals("Downtown", tourPackage.getHotelLocation());
        assertEquals("Central Park", tourPackage.getNearbyLandmark());
        assertEquals("Deluxe", tourPackage.getRoomType());
        assertEquals("2", tourPackage.getNumberOfRooms());
        assertEquals("Yes", tourPackage.getPetFriendly());
        assertEquals("Veg", tourPackage.getFoodChoice());
        assertEquals("Flight", tourPackage.getTravelMode());
        assertEquals("5", tourPackage.getNumberOfDays());
        assertEquals("4", tourPackage.getNumberOfNights());
        assertEquals("1500", tourPackage.getPrice());
    }
}
