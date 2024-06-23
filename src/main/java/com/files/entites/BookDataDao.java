package com.files.entites;


//------------------------------ Hibernate Code ------------------------------------------



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BookDataDao {
	

    public List<BookData> getRecords(int start, int total) {
        List<BookData> users = null;
       
        
        
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();

            String hql = "FROM BookData ORDER BY booking_Time DESC";
            Query<BookData> query = session.createQuery(hql, BookData.class);
//            query.setFirstResult(start - 1); 
//            query.setMaxResults(total);

            users = query.list();
            transaction.commit();

            System.out.println("users list from bookdao :" + users);
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("error is :");
            e.printStackTrace();
        }

        return users;
    }

    public int countRecords() {
        int count = 0;
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();

            String hql = "SELECT COUNT(*) FROM BookData";
            Query<Long> query = session.createQuery(hql, Long.class);
            count = query.uniqueResult().intValue();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return count;
    }
}


















// ------------------------------ JDBC Code ------------------------------------------

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;

//
//public class BookDataDao{
//
//Connection con;
//PreparedStatement ps;
//ResultSet rs;
//public List<BookData> getRecords(int start , int total)
//{	
//	List<BookData> users=new ArrayList<>();
//	try {
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		System.out.println("Driver Found....");
//
//		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","user1","user1");
//		System.out.println("Connection Created");
//		
//			ps=con.prepareStatement("SELECT * FROM (SELECT * FROM Booking ORDER BY BookingTime DESC) subquery WHERE ROWNUM BETWEEN ? AND ?");
//			ps.setInt(1, start);
//			ps.setInt(2, total);
//			
//			rs=ps.executeQuery();
//			while(rs.next())
//			{
//				BookData da = new BookData();
//				da.setDestination(rs.getString("Destination"));
//				da.setGuests(rs.getInt("Guests"));
//				da.setPhone(rs.getLong("Phone"));
//				da.setArrival(rs.getString("Arrival"));
//				da.setLeaving(rs.getString("Leaving"));
//				da.setFrom(rs.getString("WhereFrom"));
//				da.setBooking_Time(rs.getString("BookingTime"));
//				users.add(da);
//			}
//			System.out.println("users list from bookdao :" + users);
//			
//		}
//	
//		catch (ClassNotFoundException | SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	return users;
//	}
//
//public int countRecords()
//{
//	int count =0;
//	
//	try {
//		ps=con.prepareStatement("SELECT COUNT(*) FROM Booking");
//		
//		rs=ps.executeQuery();
//		if(rs.next())
//		{
//			count=rs.getInt(1);
//		}
//		
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	return count;
//}
//}
