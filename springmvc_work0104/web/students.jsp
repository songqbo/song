<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title></title>
    <link href="styles/general.css" rel="stylesheet" type="text/css" />
    <link href="styles/main.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
        td
        {
          text-align:center;
        }
        th
        {
           font-weight:bold;
        }
    </style>

</head>

<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript">
    $(function () {

        //点击删除
       $(".delId").click(function(){
           let stuid = $(this).prop("id");
           let stu = this;
           let b = window.confirm("是否确认删除");
           if(b){
               $.ajax({
                   url:'delStu?id='+stuid,
                   type:'get',
                   success:function(data){
                       if (data == 'success'){
                               $("#"+stuid).remove();
                       }
                   }
               });
           }

       })

        //多选
       $("#allCheck").change(function () {
           let che = $(this).prop("checked");
           if (che==true ) {
               $(".check").prop("checked", true);
           }
           if (che==false) {
               $(".check").prop("checked", false);
           }
       })
        $(".check").change(function () {
             let ische=true;
            $(".check").each(function () {
                let che = $(this).prop("checked");
                if (che!=true){
                    ische=false;
                }
                if (ische==true) {
                    $("#allCheck").prop("checked", true);
                }
                else {
                    $("#allCheck").prop("checked", false);
                }
            })

        })



        //将选中的删除
        $("#delmuch").click(function () {
            //定义数组存储选中的值
            let  arr=[];
            $(":checkbox:gt(0):checked").each(function () {
                 val = $(this).val();
                 arr.push(val);

            })
            $.post({
                url:"delmuch",
                data:{mid : arr.toString()},
                success:function (data) {
                    if(data=="success"){
                        for (let i = 0;i < arr.length ; i++) {
                            $("."+arr[i]).remove();
                        }
                    }
                }
            })
        })
    })

</script>
<body>
    <div class="form-div">
        <form action="queMany" name="searchForm">
            ${array}
        学生名（支持模糊查询）
        <input type="text" name="names" size="15" value="${names}"/>
		年龄
		<input type="text" name="min" size="5" value="${min}" /> 到
		<input type="text" name="max" size="5" value="${max}"/>
		宿舍
		<select name="gname">
			<option value="">请选择</option>
		    <c:forEach items="${glist}" var="g">
                <option value="${g.gid}"> ${g.gname}</option>
            </c:forEach>
		</select>
        <input type="submit" value=" 搜索 " class="button" />
        </form>
    </div>

    <form method="post" action="" name="listForm">
    <!-- start goods list -->
    <div class="list-div" id="listDiv">
        <table cellpadding="3" cellspacing="1">
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>宿舍</th>
                <th>操作</th>
                <th>多选<input type="checkbox" id="allCheck"/><input value="执行删除" type="button" id="delmuch"/> </th>
            </tr>

            <c:forEach items="${slist}" var="s">
            <tr class="${s.sid}" id="${s.sid}">
                <td>${s.sid}</td>
                <td align=left>${s.sname}</td>
                <td><span>${s.ssex}</span></td>
                <td align="right"><span>${s.sage}</span></td>
                <td>${s.goods.gname}</td>
                <td align="center">
                    <a title="回收站" class="delId" id="${s.sid}">
                        <img src="images/icon_trash.gif" width="16" height="16" border="0" />
                    </a>
                </td>
                <th><input type="checkbox" class="check" name="num" value="${s.sid}"/></th>
            </tr>
            </c:forEach>

        </table>
    </div>
    </form>
</body>
</html>
