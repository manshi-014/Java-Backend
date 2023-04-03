package com.crud;

import java.io.IOException;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connectionjdbc.DBConnection;
import com.google.gson.Gson;
import com.pojo.WinterInternship;

/**
 * Servlet implementation class GetData
 */
@WebServlet("/GetData")
public class GetData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("application/json;charset=UTF-8");
		try {
			DBConnection DB = new DBConnection();
			Connection conn = DB.getConnection();
			System.out.println("Connected to DB");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT *FROM winter_internship WHERE is_deleted = 0");
			PrintWriter out = response.getWriter();
			ArrayList<WinterInternship> val = new ArrayList<WinterInternship>();
			while(rs.next())
			{
				WinterInternship winter = new WinterInternship();
				winter.setSl_no(rs.getInt("sl_no"));
				winter.setBusiness_code(rs.getString("business_code"));
				winter.setCust_number(rs.getInt("cust_number"));
				winter.setClear_date(rs.getString("clear_date"));
				winter.setBuisness_year(rs.getInt("buisness_year"));
				winter.setDoc_id(rs.getDouble("doc_id"));
				winter.setPosting_date(rs.getString("posting_date"));
				winter.setDocument_create_date(rs.getString("document_create_date"));
				winter.setDue_in_date(rs.getString("due_in_date"));
				winter.setInvoice_currency(rs.getString("invoice_currency"));
				winter.setDocument_type(rs.getString("document_type"));
				winter.setPosting_id(rs.getInt("posting_id"));
				winter.setTotal_open_amount(rs.getDouble("total_open_amount"));
				winter.setBaseline_create_date(rs.getString("baseline_create_date"));
				winter.setCust_payment_terms(rs.getString("cust_payment_terms"));
				winter.setInvoice_id(rs.getInt("invoice_id"));
				val.add(winter);
				//Gson gson = new Gson();
			}
			out.println(new Gson().toJson(val));
			st.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/

}
