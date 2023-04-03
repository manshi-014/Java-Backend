package com.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		try {
			DBConnection DB = new DBConnection();
			Connection conn = DB.getConnection();
			System.out.println("Connected to DB");
			PreparedStatement pd = conn.prepareStatement("update winter_internship set is_deleted = 1 where sl_no = ?");
			pd.setInt(1, Integer.parseInt(request.getParameter("sl_no")));
			pd.executeUpdate();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
