


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GradeFromJpa;
import model.Gradebook;

/**
 * Servlet implementation class GradeBookServlet
 */
@WebServlet("/GradeBookServlet")
public class GradeBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GradeBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		String _assignmentName = "";
		GradeFromJpa _gfj = new GradeFromJpa();

		//_assignmentName = _gfj.GradeBookFromJpa();

		List<Gradebook> _assignList = _gfj.findAssignmentWithName(request.getParameter("assignment")).getResultList();

		//List<Gradebook> _assignList = _typedQuery.getResultList();
		//ArrayList<Gradebook> _assignmentListWithName = _gfj.findAssignmentWithName(request.getParameter("Assign1"));

		_assignmentName = "<tr><th>Name</th><th>Type</th><th>Date</th><th>Grade</th></tr>";
		
		for(Gradebook oneAssign : _assignList)
		{
			_assignmentName+="<tr>";

			_assignmentName+="<td>"+oneAssign.getAssignmentName()+"</td>";
			_assignmentName+="<td>"+oneAssign.getAssignmentType()+"</td>";
			_assignmentName+="<td>"+oneAssign.getAssignmentDate()+"</td>";
			_assignmentName+="<td>"+oneAssign.getGrade()+"</td>";
			
			_assignmentName+="</tr>";
			_assignmentName+="<br>";
		}


		request.setAttribute("message", _assignmentName);

		request.getRequestDispatcher("/GradeFirstPage.jsp").forward(request, response);
	}

}
