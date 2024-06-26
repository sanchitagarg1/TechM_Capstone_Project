package com.files.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TourPackage {
    private String fromLocation;
    private String toLocation;
    private String hotelName;
    private String hotelLocation;
    private String nearbyLandmark;
    private String roomType;
    private String numberOfRooms;
    private String petFriendly;
    private String foodChoice;
    private String travelMode;
    private String numberOfDays;
    private String numberOfNights;
    private String price;
}
