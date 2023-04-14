<%--
  Created by IntelliJ IDEA.
  User: ViewTW
  Date: 2023-04-12
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人主页</title>
</head>
<script src="../js/JqueryExploit.js"></script>
<style>
    @import url("../css/user.css");
    #PC{
        margin-top: 50px;
    }
</style>
<body>
<%--页面头部--%>
<%@ include file="header.jsp"%>
<div class="content">
    <div class="card" id="DivReplyPost" style="display: none">
        <div class="description">
            <div class="title" >标题:</div>
            <textarea id="PostTitle" style="width: 100%;height: 8%;padding: 10px;font-size: 25px" placeholder="标题"></textarea>
            <div class="title">内容:</div>
            <textarea id="PostContent" style="width: 100%;height: 30%;padding: 10px;font-size: 15px" placeholder="请输入你的内容..."></textarea>
            <button id="SendPost" type="submit" style="background-color: #ff9900;width: 100%;height: 5%;padding: 10px;">发送</button>
        </div>
    </div>
    <div class="card" id="card">
        <div class="title">用户名:<%=session.getAttribute("username") == null ? "":session.getAttribute("username")%></div>
        <span id="PC" style="margin-left: 2%"><b>个人简介:</b></span>
        <div class="description">暂无</div>
        <div class="footer">
            <span><b>创建日期:</b><%=session.getAttribute("createTime") == null ? "":session.getAttribute("createTime")%></span>
            <button id="CreatePost" type="submit" style="background-color: #ff9900">发帖</button>
        </div>
        <div class="title"><span>已发布的帖子:</span></div>
    </div>
</div>
</body>
<script>
    $(function () {
        $.get("/GetPostByUserId",function (postById) {
            for (let i in postById) {
                let $title = $("<div class='title'></div>");//标题名称
                let $description;//帖子内容
                let $footer = $("<div class='footer'></div>");//创建时间和查看详情
                let $spanTime;
                let postId;
                $("<div></div>")
                for (let x in postById[i]) {
                    //取内容
                    if (x=="postContent"){
                        $description = $("<div class='description'>"+postById[i][x]+"</div>");
                    }
                    //取创建时间
                    if (x=="postCreateTime"){
                        $spanTime = $("<span>"+"发表时间:"+postById[i][x]+"</span>")
                    }
                    //取帖子id
                    if (x=="postId"){
                        postId = postById[i][x];
                    }
                    //取标题
                    if (x=='title'){
                        $title.text("标题:"+postById[i][x])
                    }
                }
                let $a = $("<a>"+"查看详情"+"</a>");
                $a.attr("href","/PostHome?postId="+postId);
                let $card = $("<div class='card'></div>");
                $footer.append($spanTime).append($a)
                $card.append($title).append($description).append($footer);
                $("#card").append($card)
            }
        },"json")
        $("#CreatePost").click(function () {
            $("#DivReplyPost").toggle(800)
        })
        $("#SendPost").click(function () {
            let PostTitle = $("#PostTitle").val();
            let PostContent = $("#PostContent").val();
            if (PostTitle == null || PostTitle == ""){
                alert("标题不能为空")
                return;
            }
            if (PostContent == null || PostContent == ""){
                alert("内容不能为空");
                return;
            }
            $.post("/SendPost",{"PostTitle":PostTitle,"PostContent":PostContent},function (result) {
                alert(result[0])
                location.reload();
            },"json")
        })
    })
</script>
</html>
