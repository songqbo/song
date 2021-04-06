<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

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
        <span class="tab-front" id="general-tab">通用信息</span>
      </p>
    </div>

    <!-- tab body -->
    <div id="tabbody-div">
      <form action="addGoods" method="post" name="theForm">
        <!-- 通用信息 -->
          <input type="hidden" name="gid" value="0"/>
        <table width="90%" id="general-table" align="center">
          <tr>
            <td class="label">宿舍名称：</td>
            <td><input type="text" style="float:left;" size="30" name="gname" /></td>
          </tr>
          <tr>
            <td class="label">宿舍地点：</td>
            <td><input type="text" size="30" name="gaddress" /></td>
          </tr>
          <tr>
            <td class="label">宿舍人数：</td>
            <td><input type="text" size="10" name="gpeoples"/></td>
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
