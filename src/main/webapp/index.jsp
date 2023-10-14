<%@ page import="java.time.LocalDateTime" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="label" uri="http://www.springframework.org/tags/form" %>

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

<div id="root">
    <jsp:include page="WEB-INF/common/header.jsp"/>

    <div class="container" style="margin-top: 130px;">
        <div class="row" style="margin-top: 50px;">
            <div class="col-6">
                <section>
                  <h2>Welcome to My Program!!!</h2>
                    <h5>Have a nice day</h5>
                    <h5>Time on the server: <%=LocalDateTime.now()%></h5>
                </section>
            </div>
            <div class="col-6">
                <img  src="https://file.hstatic.net/200000536009/file/quan_net_xin_nhat_sai_gon_1_747956ffb7f645bcb9420f375006a6d6_grande.png"/>
            </div>
        </div>
    </div>
    <jsp:include page="WEB-INF/common/footer.jsp"/>
</div>

</body>
</html>
