<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${message}</title>
</head>
<body>
<div>
    ${message!""}
    <div>2秒后自动自动返回</div>
    <div><a href="${redirectUrl}">点击立即返回</a> </div>
</div>
</body>
<script>
    let redirectUrl = '${redirectUrl!"/main"}';
    setTimeout(function (){
        window.location.href = redirectUrl;
    }, 2000)
</script>
</html>