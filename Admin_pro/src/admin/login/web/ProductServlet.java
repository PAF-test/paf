package admin.login.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.login.bean.Product;
import admin.login.databse.ProductDao;


       
    
	@WebServlet("/pro")
    	public class ProductServlet extends HttpServlet {
    		private static final long serialVersionUID = 1L;
    		private ProductDao productdao;
    	       
    	    
    	    
    		public void init() {
    			productdao = new ProductDao();
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
    				case "/newp":
    					showNewPForm(request, response);
    					break;
    				case "/insertp":
    					insertProduct(request, response);
    					break;
    				case "/deletep":
    					deleteProduct(request, response);
    					break;
    				case "/editp":
    					showEditPForm(request, response);
    					break;
    				case "/updatep":
    					updateProduct(request, response);
    					break;
    				default:
    					listProduct(request, response);
    					break;
    				}
    			} catch (SQLException ex) {
    				throw new ServletException(ex);
    			}
    		}

    		private void listProduct(HttpServletRequest request, HttpServletResponse response)
    				throws SQLException, IOException, ServletException {
    			List<Product> listProduct = productdao.selectAllProducts();
    			request.setAttribute("listProduct", listProduct);
    			RequestDispatcher dispatcher = request.getRequestDispatcher("listproducts.jsp");
    			dispatcher.forward(request, response);
    		}

    		private void showNewPForm(HttpServletRequest request, HttpServletResponse response)
    				throws ServletException, IOException {
    			RequestDispatcher dispatcher = request.getRequestDispatcher("productform.jsp");
    			dispatcher.forward(request, response);
    		}

    		private void showEditPForm(HttpServletRequest request, HttpServletResponse response)
    				throws SQLException, ServletException, IOException {
    			int pid = Integer.parseInt(request.getParameter("pid"));
    			Product existingProduct = productdao.selectProduct(pid);
    			RequestDispatcher dispatcher = request.getRequestDispatcher("productform.jsp");
    			request.setAttribute("user", existingProduct);
    			dispatcher.forward(request, response);

    		}

    		private void insertProduct(HttpServletRequest request, HttpServletResponse response) 
    				throws SQLException, IOException {
    			String pname = request.getParameter("pname");
    			String discription = request.getParameter("discription");
    			String price = request.getParameter("price");
    			Product newProduct = new Product(pname, discription, price);
    			productdao.insertProduct(newProduct);
    			response.sendRedirect("list");
    		}

    		private void updateProduct(HttpServletRequest request, HttpServletResponse response) 
    				throws SQLException, IOException {
    			int pid = Integer.parseInt(request.getParameter("pid"));
    			String pname = request.getParameter("pname");
    			String discription = request.getParameter("discription");
    			String price = request.getParameter("price");

    			Product book = new Product(pid, pname, discription, price);
    			productdao.updateProduct(book);
    			response.sendRedirect("list");
    		}

    		private void deleteProduct(HttpServletRequest request, HttpServletResponse response) 
    				throws SQLException, IOException {
    			int pid = Integer.parseInt(request.getParameter("pid"));
    			productdao.deleteProduct(pid);
    			response.sendRedirect("list");

    		}

    	}
