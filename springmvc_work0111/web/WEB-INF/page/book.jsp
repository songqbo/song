<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>网站信息</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  
</head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">

   $(function () {
     //点击删除进行ajax删除
      $(".button-group:eq(0)").click(function () {
           let id = $(this).prop("id");
           $.ajax({
               url:"delBook?id="+id,
               success:function (data) {
                 if (data=='success'){
                   $("#"+id).remove();
                 }
               }
           })
      })
   })
</script>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"> 图书列表</strong></div>
  <div class="padding border-bottom">  
  <a class="button border-yellow" href=""><span class="icon-plus-square-o"></span>添加图书</a>
  </div> 
  <table class="table table-hover text-center">
    <tr>
      <th width="5%">ID</th>     
      <th>图书名称</th>  
      <th>作者</th>
	  <th>科目</th>
	  <th>价格</th>
      <th>图片</th>
      <th width="250">操作</th>
      <th width="250">文件下载</th>

    </tr>

    <c:forEach items="${blist}" var="b">
    <tr id="${b.bid}">
      <td>${b.bid}</td>
      <td>${b.bname}</td>
      <td>${b.bauthor}</td>
	  <td>${b.wCategory.cname}</td>
	  <td>${b.bprice}</td>
      <td>${b.bpicname}</td>
      <td>
      <div class="button-group" id="${b.bid}">
       <a class="button border-red" ><span  class="icon-trash-o"></span> 删除</a>
      </div>
      </td>
      <td>
        <div class="button-group" >
        <a class="button border-red" href="download?oldname=${b.bpicname}&newname=${b.bpictime}">
          <span  class="icon-trash-o"></span> 下载</a>
        </div>
      </td>
    </tr>
    </c:forEach>
  </table>
</div>
<div class="panel admin-panel margin-top">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加图书</strong></div>
  <div class="body-content">
    <form method="post" enctype="multipart/form-data" class="form-x" action="addBook">
      <div class="form-group">
        <div class="label">
          <label>图书名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="bname"  data-validate="required:请输入图书名称" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>作者：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="bauthor"  data-validate="required:请输入作者名称" />
          <div class="tips"></div>
        </div>
      </div> 
	  <div class="form-group">
        <div class="label">
          <label>科目：</label>
        </div>
        <div class="field">
          <select class="input w50" name="wCategory.cid">
			<option>--请选择科目--</option>
            <c:forEach items="${clist}" var="c">
			<option value="${c.cid}" >${c.cname}</option>
            </c:forEach>
		  </select>        
          <div class="tips"></div>
        </div>
      </div> 
	  <div class="form-group">
        <div class="label">
          <label>价格：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="bprice"  data-validate="required:请输入图书价格" />
          <div class="tips"></div>
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label>图片上传：</label>
        </div>
        <div class="field">
          <input type="file" class="input w50" name="files" />
          <div class="tips"></div>
        </div>
      </div>

     <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body></html>