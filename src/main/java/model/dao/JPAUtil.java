package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory factory = null;
	
	public static EntityManager getEntityManager()
	{
		if (JPAUtil.factory == null)
		{
			JPAUtil.factory = Persistence.createEntityManagerFactory("banco");
		}

		return JPAUtil.factory.createEntityManager();
	}
	
	
	private JPAUtil()
	{
		super();
	}

}
