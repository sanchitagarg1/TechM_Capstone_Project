package com.files.entites;

//import javax.persistence.Column;
//import javax.persistence.Id;
//import javax.persistence.Table;

//import javax.persistence.Entity;

//@Entity
//@Table(name = "BOOKING")
public class BookData {
	
//		@Id
//	    @Column(name = "PHONE", nullable = false)
		long Phone;
	
//		@Column(name = "DESTINATION")
		String Destination;
		
//		@Column(name = "WHEREFROM")
		String From;
		
//		@Column(name = "GUESTS")
		int Guests;
		

//		@Column(name = "ARRIVAL")
		String Arrival;
		
//		@Column(name = "LEAVING")
		String Leaving;
		
//		@Column(name = "BOOKINGTIME")
		String booking_Time;
		
		
		
		public String getDestination() {
			return Destination;
		}
		public void setDestination(String destination) {
			Destination = destination;
		}
		public int getGuests() {
			return Guests;
		}
		public void setGuests(int guests) {
			Guests = guests;
		}
		public long getPhone() {
			return Phone;
		}
		public void setPhone(long phone) {
			Phone = phone;
		}
		public String getArrival() {
			return Arrival;
		}
		public void setArrival(String arrival) {
			Arrival = arrival;
		}
		public String getLeaving() {
			return Leaving;
		}
		public void setLeaving(String leaving) {
			Leaving = leaving;
		}
		public String getFrom() {
			return From;
		}
		public void setFrom(String from) {
			From = from;
		}
		public String getBooking_Time() {
			return booking_Time;
		}
		public void setBooking_Time(String booking_Time) {
			this.booking_Time = booking_Time;
		}
		
		
}
