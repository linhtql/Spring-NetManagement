<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <title>Create Device</title>

</head>
<body>
<c:url value="/edit-customer" var="urlUpdate"/>
<c:url value="/delete-customer" var="urlDelete"/>
<c:url value="/list-customer/page" var="urlList"/>


<div id="root">
    <jsp:include page="../../common/header.jsp"/>

    <div class="container" style="margin-top: 130px;">
        <h3>List Customer</h3>
        <div class="row" style="margin-top: 50px;">
            <div class="col-10">
                <div class="row">
                    <div class="col-6">
                        <form method="get" action="${pageContext.request.contextPath}/list-customer">
                            <input type="text" name="keyword" /> &nbsp;
                            <button class="btn btn-primary" type="submit" >Search</button>
                        </form>
                    </div>
                    <div class="col-6">
                        <button class="btn btn-primary" onclick="location.href = '${pageContext.request.contextPath}/add-customer'" style="float: right">Add Customer</button>
                    </div>
                </div>
                <section>
                    <table class="table">
                        <thead class="thead-dark">
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">Address</th>
                            <th scope="col">Phone</th>
                            <th scope="col">Email</th>
                            <th scope="col">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="customer" items="${customers}">

                            <tr>
                                <th scope="row">${customer.id}</th>
                                <td>${customer.name}</td>
                                <td>${customer.address}</td>
                                <td>${customer.phone}</td>
                                <td>${customer.email}</td>
                                <td><button type="button" class="btn btn-primary" onclick="location.href = '${urlUpdate}/${customer.id}'">Update</button>
                                 <button type="button" class="btn btn-danger" onclick="if( window.confirm('do you want to delete customer?')) {location.href = '${urlDelete}/${customer.id}'}">Delete</button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <nav aria-label="...">
                        <ul class="pagination">
                            <c:forEach var="i" begin="1" end="${totalPage}">
                                <c:if test="${keyword != null}">
                                    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/list-customer/page=${i}?keyword=${keyword}">${i}</a></li>
                                </c:if>
                                <c:if test="${keyword == null}">
                                    <li class="page-item"><a class="page-link" href="${urlList}=${i}">${i}</a></li>
                                </c:if>
                            </c:forEach>
                        </ul>
                    </nav>
                </section>
            </div>
            <div class="col-2">
                <img  src="https://file.hstatic.net/200000536009/file/quan_net_xin_nhat_sai_gon_1_747956ffb7f645bcb9420f375006a6d6_grande.png"/>
            </div>
        </div>
    </div>
    <jsp:include page="../../common/footer.jsp"/>
</div>

</body>
</html>
