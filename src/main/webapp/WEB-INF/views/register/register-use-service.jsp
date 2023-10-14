<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="label" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <title>Register Use Service</title>

    <script src="https://cdn.jsdelivr.net/timepicker.js/latest/timepicker.min.js"></script>
    <link href="https://cdn.jsdelivr.net/timepicker.js/latest/timepicker.min.css" rel="stylesheet"/>

</head>
<body>

<div id="root">
    <jsp:include page="../../common/header.jsp"/>

    <div class="container" style="margin-top: 130px;">
        <h3>Register Use Device</h3>
        <div class="row" style="margin-top: 50px;">
            <div class="col-6">
                <section>
                    <form:form name="myForm" method="post" action="register-use-service" modelAttribute="useService"  >
                        <div class="mb-3">
                            <form:label class="form-label" path="useServiceId.customerId">Code Customer <span style="color: red;">*</span></form:label>
                            <form:select class="form-control form-select" path="useServiceId.customerId">
                                <c:forEach var="customer" items="${customers}">
                                    <form:option value="${customer.id}"/>
                                </c:forEach>
                            </form:select>
                        </div> <div class="mb-3">
                            <form:label class="form-label" path="useServiceId.serviceId">Code Service <span style="color: red;">*</span></form:label>
                            <form:select class="form-control form-select" path="useServiceId.serviceId">
                                <c:forEach var="service" items="${services}">
                                    <form:option value="${service.id}"/>
                                </c:forEach>
                            </form:select>
                        </div>

                        <div class="mb-3">
                            <form:label class="form-label" path="useServiceId.dayBeganService">Day Began <span style="color: red;">*</span></form:label>
                            <form:input type="date" class="form-control" path="useServiceId.dayBeganService"/>
                            <span class="text-danger" id="errName"></span>
                        </div>
                        <div class="mb-3">
                            <form:label class="form-label" path="useServiceId.timeBeganService">Time Began <span style="color: red;">*</span></form:label>
                            <form:input type="text" class="form-control" path="useServiceId.timeBeganService" id="time" placeholder="Time"/>
                            <span class="text-danger" id="errName"></span>
                        </div>
                        <div class="mb-3">
                            <form:label class="form-label" path="amount">Amount <span style="color: red;">*</span></form:label>
                            <form:input type="text" class="form-control" name="timeOfUse" path="amount" />
                            <span class="text-danger" id="errorPrice"></span>
                        </div>
                        <button type="submit" class="btn btn-primary" id="btn-add">Register</button>
                    </form:form>
                </section>
            </div>
            <div class="col-6">
                <img  src="https://file.hstatic.net/200000536009/file/quan_net_xin_nhat_sai_gon_1_747956ffb7f645bcb9420f375006a6d6_grande.png"/>
            </div>
        </div>
    </div>
    <jsp:include page="../../common/footer.jsp"/>
</div>

<script>
    let timepicker = new TimePicker('time', {
        lang: 'en',
        theme: 'dark'
    });
    timepicker.on('change', function(evt) {

        var value = (evt.hour || '00') + ':' + (evt.minute || '00');
        evt.element.value = value;

    });
</script>
</body>
</html>
