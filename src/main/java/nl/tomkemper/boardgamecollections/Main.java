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

        long someId = -1;

        try (SessionFactory factory = cfg.buildSessionFactory()) {
            try (Session session = factory.openSession()) {
                Transaction tran = session.beginTransaction();

                for (String s : List.of("Monopoly", "Risk", "Scrabble")) {
                    Boardgame bg = new Boardgame(s);
                    session.persist(bg);
                }

                Boardgame catan = new Boardgame("Catan");
                session.persist(catan);
                someId = catan.getId();

                tran.commit();
            }


            try (Session session = factory.openSession()) {
                Boardgame bg = session.find(Boardgame.class, someId);
                System.out.println(bg.getName());
            }

//            try (Session session = factory.openSession()) {
//                Transaction tran = session.beginTransaction();
//                Boardgame bg = session.find(Boardgame.class, someId);
//                session.remove(bg);
//                tran.commit();
//            }

            try (Session session = factory.openSession()) {
                Transaction tran = session.beginTransaction();
                Boardgame bg = session.find(Boardgame.class, someId);

                bg.setRating(8);
                tran.commit();
            }

            //Update werkt niet zoals je verwacht:
//            try (Session session = factory.openSession()) {
//                Transaction tran = session.beginTransaction();
//                Boardgame bg = session.find(Boardgame.class, someId);
//                bg.setRating(7);
//
//
//                Boardgame updatedBg = new Boardgame("Catan");
//                updatedBg.setId(bg.getId());
//                updatedBg.setRating(8);
//
//                session.update(updatedBg);
//                tran.commit();
//            }

            //Update not recommmended:
//            try (Session session = factory.openSession()) {
//                Transaction tran = session.beginTransaction();
//                Boardgame updatedBg = new Boardgame("Catan");
//                updatedBg.setId(someId);
//                updatedBg.setRating(8);
//
//                session.update(updatedBg);
//                tran.commit();
//            }


            try (Session session = factory.openSession()) {
                List<Boardgame> boardgames = session.createQuery("from Boardgame", Boardgame.class).list();
                for (Boardgame bg : boardgames) {
                    System.out.println(bg.getName() + " " + bg.getRating());
                }
            }

        }
    }
}