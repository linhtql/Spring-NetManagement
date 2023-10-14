<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
<c:url value="/statistic/page" var="urlList"/>


<div id="root">
  <jsp:include page="../../common/header.jsp"/>

  <div class="container-fluid" style="margin-top: 70px; margin-left: 15px">
    <h3>Statistic</h3>
    <div class="row" style="margin-top: 50px;">
        <section>
          <table class="table">
            <thead class="thead-dark">
            <tr>
              <th scope="col">Code Customer</th>
              <th scope="col">Name Customer </th>
              <th scope="col">Code Device</th>
              <th scope="col">Location</th>
              <th scope="col">Status</th>
              <th scope="col">Day Began Device</th>
              <th scope="col">Time Began Device</th>
              <th scope="col">Time Of Use</th>
              <th scope="col">Code Service</th>
              <th scope="col">Day Began Service</th>
              <th scope="col">Time Began Service</th>
              <th scope="col">Amount</th>
              <th scope="col">Total Price</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="c" items="${statistics}">

              <tr>
                <th scope="row">${c.customerId}</th>
                <th scope="row">${c.customerName}</th>
                <th scope="row">${c.deviceId}</th>
                <th scope="row">${c.location}</th>
                <th scope="row">${c.status}</th>
                <th scope="row">${c.dayBeganDevice}</th>
                <th scope="row">${c.timeBeganDevice}</th>
                <th scope="row">${c.timeOfUse}</th>
                <th scope="row">${c.serviceId}</th>
                <th scope="row">${c.dayBeganService}</th>
                <th scope="row">${c.timeBeganService}</th>
                <th scope="row">${c.amount}</th>
                <th scope="row">${c.total}</th>
              </tr>
            </c:forEach>
            </tbody>
          </table>

          <nav aria-label="...">
            <ul class="pagination">
              <c:forEach var="i" begin="1" end="${totalPage}">
                  <li class="page-item"><a class="page-link" href="${urlList}=${i}">${i}</a></li>
              </c:forEach>
            </ul>
          </nav>
        </section>
    </div>
  </div>
  <jsp:include page="../../common/footer.jsp"/>
</div>
</body>
</html>
