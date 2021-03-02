package h8.chikey.daoimpl;

import h8.chikey.dao.DAO;
import h8.chikey.model.Gender;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


import java.util.List;

public class GenderIMPL implements DAO<Gender,Integer> {


    public GenderIMPL(SessionFactory factory) {
        this.factory = factory;
    }

    SessionFactory factory;

    @Override
    public void create(Gender gender) {
        try(Session session = factory.openSession()) {
            session.getTransaction();
            session.save(gender);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Gender gender) {
        try(Session session = factory.openSession()) {
            session.getTransaction();
            session.delete(gender);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Gender gender) {
        try(Session session = factory.openSession()) {
            session.getTransaction();
            session.update(gender);
            session.getTransaction().commit();
        }
    }

    @Override
    public Gender read(Integer integer) {
        try (Session session = factory.openSession()){
            return session.get(Gender.class,integer);
        }
    }

    @Override
    public List<Gender> readMyAll() {
        try (Session session = factory.openSession()){
            String hql = "FROM gender";
            Query<Gender> query = session.createQuery(hql);
            List<Gender> list = query.list();
            return list;
        }
    }
}
