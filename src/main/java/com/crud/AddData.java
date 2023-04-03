package com.crud;

import java.io.IOException;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connectionjdbc.DBConnection;
import com.pojo.WinterInternship;

/**
 * Servlet implementation class AddData
 */
@WebServlet("/AddData")
public class AddData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddData() {
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
			PreparedStatement pd = conn.prepareStatement("INSERT INTO winter_internship (business_code,cust_number,clear_date,buisness_year,doc_id,posting_date,document_create_date,due_in_date,invoice_currency,document_type,posting_id,total_open_amount,baseline_create_date,cust_payment_terms,invoice_id) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pd.setString(1, request.getParameter("business_code"));
			pd.setInt(2,Integer.parseInt(request.getParameter("cust_number")));
			pd.setString(3, request.getParameter("clear_date"));
			pd.setInt(4, Integer.parseInt(request.getParameter("buisness_year")));
			pd.setDouble(5, Double.parseDouble(request.getParameter("doc_id")));
			pd.setString(6,request.getParameter("posting_date"));
			pd.setString(7, request.getParameter("document_create_date"));
			pd.setString(8, request.getParameter("due_in_date"));
			pd.setString(9, request.getParameter("invoice_currency"));
			pd.setString(10, request.getParameter("document_type"));
			pd.setInt(11,Integer.parseInt(request.getParameter("posting_id")));
			pd.setDouble(12,Double.parseDouble(request.getParameter("total_open_amount")));
			pd.setString(13,request.getParameter("baseline_create_date"));
			pd.setString(14, request.getParameter("cust_payment_terms"));
			pd.setInt(15, Integer.parseInt("invoice_id"));
			pd.executeUpdate();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
