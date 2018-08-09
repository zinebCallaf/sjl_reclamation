import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;
import dao.Agent;



public class App {
	
	

	public static void main(String[] args) throws HibernateException {
		
		
		Session session = HibernateUtil.currentSession();
		   
		Transaction tx = session.beginTransaction();
		
		Agent agent = new Agent();
		agent.setAgentNom("callaf");
		agent.setAgentPrenom("zineb");
		session.save(agent);

		tx.commit();

		HibernateUtil.closeSession();
		
		
		
		

	}

}
