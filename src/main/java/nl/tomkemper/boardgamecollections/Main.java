package nl.tomkemper.boardgamecollections;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure();

        long catanId = -1;
        long domaineId = -1;

        try (SessionFactory factory = cfg.buildSessionFactory()) {
            try (Session session = factory.openSession()) {
                Transaction tran = session.beginTransaction();

                Author klaus = new Author("Klaus", "Teuber");

                Boardgame catan = new Boardgame("Catan");
                session.persist(catan);
                catanId = catan.getId();
                catan.setAuthor(klaus);

                Boardgame domaine = new Boardgame("Domaine");
                domaine.setAuthor(klaus);
                session.persist(domaine);
                domaineId = domaine.getId();
                tran.commit();
            }


            try (Session session = factory.openSession()) {
                Transaction tran = session.beginTransaction();

                Boardgame domaine = session.get(Boardgame.class, domaineId);
                session.remove(domaine);

                tran.commit();

            }
        }
    }
}