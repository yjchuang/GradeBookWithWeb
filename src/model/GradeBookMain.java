package model;

import javax.persistence.EntityManager;

public class GradeBookMain {

	public static void main(String[] args) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			model.Gradebook _gradeBook = em.find(model.Gradebook.class, (long)1);
			System.out.println(_gradeBook.getAssignmentName());
			System.out.println(_gradeBook.getAssignmentName());
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			em.close();
			System.out.println("finished!");
			
		}

	}

}
