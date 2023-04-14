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
        height: 550px;
        overflow: auto;
    }
    .limit{
        border-radius: 10px;
        align-content: center;
        height: 30px;
    }
    .btnLim{
        width: 20px;
        height: 100%;
    }
    .pagination li {
        border: 3px solid #ddd;
        border-radius: 3px;
        margin-right: 0px;
    }
    .contentTitle{
        border-radius: 10px;
        background-color: #ffffff;
        margin-top: 10px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.5);
        height: 100px;
        overflow: auto;
        padding-left: 10px;
    }
</style>

</head>
<body>
<%@ include file="header.jsp"%>
<div class="contentTitle" id="content" style="margin-bottom: 10px">
</div>
<div class="content">
</div>
<div class="limit" id="limit" style="background-color: #f6f6f6;margin-top: 20px">
</div>
</body>
<script>
    $(function () {
        // 获取ResultPostList
        let data = decodeURIComponent(new URLSearchParams(location.search).get('ResultPostList'));
        console.log(data)
        $("#content").html("<div class='title' style='margin-left: -10px'>"+"欢迎来到橘子贴吧，以下是一些热门的话题"+"</div>");
        $("#content").append("<input type='text' name='search' id='search' placeholder='请输入标题'>");
        $("#content").append("<button type='submit'>搜索</button>");

        $("#search").keyup(function () {
            let SearchValue = $(this).val();

            $.get("/SearchPostByLikeTitle",{"SearchValue":SearchValue},function (ResultPostList) {
                console.log(ResultPostList)
                if (ResultPostList!=null){
                    $(".content").empty()
                    //取出所有下标
                    for(let i in ResultPostList){
                        let $card = $("<div class='card'></div>")
                        let $description;
                        let $title = $("<div class='title'></div>");
                        let $footer = $("<div class='footer'></div>");
                        let $username;
                        let $spanTime;
                        let postId;
                        for (const x in ResultPostList[i]) {
                            if (x=="postContent"){
                                $description = $("<div class='description'>"+ResultPostList[i][x]+"</div>");
                            }
                            if (x=="postCreateTime"){
                                $spanTime = $("<span>"+"发表时间:"+ResultPostList[i][x]+"</span>")
                            }
                            if (x=="postId"){
                                postId = ResultPostList[i][x];
                            }
                            if (x=='title'){
                                $title.text("标题:"+ResultPostList[i][x])
                            }
                            if (x=="userId"){
                                $.get("/GetUserName",{"uid":ResultPostList[i][x]},function (username) {
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
        });

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
                    $.lim()
                });
                $("#limit").append($button)
            }
        },"text");

        $.lim = function () {
            $.post("/SearchPosts",{"start":start},function (list) {
                $(".content").empty()
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
