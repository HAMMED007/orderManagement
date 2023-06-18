<%@ include file="/WEB-INF/View/header.html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content" style="width:90%;">
    <h3>Create Order</h3>
    <br>
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
        Create Order
    </button>
    <br><br>
    <form  action="searchOrder" method="POST">
        <div class="row">
            <div class="col">
                <select name="product_name" class="form-control">
                    <option selected disabled>Search By Product</option>
                    <c:forEach var="orders" items="${getAllOrders}">
                        <option value="${orders.product_name}">${orders.product_name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col">
                <select name="customer_name" class="form-control">
                    <option selected disabled>Search By Customer</option>
                    <c:forEach var="orders" items="${getAllOrders}">
                        <option value="${orders.customer_name}">${orders.customer_name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col">
                <select name="submission_date" class="form-control">
                    <option selected disabled>Search By Date</option>
                    <c:forEach var="orders" items="${getAllOrders}">
                        <option value="${orders.submission_date}">${orders.submission_date}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col">
                <button type="submit" class="btn btn-primary btn-sm">Search</button>
            </div>
        </div>

    </form>
    <br><br>
    <table class="table">
        <thead>
        <tr>
            <th>Product Name</th>
            <th>Customer Name</th>
            <th>Quantity</th>
            <th>Submission Date</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="orders" items="${getAllOrders}">
                <tr>
                    <td>${orders.product_name}</td>
                    <td>${orders.customer_name}</td>
                    <td>${orders.quantity}</td>
                    <td>${orders.submission_date}</td>
                    <td><a href="deleteOrder/${orders.id}" class="btn btn-danger btn-sm">Delete</a></td>
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
                    <form action="save_order" method="POST">
                        <div class="col">
                            <div class="row">
                                <label>Product Name</label>
                                <select class="form-control" name="product_name">
                                    <option selected disabled>Choose Product</option>
                                    <c:forEach var="products" items="${getAllProducts}">
                                           <option value="${products.product_name}">${products.product_name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <br>


                            <div class="row">
                                <label>Customer Name</label>
                                <select class="form-control" name="customer_name">
                                    <option selected disabled>Choose Customer</option>
                                    <c:forEach var="customers" items="${getCustomers}">
                                    <option value="${customers.full_name}">${customers.full_name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <br>


                            <div class="row">
                                <label>Quantity</label>
                                <input
                                        type="number"
                                        class="form-control"
                                        placeholder="Quantity"
                                        name="quantity"
                                        required/>
                            </div>
                            <br>
                            <div class="row">
                                <label>Submission Date</label>
                                <input
                                        type="date"
                                        class="form-control"
                                        placeholder="Submission Date"
                                        name="submission_date"
                                        required/>
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

