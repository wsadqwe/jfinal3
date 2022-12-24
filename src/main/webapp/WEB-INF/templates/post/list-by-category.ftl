<#-- @ftlvariable name="postPage" type="com.jfinal.plugin.activerecord.Page<nxu.it.model.Post>" -->
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>分类查看</title>
    <style>
        table#post-list{
            border: 1px solid #b8b1b8;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #b8b1b8;
        }
    </style>
</head>
<body>

    <#if session?? && session.user??>
        <div>
            <a href="/post/publish">发表文章</a>
        </div>
    </#if>

    <table id="post-list">
        <tr>
            <th>ID</th>
            <th style="width: 600px">标题</th>
            <th>作者</th>
            <th>发表时间</th>
            <th style="width: 100px; text-align: center">操作✏</th>
        </tr>
        <#list postPage.list as post>
            <tr>
                <td>${post_index + 1}</td>
                <td><a href="/post/view/${post.id}">${post.title}</a></td>
                <td>${post.username}</td>
                <td>${post.createAt?string("yyyy-MM-dd HH:mm:ss")}</td>
                <td style="width: 100px; text-align: center">
                    <#if session?? &&  session.user?? && session.user.username == post.username>
                        <a href="/post/edit/${post.id}"> 编辑 </a>|
                        <a href="#" onclick="deletePost(${post.id})">删除</a>
                    </#if>
                </td>
            </tr>
        </#list>
        <#if postPage.totalRow == 0>
            <td colspan="5" style="text-align: center;">当前分类下暂无文章</td>
        </#if>
    </table>
    <div>
        <#if !postPage.firstPage>
            <span><a href="?page=${postPage.pageNumber - 1}">上一页</a></span>
        </#if>
        <span>第${postPage.pageNumber}页 / 共${postPage.totalPage}页</span>
        <#if !postPage.lastPage>
            <span><a href="?page=${postPage.pageNumber + 1}">下一页</a></span>
        </#if>
    </div>
</body>

<script>
    function deletePost(id) {
        if(confirm("您确定要删除这篇文章吗?")) {
            window.location.href="/post/delete/" + id;
        }
    }
</script>
</html>