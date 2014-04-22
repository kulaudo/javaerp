package common;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
//	private static final Logger logger = (Logger) LoggerFactory
//			.getLogger(HibernateUtil.class);
	private static SessionFactory sessionFactory;
	private static Configuration configuration;
	static {
		try {			
			configuration = new Configuration().configure("hibernate.cfg.xml");			
			sessionFactory = configuration.buildSessionFactory();

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Configuration getConfiguration() {
		return configuration;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {

		sessionFactory.close();
	}	
	

}
