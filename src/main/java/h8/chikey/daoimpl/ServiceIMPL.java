package h8.chikey.daoimpl;

import h8.chikey.dao.DAO;
import h8.chikey.model.Service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ServiceIMPL implements DAO<Service,Integer> {

    public ServiceIMPL(SessionFactory factory) {
        this.factory = factory;
    }
    SessionFactory factory;



    @Override
    public void create(Service service) {
        try(Session session = factory.openSession()) {
            session.getTransaction();
            session.save(service);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Service service) {
        try(Session session = factory.openSession()) {
            session.getTransaction();
            session.save(service);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Service service) {
        try(Session session = factory.openSession()) {
            session.getTransaction();
            session.save(service);
            session.getTransaction().commit();
        }
    }

    @Override
    public Service read(Integer integer) {
        try(Session session = factory.openSession()) {
            return session.get(Service.class, integer);
        }
    }

    @Override
    public List<Service> readMyAll() {
        try(Session session = factory.openSession()) {
            String hql = "FROM service";
            Query<Service> query = session.createQuery(hql);
            List<Service> list = query.list();
            return list;
        }
    }
}
