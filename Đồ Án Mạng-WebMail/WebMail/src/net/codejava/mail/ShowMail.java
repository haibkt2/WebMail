package net.codejava.mail;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShowMail")
public class ShowMail extends HttpServlet {

	/**
	 * 
	 */
	public ShowMail() {
		super();
	}

	private static final long serialVersionUID = 1L;
	private String user;
	private String pass;
	private String protocol;
	private String host;
	private String port;

	public void init() {
		// reads SMTP server setting from web.xml file
		ServletContext context = getServletContext();
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
		protocol = "imap";
		host = "imap.gmail.com";
		port = "993";
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReceiverMail receiver = new ReceiverMail();
		receiver.downloadEmails(protocol, host, port, user, pass);
		List<InBoxMail> list = ReceiverMail.queryMail();
		// Set to 'departments' attribute of request
		request.setAttribute("mail", list);

		// Create RequestDispatcher to forward the request to
		// jstl_core_example01.jsp
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/inbox.jsp");

		// Forward the request to JSP page.
		dispatcher.forward(request, response);
	}
}
