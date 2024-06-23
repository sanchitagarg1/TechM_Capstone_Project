package com.files.entites;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Datadao {

    public Data checklogin(String email, String password) {
        Data data = null;
        Transaction transaction = null;
        
        try(Session session = HibernateUtil.getSession())  {
            transaction = session.beginTransaction();
            String hql = "FROM Data WHERE email = :email AND password = :password";
            Query<Data> query = session.createQuery(hql, Data.class);
            query.setParameter("email", email);
            query.setParameter("password", password);

            data = query.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return data;
    }

    public Data searchUser(String email) {
        Data data = null;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            String hql = "FROM Data WHERE email = :email";
            Query<Data> query = session.createQuery(hql, Data.class);
            query.setParameter("email", email);

            data = query.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return data;
    }

    public Integer insertRecord(Data data) {
        Transaction transaction = null;
        Integer status = 0;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.save(data);
            transaction.commit();
            status = 1;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return status;
    }

    public int DeleteUser(String email) {
        Transaction transaction = null;
        int row = 0;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            String hql = "DELETE FROM Data WHERE LOWER(email) = LOWER(:email)";
            Query<?> query = session.createQuery(hql);
            query.setParameter("email", email.toLowerCase());
            row = query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return row;
    }

    public int updaterecord(Data data) {
        Transaction transaction = null;
        int status = 0;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.update(data);
            transaction.commit();
            status = 1;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return status;
    }

    public List<Data> getRecords(int start, int total) {
        List<Data> users = null;
//        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
        	 Transaction transaction = session.getTransaction();
            transaction = session.beginTransaction();
            String hql = "FROM Data";
            Query<Data> query = session.createQuery(hql, Data.class);
//            query.setFirstResult(start - 1);
//            query.setMaxResults(total);

            users = query.list();
            transaction.commit();
        } catch (Exception e) {
//            if (transaction != null && transaction.isActive()) {
////                transaction.rollback();
//            }
            e.printStackTrace();
        }
        return users;
    }

    public int countRecords() {
        int count = 0;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            String hql = "SELECT COUNT(*) FROM Data";
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

    public int UpdatePass(String password, String email) {
        Transaction transaction = null;
        int status = 0;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            String hql = "UPDATE Data SET password = :password WHERE email = :email";
            Query<?> query = session.createQuery(hql);
            query.setParameter("password", password);
            query.setParameter("email", email);

            status = query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return status;
    }

    public int UploadImage(String email, String imageFileName) {
        Transaction transaction =null;
        int status = 0;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            String hql = "UPDATE Data SET imageFileName = :imageFileName WHERE email = :email";
            Query<?> query = session.createQuery(hql);
            query.setParameter("imageFileName", imageFileName);
            query.setParameter("email", email);

            status = query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return status;
    }
}