package com.files.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.files.entites.TourPackage;

/**
 * Servlet implementation class AddPackage
 */
public class AddPackage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPackage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("html/text");
		
		String fromLocation = request.getParameter("fromLocation");
        String toLocation = request.getParameter("toLocation");
        String hotelName = request.getParameter("hotelName");
        String hotelLocation = request.getParameter("hotelLocation");
        String nearbyLandmark = request.getParameter("nearbyLandmark");
        String roomType = request.getParameter("roomType");
        String numberOfRooms = request.getParameter("numberOfRooms");
        String petFriendly = request.getParameter("petFriendly");
        String foodChoice = request.getParameter("foodChoice");
        String travelMode = request.getParameter("travelMode");
        String numberOfDays = request.getParameter("numberOfDays");
        String numberOfNights = request.getParameter("numberOfNights");
        String price = request.getParameter("price");

        // Database connection parameters
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String driver = "oracle.jdbc.driver.OracleDriver";
        String username = "user1";
        String password = "user1";

        try {
            // Load the driver class
            Class.forName(driver);

            // Establish the connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Prepare SQL statement for insertion
            String sql = "INSERT INTO tourpackage (from_location, to_location, hotel_name, hotel_location, nearby_landmark, room_type, number_of_rooms, pet_friendly, food_choice, travel_mode, number_of_days, number_of_nights, price) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, fromLocation);
            stmt.setString(2, toLocation);
            stmt.setString(3, hotelName);
            stmt.setString(4, hotelLocation);
            stmt.setString(5, nearbyLandmark);
            stmt.setString(6, roomType);
            stmt.setString(7, numberOfRooms);
            stmt.setString(8, petFriendly);
            stmt.setString(9, foodChoice);
            stmt.setString(10, travelMode);
            stmt.setString(11, numberOfDays);
            stmt.setString(12, numberOfNights);
            stmt.setString(13, price);

            // Execute the statement
            int rowsAffected = stmt.executeUpdate();

            // Close the connections
            stmt.close();
            con.close();

            // Provide feedback to the user
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>Package added successfully!</h2>");
            out.println("</body></html>");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error adding package to database");
        }
	}
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		response.setContentType("html/text");
		PrintWriter pw = response.getWriter();
		
        // Database connection parameters
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String driver = "oracle.jdbc.driver.OracleDriver";
        String username = "user1";
        String password = "user1";

        // List to hold tour package data
        List<TourPackage> tourPackages = new ArrayList<>();

        try {
            // Load the driver class
            Class.forName(driver);

            // Establish the connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Prepare SQL statement to select data from tourpackage table
            String sql = "SELECT * FROM tourpackage";
            PreparedStatement stmt = con.prepareStatement(sql);

            // Execute the query
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs + " this is the data from table");

            // Process the result set
            while (rs.next()) {
                // Create TourPackage object and populate its fields
                TourPackage tourPackage = new TourPackage();
                tourPackage.setFromLocation(rs.getString("from_location"));
                tourPackage.setToLocation(rs.getString("to_location"));
                tourPackage.setTravelMode(rs.getString("travel_mode"));
                tourPackage.setPrice(rs.getString("price"));
                // Populate other fields similarly

                // Add TourPackage object to the list
                tourPackages.add(tourPackage);
            }

            // Close the connections
            rs.close();
            stmt.close();
            con.close();

            System.out.println("data from tourpackage" + tourPackages);
            // Set the tourPackages list as an attribute in the request object
            request.setAttribute("tourPackages", tourPackages);

            // Forward the request to the index.jsp page
            RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
            rd.forward(request, response);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error retrieving tour package data");
        }
    }
	

}
