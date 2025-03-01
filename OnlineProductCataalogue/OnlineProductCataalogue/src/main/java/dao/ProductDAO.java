package dao;

import db.DBConnection;
import model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
//    public static List<Product> getProducts(String searchQuery, String category) {
//        List<Product> products = new ArrayList<>();
//        String sql = "SELECT * FROM products WHERE (name ILIKE ? OR ? = '') AND (category ILIKE ? OR ? = '')";
//
//        try (Connection conn = DBConnection.getConnection();
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//
//            // Set the search query for the product name
//            stmt.setString(1, "%" + searchQuery + "%");
//            stmt.setString(2, searchQuery); // Second parameter to check if searchQuery is empty
//            // Set the category
//            stmt.setString(3, "%" + category + "%");
//            stmt.setString(4, category); // Fourth parameter to check if category is empty
//
//            ResultSet rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                products.add(new Product(
//                        rs.getInt("id"),
//                        rs.getString("name"),
//                        rs.getDouble("price"),
//                        rs.getString("category"),
//                        rs.getString("description")
//                ));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return products;
//    }

    public static List<Product> getProducts(String searchQuery, String category) {
        List<Product> products = new ArrayList<>();
        // If searchQuery or category is empty, the condition (? = '' OR ...) becomes true.
        String sql = "SELECT * FROM products WHERE (? = '' OR name ILIKE ?) AND (? = '' OR category ILIKE ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Bind parameters: first check if searchQuery is empty; if not, filter by name.
            stmt.setString(1, searchQuery);
            stmt.setString(2, "%" + searchQuery + "%");
            // Bind parameters: first check if category is empty; if not, filter by category.
            stmt.setString(3, category);
            stmt.setString(4, "%" + category + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                products.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("category"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
