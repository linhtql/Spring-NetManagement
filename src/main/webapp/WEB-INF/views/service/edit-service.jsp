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
    <jsp:include page="../../common/header.jsp"/>

    <div class="container" style="margin-top: 130px;">
        <h3>Edit Service</h3>
        <div class="row" style="margin-top: 50px;">
            <div class="col-6">
                <section>
                    <form:form name="myForm" method="post" action="" modelAttribute="service" onsubmit="return validService()">
                        <div class="mb-3 ">
                            <form:label class="form-label" path="id">Code Service<span style="color: red;">*</span></form:label>
                            <form:input type="text" class="form-control" name="id" path="id" disabled="true"/>
                        </div>
                        <div class="mb-3">
                            <form:label class="form-label" path="name">Name <span style="color: red;">*</span></form:label>
                            <form:input type="text" class="form-control" name="name" path="name" />
                            <span><form:errors path = "name" cssClass = "text-danger" /></span>
                            <span class="text-danger" id="errorName"></span>
                        </div>
                        <div class="mb-3">
                            <form:label class="form-label" path="unit">Unit <span style="color: red;">*</span></form:label>
                            <form:select class="form-control form-select" path="unit" name="unit" id="unit">
                                <form:option value="VND"/>
                                <form:option value="USD"/>
                            </form:select>
                            <span class="text-danger" id="errorUnit"></span>
                        </div>
                        <div class="mb-3">
                            <form:label class="form-label" path="price">Price <span style="color: red;">*</span></form:label>
                            <form:input type="text" class="form-control" name="price" path="price" />
                            <span><form:errors path = "price" cssClass = "text-danger" /></span>
                            <span class="text-danger" id="errorPrice"></span>
                        </div>
                        <button type="submit" class="btn btn-primary" id="btn-add">Update</button>
                        <button  class="btn btn-primary" id="btn-add" onclick="location.href ='list-device'">Cancel</button>
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
