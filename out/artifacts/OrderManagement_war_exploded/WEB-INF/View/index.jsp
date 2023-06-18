<%@ include file="/WEB-INF/View/header.html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="content">
    <h3>Create Customer</h3>
    <br>
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
        Create Customer
    </button>
    <br><br>
    <table class="table">
        <thead>
            <tr>
                <th>Registration Code</th>
                <th>Full Name</th>
                <th>Email</th>
                <th>Telephone</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="customers" items="${getCustomers}">
            <tr>
                <td>${customers.registration_code}</td>
                <td>${customers.full_name}</td>
                <td>${customers.email}</td>
                <td>${customers.telephone}</td>
                <td><a href="deleteCustomer/${customers.id}" class="btn btn-danger btn-sm">Delete</a></td>
            </tr>
            </c:forEach>
        </tbody>
    </table>

    <br><br><br>

    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Create Customer</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="save_customer" method="POST">
                        <div class="col">
                            <div class="row">
                                <label>Registration Code</label>
                                <input type="text"
                                       name="registration_code"
                                       placeholder="Registration Code"
                                       class="form-control"
                                       required
                                >
                            </div>
                            <br>
                            <div class="row">
                                <label>Full Name</label>
                                <input type="text"
                                       name="full_name"
                                       placeholder="Full Name"
                                       class="form-control"
                                       required
                                >
                            </div>
                            <br>
                            <div class="row">
                                <label>Email</label>
                                <input type="text"
                                       name="email"
                                       placeholder="Email"
                                       class="form-control"
                                       required
                                >
                            </div>
                            <br>
                            <div class="row">
                                <label>Telephone</label>
                                <input type="text"
                                       name="telephone"
                                       placeholder="Telephone"
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

