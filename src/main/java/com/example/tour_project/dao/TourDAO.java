package com.example.tour_project.dao;

import com.example.tour_project.models.Tour;
import com.example.tour_project.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class TourDAO {
    private static SessionFactory factory;

    public static List<Tour> listTour() {
        List<Tour> tours = null;
        factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            tours = session.createQuery("from Tour").list();
            return tours;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        session.close();
        return null;
    }

    public static Tour getDetail(String matour) {
        Tour tour = null;
        factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.clear();
        try {
            session.beginTransaction();
            tour = session.find(Tour.class, matour);
            return tour;
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return null;
    }
}


//            ArrayList<TourPrice> tourPrices = new ArrayList<>(tour.getPrices());
//            tour = new Tour(tour.getMatour(), tour.getLoaihinh(), tourPrices);
