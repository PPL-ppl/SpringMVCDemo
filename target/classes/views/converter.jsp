<html>
<head>
    <title>Title</title>
    <script src="assets/jquery.js" type="text/javascript"></script>

</head>
<body>
<script>
    function req() {
        $.ajax({
            url: "convert",
            data: "1-abc", //和converter中处理格式一致
            type: "POST",
            contentType: "application/x-kp", //和控制器一样的mime类型
            success: function (data) {
                $("#resp").html(data);
            }
        });
    }
</script>
</body>
<div id="resp"></div>
<button onclick="req()">测试</button>
</html>