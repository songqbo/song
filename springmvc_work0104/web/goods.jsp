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
<body>
    <form method="post" action="" name="listForm">
    <!-- start goods list -->
    <div class="list-div" id="listDiv">
        <table cellpadding="3" cellspacing="1">
            <tr>
                <th>编号</th>
                <th>宿舍名</th>
                <th>宿舍地点</th>
                <th>宿舍人数</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${glist}" var="g">
                <tr>
                    <td>${g.gid}</td>
                    <td align=left>${g.gname}</td>
                    <td><span>${g.gaddress}</span></td>
                    <td align="right"><span>${g.gpeoples}</span></td>
                    <td align="center">
                        <a href="queById?id=${g.gid}" title="编辑">
                            <img src="images/icon_edit.gif" width="16" height="16" border="0" />
                        </a>
                    </td>
                </tr>
            </c:forEach>


        </table>
    </div>
    </form>
</body>
</html>
