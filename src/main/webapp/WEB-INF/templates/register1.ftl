<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>用户注册</title>
</head>
<body>

<form action="/doRegister1" method="post" autocomplete="off">
    <div class="field">
        <label for="sno">学号</label>
        <input type="text" name="sno" id="sno" placeholder="请输入学号" required pattern="\d{11}">
    </div>
    <div class="field">
        <label for="name">姓名</label>
        <input type="text" name="name" id="name" placeholder="请输入姓名" required>
    </div>
    <div class="field">
        <label for="password">密码</label>
        <input type="password" name="password" id="password" placeholder="请输入密码" required>
    </div>
    <div class="field">
        <label for="department">单位</label>
        <select name="departmentId" id="department" required>
            <option value="">---请选择单位---</option>
            <option value="1">学院1</option>
            <option value="2">学院2</option>
            <option value="3">学院3</option>
        </select>
    </div>
    <div class="field">
        <label for="major">专业</label>
        <input type="text" name="major" id="major" placeholder="请输入专业" required>
    </div>
    <div class="field">
        <label for="grade">年级</label>
        <input type="number" name="grade" id="grade" min="2017" max="2023" value="2022">
    </div>
    <div class="field">
        <label for="mobile">手机</label>
        <input type="text" name="mobile" id="mobile" placeholder="请输入手机号" pattern="\d{11}">
    </div>
    <div>
        <input type="submit" value="注册">
    </div>
</form>

</body>
</html>