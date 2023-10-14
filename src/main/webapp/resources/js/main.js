const regexIdCus = /^KH\d{5}$/
const regexPhone = /^090|091|8490|8491\d{7}$/
const regexEmail = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/
const regexNumber = /^\d*\.?\d+$/
const regexIdSer = /^DV\d{3}$/

function validCustomer() {

    let valueId = document.getElementById("id").value;
    let valueName = document.getElementById("name").value;
    let valueAddress = document.getElementById("address").value;
    let valuePhone = document.getElementById("phone").value;
    let valueEmail = document.getElementById("email").value;

    let isValid = true;

    if(!valueId) {
        document.getElementById("errId").innerHTML = "Code is required";
        isValid = false;
    } else {
        if(!regexIdCus.test(valueId)) {
            document.getElementById("errId").innerHTML = "Code is incorrect format";
            isValid = false;
        } else {
            document.getElementById("errId").innerHTML = "";
        }
    }
    if(!valueName) {
        document.getElementById("errName").innerHTML = "name is required";
        isValid = false;
    } else {
        document.getElementById("errName").innerHTML = "";
    }
    if(!valueAddress) {
        document.getElementById("errAddress").innerHTML = "address is required";
        isValid = false;
    } else {
        document.getElementById("errAddress").innerHTML = "";
    }
    if(!valuePhone) {
        document.getElementById("errPhone").innerHTML = "phone is required";
        isValid = false;
    } else {
        if(!regexPhone.test(valuePhone)) {
            document.getElementById("errPhone").innerHTML = "phone is incorrect format!";
            isValid = false;
        } else {
            document.getElementById("errPhone").innerHTML = "";
        }
    }
    if(!valueEmail) {
        document.getElementById("errEmail").innerHTML = "email is required";
        isValid = false;
    } else {
        if(!regexEmail.test(valueEmail)) {
            document.getElementById("errEmail").innerHTML = "Email is incorrect format";
            isValid = false;
        } else {
            document.getElementById("errEmail").innerHTML = "";
        }
    }

    return isValid;
}

function validDevice() {
    let isValid = true;

    let idValue = document.getElementById("id").value;
    let locationValue = document.getElementById("location").value;
    let statusValue = document.getElementById("status").value;

    if(!idValue) {
        document.getElementById("errorId").innerHTML = "Code is required";
        isValid = false;
    } else {
        document.getElementById("errorId").innerHTML = "";
    }
    if(!locationValue) {
        document.getElementById("errorLocation").innerHTML = "Location is required";
        isValid = false;
    } else {
        document.getElementById("errorLocation").innerHTML = "";
    }
    if(!statusValue) {
        document.getElementById("errorStatus").innerHTML = "Status is required";
        isValid = false;
    } else {
        document.getElementById("errorStatus").innerHTML = "";
    }

    return isValid;
}

function validService() {

    let isValid = true;

    let valueId = document.getElementById("id").value;
    let valueName = document.getElementById("name").value;
    let valueUnit = document.getElementById("unit").value;
    let valuePrice = document.getElementById("price").value;



    if(!valueId) {
        document.getElementById("errorId").innerHTML = "Code is required";
        isValid = false;
    } else {
        if(!regexIdSer.test(valueId)) {
            document.getElementById("errorId").innerHTML = "Code is incorrect format";
            isValid = false;
        } else {
            document.getElementById("errorId").innerHTML = "";
        }
    }
    if(!valueName) {
        document.getElementById("errorName").innerHTML = "Name is required";
        isValid = false;
    } else {
        document.getElementById("errorName").innerHTML = "";
    }
    if(!valueUnit) {
        document.getElementById("errorUnit").innerHTML = "Unit is required";
        isValid = false;
    } else {
        document.getElementById("errorUnit").innerHTML = "";
    }
    if(!valuePrice) {
        document.getElementById("errorPrice").innerHTML = "Price is required";
        isValid = false;
    } else {
        if(!regexNumber.test(valuePrice)) {
            document.getElementById("errorPrice").innerHTML = "Price is incorrect format";
            isValid = false;
        } else {
            document.getElementById("errorPrice").innerHTML = "";
        }
    }


    return isValid;

}