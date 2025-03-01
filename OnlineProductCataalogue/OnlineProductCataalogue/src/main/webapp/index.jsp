<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>
<%@ page import="dao.ProductDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Online Product Catalog</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center">Product Catalog</h2>

    <form action="products" method="get" class="form-inline mb-3">
        <input type="text" name="search" class="form-control mr-2" placeholder="Search products">
        <select name="category" class="form-control mr-2">
            <option value="">All Categories</option>
            <option value="Electronics">Electronics</option>
            <option value="Fashion">Fashion</option>
        </select>
        <input type="submit" class="btn btn-primary" value="Search">
    </form>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Category</th>
            <th>Description</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Product> products = (List<Product>) request.getAttribute("products");
//            if (products != null && !products.isEmpty()) {
//                for (Product product : products) {
            if (products == null) {
                products = ProductDAO.getProducts("", "");
            }
            if (products != null && !products.isEmpty()) {
                for (Product product : products) {
        %>
        <tr>
            <td><%= product.getId() %></td>
            <td><%= product.getName() %></td>
            <td>$<%= String.format("%.2f", product.getPrice()) %></td>
            <td><%= product.getCategory() %></td>
            <td><%= product.getDescription() %></td>
        </tr>
        <%
            }
        } else {
        %>
        <tr><td colspan="5" class="text-center">No products found</td></tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
