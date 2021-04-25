package admin.login.databse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.login.bean.Product;

public class ProductDao {
	
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/admindb?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	
	
	private static final String INSERT_PRODUCTS_SQL = "INSERT INTO produts" + "  (pname, discription, price) VALUES "
			+ " (?, ?, ?);";

	private static final String SELECT_PRODUCT_BY_ID = "select id,name,email,country from users where id =?";
	private static final String SELECT_ALL_PRODUCTS = "select * from products";
	private static final String DELETE_PRODUCTS_SQL = "delete from products where id = ?;";
	private static final String UPDATE_PRODUCTS_SQL = "update products set pname = ?,discription= ?, price =? where id = ?;";


public ProductDao() {
}

protected Connection getConnection() {
	Connection connection = null;
	try {
		Class.forName(jdbcDriver);
		connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return connection;
}
//Add Product to the System

public void insertProduct(Product product) throws SQLException {
	System.out.println(INSERT_PRODUCTS_SQL);
	// try-with-resource statement will auto close the connection.
	try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCTS_SQL)) {
		preparedStatement.setString(1, product.getPname());
		preparedStatement.setString(2, product.getDiscription());
		preparedStatement.setString(3, product.getPrice());
		System.out.println(preparedStatement);
		preparedStatement.executeUpdate();
	} catch (SQLException e) {
		printSQLException(e);
	}
}

	//Select Product from pid

public Product selectProduct(int pid) {
	Product product = null;
	//Establishing a Connection
	try (Connection connection = getConnection();
			//Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
		preparedStatement.setInt(1, pid);
		System.out.println(preparedStatement);
		//update query
		ResultSet rs = preparedStatement.executeQuery();

		//
		while (rs.next()) {
			String pname = rs.getString("pname");
			String discription = rs.getString("discription");
			String price = rs.getString("price");
			product = new Product(pid, pname, discription, price);
		}
	} catch (SQLException e) {
		printSQLException(e);
	}
	return product;
}

//All p selction

public List<Product> selectAllProducts() {

	// 
	List<Product> products = new ArrayList<>();
	//Establish a Connection
	try (Connection connection = getConnection();

			//Create a statement using connection object
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);) {
		System.out.println(preparedStatement);
		//Query execute or update
		ResultSet rs = preparedStatement.executeQuery();

		//
		while (rs.next()) {
			int pid = rs.getInt("pid");
			String pname = rs.getString("pname");
			String discription = rs.getString("discription");
			String price = rs.getString("price");
			products.add(new Product(pid, pname, discription, price));
		}
	} catch (SQLException e) {
		printSQLException(e);
	}
	return products;
}

//update product
public boolean updateProduct(Product product) throws SQLException {
	boolean rowUpdated;
	try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCTS_SQL);) {
		System.out.println("updated Product:"+statement);
		statement.setString(1, product.getPname());
		statement.setString(2, product.getDiscription());
		statement.setString(3, product.getPrice());
		statement.setInt(4, product.getPid());

		rowUpdated = statement.executeUpdate() > 0;
	}
	return rowUpdated;
}

//Delete user

public boolean deleteProduct(int pid) throws SQLException {
	boolean rowDeleted;
	//Establish a Connection
	try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCTS_SQL);) {
		statement.setInt(1, pid);
		rowDeleted = statement.executeUpdate() > 0;
	}
	return rowDeleted;
}









private void printSQLException(SQLException ex) {
	for (Throwable e : ex) {
		if (e instanceof SQLException) {
			e.printStackTrace(System.err);
			System.err.println("SQLState: " + ((SQLException) e).getSQLState());
			System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
			System.err.println("Message: " + e.getMessage());
			Throwable t = ex.getCause();
			while (t != null) {
				System.out.println("Cause: " + t);
				t = t.getCause();
			}
		}
	}
}






}


