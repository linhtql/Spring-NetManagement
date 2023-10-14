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
    <style>
        .error {
            color: #ff0000;
        }
    </style>
</head>
<body>

<div id="root">
    <jsp:include page="../../common/header.jsp"/>

    <div class="container" style="margin-top: 130px;">
        <h3> Add Device</h3>
        <div class="row" style="margin-top: 50px;">
            <div class="col-6">
                <section>
                    <form:form name="myForm" method="post" action="add-device" modelAttribute="device" onsubmit="return validDevice()">
                        <div class="mb-3 ">
                            <form:label class="form-label" path="id">Code Device <span style="color: red;">*</span></form:label>
                            <form:input type="text" class="form-control" name="id" path="id" id="id"/>
                            <span><form:errors path = "id" cssClass = "text-danger" /></span>
                            <span class="text-danger" id="errorId"></span>
                        </div>
                        <div class="mb-3">
                            <form:label class="form-label" path="location">Location <span style="color: red;">*</span></form:label>
                            <form:input type="text" class="form-control" name="location" path="location" id="location"/>
                            <span><form:errors path = "location" cssClass = "text-danger" /></span>
                            <span class="text-danger" id="errorLocation"></span>
                        </div>

                        <div class="mb-3">
                            <form:label class="form-label" path="status">Status <span style="color: red;">*</span></form:label>
                            <form:select class="form-control form-select" path="status" name="status" id="status">
                                <form:option value="Free"/>
                                <form:option value="Busy"/>
                                <form:option value="Active"/>
                                <form:option value="Fix"/>
                            </form:select>
                            <span class="text-danger" id="errorStatus"></span>
                        </div>
                        <button type="submit" class="btn btn-primary" id="btn-add">Add</button>
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
</body>
</html>
