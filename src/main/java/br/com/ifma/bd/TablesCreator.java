package br.com.ifma.bd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TablesCreator {

	// Antes de rodar tem que trocar no persistence.xml a linha <property name="hibernate.hbm2ddl.auto" value="update"/>
	// para <property name="hibernate.hbm2ddl.auto" value="create"/>
	public static void main(String [] args){
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence_unit_logeasy"); //name of persistence unit here
	    @SuppressWarnings("unused")
		EntityManager entityManager = factory.createEntityManager();
	}
}
