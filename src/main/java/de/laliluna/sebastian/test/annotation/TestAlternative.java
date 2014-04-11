package de.laliluna.sebastian.test.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.kashu.learning.example.domain.annotation.Bee;
import com.kashu.learning.example.domain.annotation.Honey;

public class TestAlternative {

	private static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TestExample.class);

	public static void main(String[] args) {
		Transaction tx = null;
		Session session = null;
		try {
			/* clean tables */
			SessionFactory sessionFactory = InitSessionFactory.getInstance();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Honey honey = new Honey();
			honey.setName("country honey");
			honey.setTaste("Delicious");
			session.save(honey);

			Bee bee = new Bee("Sebastian");
			session.save(bee);

			/* create the relation on both sides */
			bee.setHoney(honey);
			honey.getBees().add(bee);

			tx.commit();
		} catch (RuntimeException e) {
			/*
			 * we must take care to rollback all transaction and to close the
			 * session after an exception has occured. <pre> The session is
			 * closed by our configuration, when we rollback the session. See
			 * current_session_context </pre>
			 */
			if (tx != null)
				try {
					tx.rollback();
				} catch (RuntimeException e1) {
					log.error("Error rolling back transaction");
				}
			// throw the exception again
			throw e;
		} finally {
			if (session != null)
				session.close();
		}
	}

}