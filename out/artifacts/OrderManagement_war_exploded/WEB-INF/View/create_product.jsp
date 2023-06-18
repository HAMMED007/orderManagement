<%@ include file="/WEB-INF/View/header.html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content">
    <h3>Create Product</h3>
    <br>
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
        Create Product
    </button>
    <br><br>
    <table class="table">
        <thead>
        <tr>
            <th>Product Name</th>
            <th>SKU Code</th>
            <th>Unit Price</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="products" items="${getAllProducts}">
        <tr>
            <td>${products.product_name}</td>
            <td>${products.sku_code}</td>
            <td>${products.unit_price}</td>
            <td><a href="deleteProduct/${products.id}" class="btn btn-danger btn-sm">Delete</a></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>

    <br><br><br>

    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Create Product</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="save_product" method="POST">
                        <div class="col">
                            <div class="row">
                                <label>Product Name</label>
                                <input type="text"
                                       name="product_name"
                                       placeholder="Product Name"
                                       class="form-control"
                                       required
                                >
                            </div>
                            <br>
                            <div class="row">
                                <label>SKU Code</label>
                                <input type="text"
                                       name="sku_code"
                                       placeholder="SKU Code"
                                       class="form-control"
                                       required
                                >
                            </div>
                            <br>
                            <div class="row">
                                <label>Unit Price</label>
                                <input type="number"
                                       name="unit_price"
                                       placeholder="Unit Price"
                                       class="form-control"
                                       required
                                >
                            </div>
                            <br>
                            <button class="btn btn-success" type="submit">Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>


</div>
<%@ include file="/WEB-INF/View/footer.html" %>

