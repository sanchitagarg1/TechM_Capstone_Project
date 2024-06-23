package com.files.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Date;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.files.entites.BookData;
import com.files.entites.BookDataDao;
import com.files.entites.Data;
import com.files.entites.Datadao;

import com.files.entites.TourPackage;


/**
 * Servlet implementation class ULoginServlet
 */
public class ULoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ULoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
//		String n=request.getParameter("attempt");
//		System.out.println("n :"+n);
		
		String email= request.getParameter("inemail");
		String password=request.getParameter("inpassword");
		
		Datadao d1 = new Datadao();
		Data user = d1.checklogin(email, password);
//		Data user = new Data();
//		user.setName("abc");
//		user.setPassword("abc");
//		user.setRole("Admin");
		
		if(user!=null) 
		{
//			request.setAttribute("name", user.getName());
//			request.setAttribute("email", user.getEmail());
//			request.setAttribute("phone", user.getPhone());
//			request.setAttribute("Address", user.getAddress());
//			request.setAttribute("Role", user.getRole());
			
			HttpSession session=request.getSession();
			session.setAttribute("name", user.getName());
			session.setAttribute("email", user.getEmail());
			
		if(user.getRole().equals("Admin"))
		{
			System.out.println("getRole:" + user.getRole());
			System.out.println("Admin Welcome");
			
			
			
			
//	--------------------- line 498 onward from AdminProfile -----------------------
			
			int pages = 1; 
			int total = 7;
			int offset = (pages > 1) ? (pages - 1) * total : 0;
			BookDataDao dao = new BookDataDao();
			List<BookData> records = dao.getRecords(offset, total);
			
			session.setAttribute("bookRecords", records);
			
			
			
			
//			--------------------- line 563 onward from AdminProfile -----------------------
			
			int pg=1;
			int total1=8;
			if(pg==1){
				pg--; 
			}else {
                pg=(pg-1)*total1; 
            } 
			List<Data> record = d1.getRecords(pg, total1);
			session.setAttribute("record", record);
			
			
			
			
			RequestDispatcher rd = request.getRequestDispatcher("AdminProfile.jsp");
			rd.forward(request, response);
		
		}
		else
			{
			request.setAttribute("name",  user.getName());
			request.setAttribute("email", user.getEmail());
			request.setAttribute("imageFileName", user.getImageFileName());
//			Cookie uid=new Cookie("userid",id);
//			uid.setMaxAge(60*60*24*2);
//			Cookie upass=new Cookie("userpass",pass);
//			upass.setMaxAge(60*60*24*2);
//			
//			response.addCookie(uid);
//			response.addCookie(upass);
			

			System.out.println("Session id : "+session.getId());
			System.out.println("Session Creation time : "+new Date(session.getCreationTime()));
//			session.setAttribute("id", id);
//			session.setAttribute("pass", pass);
			RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
			rd.forward(request, response);
			}
	}
		else
			{
			RequestDispatcher rd = request.getRequestDispatcher("wrong.jsp");
			rd.forward(request, response);
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
