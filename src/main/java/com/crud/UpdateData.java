package com.crud;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connectionjdbc.DBConnection;

/**
 * Servlet implementation class UpdateData
 */
@WebServlet("/UpdateData")
public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			DBConnection DB = new DBConnection();
			Connection conn = DB.getConnection();
			System.out.println("Connected to DB");
			PreparedStatement pd = conn.prepareStatement("update winter_internship set invoice_currency = ?,cust_payment_terms = ? where sl_no = ?");
			pd.setString(1, request.getParameter("invoice_currency"));
			pd.setString(2, request.getParameter("cust_payment_terms"));
			pd.setInt(3, Integer.parseInt(request.getParameter("sl_no")));
			pd.executeUpdate();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
