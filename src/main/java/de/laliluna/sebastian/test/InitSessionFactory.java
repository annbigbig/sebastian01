package de.laliluna.sebastian.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * @author hennebrueder This class garanties that only one single SessionFactory
 *         is instanciated and that the configuration is done thread safe as
 *         singleton. Actually it only wraps the Hibernate SessionFactory. When
 *         a JNDI name is configured the session is bound to to JNDI, else it is
 *         only saved locally. You are free to use any kind of JTA or Thread
 *         transactionFactories.
 */
public class InitSessionFactory {

	/** The single instance of hibernate SessionFactory */
	private static org.hibernate.SessionFactory sessionFactory;

	/**
     * Default constructor. It is private to guaranty singleton
     */
	private InitSessionFactory() {
	}

	static {

        final Configuration cfg = new Configuration();
        cfg.configure();
        final ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                .applySettings(cfg.getProperties())
                .buildServiceRegistry();
        sessionFactory = cfg.buildSessionFactory(serviceRegistry);

	}

	/**
     * Returns the single instance of the session factory
     * 
     * @return
     */
	public static SessionFactory getInstance() {
		return sessionFactory;
	}

	public static Session openSession() {
		return sessionFactory.openSession();
	}
}