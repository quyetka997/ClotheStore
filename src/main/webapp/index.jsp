<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 6/27/2020
  Time: 7:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>API</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script>
    $(document).ready(function () {
        var data = {
            userName: "quyetka",
            passWord: "123"
        };

        console.log(data);

        $.ajax({
            type: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url: "/user",
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (msg) {
                console.log("successful");
                if (msg) {
                    console.log("Somebody was added in list !");
                } else {
                    console.log("Cannot add to list !");
                }
            },
            error: function (error) {
                console.log("error");
                console.log(error.toString());
            }
        });
    })
</script>
<body>

</body>
</html>
