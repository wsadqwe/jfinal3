<#-- @ftlvariable name="msg" type="java.util.List<String>" -->
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>登录</title>
    <style>
        form {
            display: table;
        }

        form .field{
            display: table-row-group;
        }

        form .cell{
            display: table-cell;
            padding-left: 1em;
        }
    </style>
</head>
<body>
<form action="/loginCheck1" method="post" autocomplete="off">
    <div class="field">
        <div class="cell"><label for="username">用户名</label></div>
        <div class="cell"><input type="text" name="username" id="username" placeholder="请输入用户名" required></div>
    </div>
    <div class="field">
        <div class="cell"><label for="password">密　码</label></div>
        <div class="cell"><input type="password" name="password" id="password" required></div>
    </div>
    <div class="field">
        <div class="cell">
            <input type="submit" value="登录" required>
        </div>
    </div>
<#--    <div class="field">-->
<#--        <div class="cell" style="color: red">${msg}</div>-->
<#--    </div>-->
</form>
</body>
</html>
