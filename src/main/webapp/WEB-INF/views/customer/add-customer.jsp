<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="label" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <title>Create Device</title>

</head>
<body>

<div id="root">
    <jsp:include page="../../common/header.jsp"/>

    <div class="container" style="margin-top: 130px;">
        <h3>Add Customer</h3>
        <div class="row" style="margin-top: 50px;">
            <div class="col-6">
                <section>
                    <form:form name="myForm" method="post" action="add-customer" modelAttribute="customer" onsubmit="return validCustomer()">
                        <div class="mb-3 ">
                            <form:label class="form-label" path="id">Code Customer<span style="color: red;">*</span></form:label>
                            <form:input type="text" class="form-control" name="id" path="id"/>
                            <span><form:errors path = "id" cssClass = "text-danger" /></span>
                            <span class="text-danger" id="errId"></span>
                        </div>
                        <div class="mb-3">
                            <form:label class="form-label" path="name">Name <span style="color: red;">*</span></form:label>
                            <form:input type="text" class="form-control" name="name" path="name"/>
                            <span><form:errors path = "name" cssClass = "text-danger" /></span>
                            <span class="text-danger" id="errName"></span>
                        </div>
                        <div class="mb-3">
                            <form:label class="form-label" path="address">Address <span style="color: red;">*</span></form:label>
                            <form:input type="text" class="form-control" name="address" path="address"/>
                            <span><form:errors path = "address" cssClass = "text-danger" /></span>
                            <span class="text-danger" id="errAddress"></span>
                        </div>
                        <div class="mb-3">
                            <form:label class="form-label" path="phone">Phone <span style="color: red;">*</span></form:label>
                            <form:input type="text" class="form-control" name="phone" path="phone"/>
                            <span><form:errors path = "phone" cssClass = "text-danger" /></span>
                            <span class="text-danger" id="errPhone"></span>
                        </div>
                        <div class="mb-3">
                            <form:label class="form-label" path="email">Email <span style="color: red;">*</span></form:label>
                            <form:input type="text" class="form-control" name="email" path="email"/>
                            <span><form:errors path = "email" cssClass = "text-danger" /></span>
                            <span class="text-danger" id="errEmail"></span>
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

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
<script>
    $(document).ready(function() {
        $('#id').on('blur', function() {
            var code = $(this).val();
            $.ajax({
                url: 'check-customer-code',
                type: 'GET',
                data: {
                    code: code
                },
                success: function(result) {
                    if (result === 'exists') {
                        $('#errId').text('Mã khách hàng đã tồn tại trong hệ thống');
                    } else {
                        $('#errId').text('');
                    }
                },
                error: function() {
                    console.log('Error occurred');
                }
            });
        });
    });
</script>
</body>
</html>
