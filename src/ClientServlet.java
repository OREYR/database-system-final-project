package net.insurancemanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.insurancemanagement.dao.ClientDAO;
import net.insurancemanagement.model.Client;


@WebServlet("/")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientDAO clientDAO;
	
	public void init() {
		clientDAO = new ClientDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewVersion(request, response);
				break;
			case "/insert":
				insertClient(request, response);
				break;
			case "/delete":
				deleteClient(request, response);
				break;
			case "/edit":
				showEditVersion(request, response);
				break;
			case "/update":
				updateClient(request, response);
				break;
			default:
				listClient(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listClient(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Client> listClient = clientDAO.selectAllClients();
		request.setAttribute("listClient", listClient);
		RequestDispatcher dispatcher = request.getRequestDispatcher("client-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewVersion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("client-version.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditVersion(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Client existingClient = clientDAO.selectClientByID(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("client-version.jsp");
		request.setAttribute("client", existingClient);
		dispatcher.forward(request, response);

	}

	private void insertClient(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String middleInitial = request.getParameter("middleInitial");
		String birthDate = request.getParameter("birthDate");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String ssn = request.getParameter("ssn");
		String mailAddress = request.getParameter("mailAddress");
		Double fraudRate = Double.parseDouble(request.getParameter("fraudRate"));
		
		Client newClient = new Client(lastName, firstName, middleInitial,
				birthDate, age, gender, ssn, mailAddress, fraudRate);
		clientDAO.insertClient(newClient);
		response.sendRedirect("list");
	}

	private void updateClient(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String middleInitial = request.getParameter("middleInitial");
		String birthDate = request.getParameter("birthDate");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String ssn = request.getParameter("ssn");
		String mailAddress = request.getParameter("mailAddress");
		Double fraudRate = Double.parseDouble(request.getParameter("fraudRate"));

		Client update = new Client(id, lastName, firstName, middleInitial,
				birthDate, age, gender, ssn, mailAddress, fraudRate);
		clientDAO.updateClient(update);
		response.sendRedirect("list");
	}

	private void deleteClient(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		clientDAO.deleteClient(id);
		response.sendRedirect("list");

	}

}
