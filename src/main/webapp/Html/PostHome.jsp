<%@ page import="main.com.zgd.pojo.Post" %>
<%@ page import="main.com.zgd.pojo.ReplyPost" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ViewTW
  Date: 2023-04-11
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>帖子详情</title>
</head>
<%
    Post post = (Post) request.getAttribute("post");
    String username = String.valueOf(request.getAttribute("username"));
    /*List<ReplyPost> replyPostList = (List<ReplyPost>) request.getAttribute("replyPosts");*/
%>
<script src="../js/JqueryExploit.js"></script>
<script src="../js/User.js"></script>
<script>
    $(function () {
        $("#ViewComments").click(function () {
            $("#contentCard").html("<button class='title' id='ViewComments'>"+"查看评论"+"</button>");
            $("#contentCard").append("<span style='font-size: 13px;color: #555555'>功能尚在完善中，点击后不可折叠哦</span>")
            $.get("/ReplyPostByPostId",{"postid":<%=post.getPostId()%>},function (t) {
                if (t[0]==null){
                    alert("帖子没有评论")
                }
                for (let x in t) {
                    let $description = $("<div id='description' class='description'></div>");
                    let replyPostContent;
                    let user;
                    let $reply = $("<button id='reply'>"+"回复"+"</button>");
                    let $send = $("<button id='send' style='display: none;width: 100%;height: 30px'>发送</button>");
                    let $ViewReply = $("<button id='ViewReply'>"+"查看回复"+"</button>");
                    let replyPostId;
                    let userId;
                    let postId;

                    let $ReplyToComments = $("<div class='card' style='display: none'></div>");
                    let $br = $("<br></<br>");
                    let $textarea = $("<textarea id='TextReply'  style='display: none;width: 100%;height: 10%' placeholder='请输入你的回复'></textarea>");
                    for (let i in t[x]) {
                        if (i=="replyPostId"){
                            replyPostId = t[x][i];
                        }
                        if (i == "postId"){
                            postId = t[x][i];
                        }
                        if (i == "userId"){
                            userId = t[x][i];
                        }
                        if (i=="replyPostContent"){
                            replyPostContent = t[x][i];
                        }
                    }

                    $.get("/GetUserName",{"uid":userId},function (username) {
                        user = username[0];
                        $description.append("<span>"+user+"评论了:"+replyPostContent+"</span>").append($ViewReply).append($reply);
                        $description.append("<br></<br>")
                        $description.append($send).append($br).append($textarea)
                        $description.append($ReplyToComments)
                    },"json");


                    $("#contentCard").append($description)

                    //点击回复按钮出现或隐藏发送以及输入框
                    $reply.click(function () {
                        $send.toggle(800)
                        $textarea.toggle(800)
                    })



                    //对评论进行回复
                    $send.click(function () {
                        let content = $textarea.val();
                        $.post("/SendReply",{"content":content,"postId":postId,"replyPostId":replyPostId},function (Result) {
                            let resultElement = Result[0];
                            if (resultElement == "添加成功"){
                                $textarea.val("")
                                $textarea.toggle(800)
                                $send.toggle(800)
                            }
                        },"json")
                    })

                    //查看评论的回复
                    $ViewReply.click(function () {
                        let $description = $("<div id='description' class='description'></div>");
                        $ReplyToComments.toggle(800)
                        $.get("/SearchReplies",{"postId":replyPostId},function (Replies) {
                            console.log(Replies)
                            $ReplyToComments.empty();
                            for (let x in Replies) {
                                let replyPostContent;
                                let userId;
                                for (let i in Replies[x]) {
                                    if (i=="replyPostContent"){
                                        replyPostContent = Replies[x][i];
                                    }
                                    if (i=="userId"){
                                        userId = Replies[x][i];
                                    }
                                }
                                $.get("/GetUserNameById",{"userId":userId},function (Result) {
                                    $description.append("<span>"+Result.username+"回复了:"+replyPostContent+"</span>").append("<br></<br>")
                                    $ReplyToComments.append($description)
                                },"json");
                            }
                        },"json");
                    })

                }
            },"json");
        });
        //回复
        $("#btnReply").click(function (){
            $("#import").toggle(800)
            $("#btnSubmit").toggle(800)
        });


        $("#import").mouseout(function (){
            let val = $("textarea[name=import]").val();
            //清空textarea内容
            if (val.length>0){
                $("#btnSubmit").attr("disabled",false)
            }else {
                $("#btnSubmit").attr("disabled",true)
            }
        })
        $("#btnSubmit").click(function () {
            let val = $("textarea[name=import]").val();
            //清空textarea内容
            $("#contentCard").html("<button class='title'>"+"查看评论"+"</button>");
            $.get("/SendReplyPost",{"value":val,"postid":<%=post.getPostId()%>},function (t) {
                for (let x in t) {
                    let $description = $("<div id='description' class='description'></div>");
                    let replyPostContent;
                    let user;
                    let $reply = $("<button id='reply'>"+"回复"+"</button>");
                    let $send = $("<button id='send' style='display: none;width: 100%;height: 30px'>发送</button>");
                    let $ViewReply = $("<button id='ViewReply'>"+"查看回复"+"</button>");
                    let replyPostId;
                    let userId;
                    let postId;
                    let $ReplyToComments = $("<div class='card' style='display: none'></div>");
                    let $br = $("<br></<br>");
                    let $textarea = $("<textarea id='TextReply'  style='display: none;width: 100%;height: 10%' placeholder='请输入你的回复'></textarea>");
                    for (let i in t[x]) {
                        if (i=="replyPostId"){
                            replyPostId = t[x][i];
                        }
                        if (i == "postId"){
                            postId = t[x][i];
                        }
                        if (i == "userId"){
                            userId = t[x][i];
                        }
                        if (i=="replyPostContent"){
                            replyPostContent = t[x][i];
                        }
                    }
                    $.get("/GetUserName",{"uid":userId},function (username) {
                        user = username[0];
                        $description.append("<span>"+user+"评论了:"+replyPostContent+"</span>").append($ViewReply).append($reply);
                        $description.append("<br></<br>")
                        $description.append($send).append($br).append($textarea)
                        $description.append($ReplyToComments)
                    },"json");
                    $("#contentCard").append($description)

                    //点击回复按钮出现或隐藏发送以及输入框
                    $reply.click(function () {
                        $send.toggle(800)
                        $textarea.toggle(800)
                    })


                    //对评论进行回复
                    $send.click(function () {
                        let content = $textarea.val();
                        $.post("/SendReply",{"content":content,"postId":postId,"replyPostId":replyPostId},function (Result) {
                            let resultElement = Result[0];
                            if (resultElement == "添加成功"){
                                $textarea.val("")
                                $textarea.toggle(800)
                                $send.toggle(800)
                            }
                        },"json")
                    })
                    //查看评论的回复
                    $ViewReply.click(function () {
                        let $description = $("<div id='description' class='description'></div>");
                        $ReplyToComments.toggle(800)
                        $.get("/SearchReplies",{"postId":replyPostId},function (Replies) {
                            console.log(Replies)
                            $ReplyToComments.empty();
                            for (let x in Replies) {
                                let replyPostContent;
                                let userId;
                                for (let i in Replies[x]) {
                                    if (i=="replyPostContent"){
                                        replyPostContent = Replies[x][i];
                                    }
                                    if (i=="userId"){
                                        userId = Replies[x][i];
                                    }
                                }
                                $description.append("<span>"+userId+"回复了:"+replyPostContent+"</span>").append("<br></<br>")
                                $ReplyToComments.append($description)
                            }
                        },"json");
                    })

                }
            },"json");
        });
    })
</script>
<style>
    @import url("../css/user.css");
</style>
<body>
<%@ include file="header.jsp"%>
<div class="content">
    <div class="card">
        <%--<img src="https://via.placeholder.com/300x200.png?text=Image+1" alt="Image 1">--%>
        <div class="title">
            <span>标题:<%=post.getTitle()%></span>
            <span>用户:<%=username%></span>
        </div>
        <div class="description"><%=post.getPostContent()%></div>
        <div class="footer">
            <span>发表时间:<%=post.getPostCreateTime()%></span>
            <span>最近一次更新:<%=post.getPostUpdateTime()%></span>
            <button id="btnReply">回复</button>
        </div>
            <textarea id="import" name="import" style="display: none;width: 100%;height: 20%"></textarea>
            <button id="btnSubmit"  disabled style="display: none;width: 100%;height: 30px">提交</button>
    </div>
    <div class="card" id="contentCard">
        <button class="title" id="ViewComments">查看评论</button><span style="font-size: 13px;color: #555555">功能尚在完善中，点击后不可折叠哦</span>
    </div>
</div>
</body>
</html>
