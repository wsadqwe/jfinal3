<#-- @ftlvariable name="allCategories" type="java.util.List<nxu.it.pojo.Category>" -->
<#-- @ftlvariable name="post" type="nxu.it.model.Post" -->
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>更新文章</title>
    <style>
        form .title {
            width: 200px;
        }
    </style>
</head>
<body>
<form action="/post/update" method="post" AUTOCOMPLETE="off">
    <input type="hidden" name="id" value="${post.id}">
    <div class="field">
        <label for="title">标题</label>
        <input type="text" name="title" id="title" placeholder="请输入文章标题" class="title" required value="${post.title}">
    </div>
    <div class="field">
        <label for="category">分类</label>
        <select name="category_id" id="category" required>
            <option value="">---请选择分类---</option>
            <#list allCategories as category>
                <option value="${category.id}" ${(post.categoryId == category.id)?string("selected", "")}>${category.name!""}</option>
            </#list>
        </select>
    </div>
    <div class="field">
        <label for="content">内容</label><textarea name="content" id="content" cols="30" rows="10" required>${post.content}</textarea>
    </div>
    <div class="field">
        <input type="submit" value="更新">
    </div>
</form>
</body>
</html>