<#-- @ftlvariable name="sysUser" type="nxu.it.pojo.SysUser" -->
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>登录成功</title>
</head>
<body>

<h2>${sysUser.username} 你好, 欢迎登录</h2>
<div>
    <#if sysUser.isAdmin()>
        <p>欢迎尊贵的管理员</p>
    <#else>
        <p>欢迎尊贵的用户</p>
    </#if>

</div>

</body>
</html>