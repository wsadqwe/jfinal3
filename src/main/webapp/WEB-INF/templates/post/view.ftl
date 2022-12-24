<#-- @ftlvariable name="post" type="nxu.it.model.Post" -->
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${(post.title)!"查看文章"}</title>
    <style>
        #container {
            width: 960px;
            margin: 50px auto;
        }
        #post-title, #post-meta {
            text-align: center;
        }
        #post-content {
            margin-top: 20px;
            text-indent: 2em;
        }

        .divider {
            border-top: 1px dotted #0ac999;
            margin-top: 10px;
        }
        #post-comment {
            margin-top: 50px;
        }
    </style>
</head>
<body>
    <div id="container">
        <div id="post-title">
            <h3>${(post.title)!""}</h3>
        </div>
        <div id="post-meta">
            作者：${(post.username)!""} &nbsp; &nbsp; 发表时间：${post.createAt?string("yyyy-MM-dd HH:mm:ss")}
        </div>
        <div class="divider"></div>
        <div id="post-content">
            ${(post.content)!""}
        </div>
        <div class="divider"></div>

        <div id="post-comment">
            <form action="/post/comment/save">
                <div class="field">
                    <label for="content">评论内容</label><textarea name="content" id="content" cols="120" rows="5"></textarea>
                </div>
                <div class="field">
                    <input type="submit" value="评论">
                </div>
            </form>
        </div>
    </div>
</body>
</html>