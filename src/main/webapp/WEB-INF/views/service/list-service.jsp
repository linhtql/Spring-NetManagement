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
<c:url value="/edit-service" var="urlUpdate"/>
<c:url value="/delete-service" var="urlDelete"/>
<c:url value="/list-service/page" var="urlList"/>

<div id="root">
    <jsp:include page="../../common/header.jsp"/>

    <div class="container" style="margin-top: 130px;">
        <h3>List Service</h3>
        <div class="row" style="margin-top: 50px;">
            <div class="col-9">
                <div class="row">
                    <div class="col-6">
                        <form method="get" action="${pageContext.request.contextPath}/list-service">
                            <input type="text" name="keyword" /> &nbsp;
                            <button class="btn btn-primary" type="submit" >Search</button>
                        </form>
                    </div>
                    <div class="col-6">
                        <button class="btn btn-primary" onclick="location.href = '${pageContext.request.contextPath}/add-service'" style="float: right">Add Service</button>
                    </div>
                </div>
                <section>
                    <table class="table">
                        <thead class="thead-dark">
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">Unit</th>
                            <th scope="col">Price</th>
                            <th scope="col">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="service" items="${services}">
                            <tr>
                                <th scope="row">${service.id}</th>
                                <td>${service.name}</td>
                                <td>${service.unit}</td>
                                <td>${service.price}</td>
                                <td><button type="button" class="btn btn-primary" onclick="location.href = '${urlUpdate}/${service.id}'">Update</button>
                                 <button type="button" class="btn btn-danger" onclick="if( window.confirm('do you want to delete service?')) {location.href = '${urlDelete}/${service.id}'}">Delete</button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <nav aria-label="...">
                        <ul class="pagination">
                            <c:forEach var="i" begin="1" end="${totalPage}">
                                <c:if test="${keyword != null}">
                                    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/list-service/page=${i}?keyword=${keyword}">${i}</a></li>
                                </c:if>
                                <c:if test="${keyword == null}">
                                    <li class="page-item"><a class="page-link" href="${urlList}=${i}">${i}</a></li>
                                </c:if>
                            </c:forEach>
                        </ul>
                    </nav>
                </section>
            </div>
            <div class="col-3">
                <img  src="https://file.hstatic.net/200000536009/file/quan_net_xin_nhat_sai_gon_1_747956ffb7f645bcb9420f375006a6d6_grande.png"/>
            </div>
        </div>
    </div>
    <jsp:include page="../../common/footer.jsp"/>
</div>

</body>
</html>
