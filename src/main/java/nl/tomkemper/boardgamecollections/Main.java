package nl.tomkemper.boardgamecollections;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure();

        try(SessionFactory factory = cfg.buildSessionFactory()){
            try(Session session = factory.openSession()){
                Transaction tran = session.beginTransaction();
                Boardgame catan = new Boardgame("Catan");

                session.persist(catan);

                tran.commit();
            }



        }
    }
}