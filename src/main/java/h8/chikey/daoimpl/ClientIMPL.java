package h8.chikey.daoimpl;

import h8.chikey.dao.DAO;
import h8.chikey.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ClientIMPL implements DAO<Client,Integer> {

    public ClientIMPL(SessionFactory factory) {
        this.factory = factory;
    }

    SessionFactory factory;

    @Override
    public void create(Client client) {
        try(Session session = factory.openSession()){
            session.getTransaction();
            session.save(client);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Client client) {
        try(Session session = factory.openSession()){
            session.getTransaction();
            session.save(client);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Client client) {
        try(Session session = factory.openSession()){
            session.getTransaction();
            session.save(client);
            session.getTransaction().commit();
        }
    }

    @Override
    public Client read(Integer integer) {
        try(Session session = factory.openSession()){
            return session.get(Client.class,integer);
        }
    }

    @Override
    public List<Client> readMyAll() {
        try(Session session = factory.openSession()){
            String hql = "FROM Client";
            Query<Client> query = session.createQuery(hql);
           List<Client> list = query.list();
           return list;
        }
    }
}
