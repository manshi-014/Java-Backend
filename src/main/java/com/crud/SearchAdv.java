package com.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
 * Servlet implementation class SearchAdv
 */
@WebServlet("/SearchAdv")
public class SearchAdv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAdv() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		try {
			DBConnection DB = new DBConnection();
			Connection conn = DB.getConnection();
			System.out.println("Connected to DB");
			PreparedStatement pd = conn.prepareStatement("SELECT *FROM winter_internship WHERE doc_id = ? AND invoice_id = ? AND cust_number = ? AND buisness_year = ?");
			pd.setDouble(1,Double.parseDouble(request.getParameter("doc_id")));
			pd.setInt(2,Integer.parseInt(request.getParameter("invoice_id")));
			pd.setInt(3, Integer.parseInt(request.getParameter("cust_number")));
			pd.setInt(4,Integer.parseInt(request.getParameter("buisness_year")));
			ResultSet rs = pd.executeQuery();
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
				winter.setDoc_id(rs.getInt("doc_id"));
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
			}
			out.println(new Gson().toJson(val));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
