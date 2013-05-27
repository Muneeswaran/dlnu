package com.myitbbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckSecurityCode extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		System.out.println("*********");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String serverCode = (String) session.getAttribute("rand");
		String securityCode = request.getParameter("securityCode");
		System.out.println("serverCode*********"+serverCode);
		System.out.println("securityCode*********"+securityCode);
		if (!serverCode.equals(securityCode)) {
			out.print("true");
		} else {
			out.print("false");
		}

	}

}
