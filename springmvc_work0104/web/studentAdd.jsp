<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <link href="styles/general.css" rel="stylesheet" type="text/css" />
    <link href="styles/main.css" rel="stylesheet" type="text/css" />
</head>
<body>

<!-- start goods form -->
<div class="tab-div">
    <!-- tab bar -->
    <div id="tabbar-div">
      <p>
        <span class="tab-front" id="general-tab">通用信息</span><span
      </p>
    </div>

    <!-- tab body -->
    <div id="tabbody-div">
      <form action="addStu" method="post" name="theForm">
        <!-- 通用信息 -->
        <table width="90%" id="general-table" align="center">
          <tr>
            <td class="label">姓名：</td>
            <td><input type="text" style="float:left;" size="30" name="sname"/></td>
          </tr>
          <tr>
            <td class="label">性别：</td>
            <td><input type="radio" name="ssex" value="男"/>男&nbsp;
                <input type="radio" name="ssex" value="女"/>女</td>
          </tr>
          <tr>
            <td class="label">年龄：</td>
            <td><input type="text" size="10" name="sage"/></td>
          </tr>
          <tr>
            <td class="label">宿舍：</td>
            <td>
            	<select name="goods.gid">
                    <c:forEach items="${glist}" var="g">
                        <option value="${g.gid}">
                           ${g.gname}
                        </option>
                    </c:forEach>
                </select>
            </td>
          </tr>
        </table>
        <div class="button-div">
          <input type="submit" value=" 确定 " class="button" />
          <input type="reset" value=" 重置 " class="button" />
        </div>
      </form>
    </div>
</div>
</body>
</html>
