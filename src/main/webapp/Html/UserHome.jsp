<%@ page import="main.com.zgd.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: ViewTW
  Date: 2023-04-10
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../js/JqueryExploit.js"></script>
<style>
    @import url("../css/user.css");
    .content {
        border-radius: 10px;
        background-color: #ffffff;
        margin-top: 10px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.5);
    }
    .limit{
        border-radius: 10px;
        align-content: center;
        height: 30px;
    }
    .btnLim{
        display: inline-block;
        margin: 0 3px;
    }
    .pagination li {
        border: 3px solid #ddd;
        border-radius: 3px;
        margin-right: 0px;
    }

</style>

</head>
<body>
<%@ include file="header.jsp"%>
<div class="content" style="height: 550px;overflow: auto">
</div>
<div class="limit" id="limit" style="background-color: #f6f6f6;margin-top: 20px">
</div>
</body>
<script>
    $(function () {
        $(".content").html("<div class='title'>"+"欢迎来到橘子贴吧，以下是一些热门的话题"+"</div>")
        let start = 1;
        let end = 3;
        $.get("/GetPostSize",function (PostSize) {
            let number = parseInt(PostSize);
            for (let i = 0; i < number; i++) {
                let lim = i + 1;
                let $button = $("<button class='btnLim' name='btnLim'>"+lim+"</button>");
                $button.attr("value",i + 1).click(function () {
                    //获取分页按钮的value
                    let val = $(this).val();
                    start = val;
                    $(".content").html("<div class='title'>"+"欢迎来到橘子贴吧，以下是一些热门的话题"+"</div>")
                    $.lim()
                });
                $("#limit").append($button)
            }
        },"text");

        $.lim = function () {
            $.post("/SearchPosts",{"start":start},function (list) {

                console.log(list)
                //如果不等于空说明有数据，则进行便利取值
                if (list!=null){
                    //取出所有下标
                    for(let i in list){
                        let $card = $("<div class='card'></div>")
                        let $description;
                        let $title = $("<div class='title'></div>");
                        let $footer = $("<div class='footer'></div>");
                        let $username;
                        let $spanTime;
                        let postId;
                        for (const x in list[i]) {
                            if (x=="postContent"){
                                $description = $("<div class='description'>"+list[i][x]+"</div>");
                            }
                            if (x=="postCreateTime"){
                                $spanTime = $("<span>"+"发表时间:"+list[i][x]+"</span>")
                            }
                            if (x=="postId"){
                                postId = list[i][x];
                            }
                            if (x=='title'){
                                $title.text("标题:"+list[i][x])
                            }
                            if (x=="userId"){
                                $.get("/GetUserName",{"uid":list[i][x]},function (username) {
                                    console.log(username)
                                    $username = $("<span>"+"用户:"+username+"</span>");
                                },"text");
                            }
                        }
                        let $a = $("<a>"+"查看详情"+"</a>");
                        $a.attr("href","/PostHome?postId="+postId);
                        $footer.append($spanTime).append($a).append($username);
                        $(".content").append($card).append($title).append($username).append($description).append($footer);
                    }
                }
            },"json");
        }
        $.lim();
    })
</script>
</html>
