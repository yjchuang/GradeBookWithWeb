package model;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class GradeFromJpa {
	
	
	
	public String GradeBookFromJpa() {
	model.Gradebook _gradeBook = null;
	EntityManager em = DBUtil.getEmFactory().createEntityManager();
	
	try {
		_gradeBook = em.find(model.Gradebook.class, (long)1);
		//System.out.println(_gradeBook.getAssignmentName());
	}catch (Exception e) {
		System.out.println(e);
	}finally {
		em.close();
		System.out.println("finished!");
	}
	return(_gradeBook.getAssignmentName());
}
	
	
public TypedQuery<Gradebook> findAssignmentWithName(String name) {
	
	EntityManager em1 = DBUtil.getEmFactory().createEntityManager();
	    return em1.createQuery(
	        "SELECT c FROM Gradebook c WHERE c.assignmentName LIKE :assignment", Gradebook.class)
	        .setParameter("assignment", name);
	        
	}

}
