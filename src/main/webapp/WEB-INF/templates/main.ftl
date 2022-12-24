<#-- @ftlvariable name="sysUser" type="nxu.it.pojo.SysUser" -->
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>首页</title>
</head>
<body>

<h2>${sysUser.username} 你好, 欢迎再次访问</h2>
<div>
    <#if sysUser.isAdmin()>
        <p>啥也没有</p>
    <#else>
        <p>这是你能看的吗? 管理员才能看到</p>
    </#if>

</div>

</body>
</html>
