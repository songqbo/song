
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <link href="styles/general.css" rel="stylesheet" type="text/css" />
    <link href="styles/main.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
        body
        {
            color: white;
            background: #278296;
            font-size:12px;
        }
    </style>
</head>
<body>
    <form name='theForm' method="post" action="queUse">
    <table cellspacing="0" cellpadding="0" style="margin-top: 100px" align="center">
        <tr>
            <td>
                <img src="images/login.png" width="178" height="256" border="0" alt="ECSHOP" />
            </td>
            <td style="padding-left: 50px">
                <table>
                    <tr>
                        <td>
                            管理员姓名：
                        </td>
                        <td>
                            <input type="text" name="names" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            管理员密码：
                        </td>
                        <td>
                            <input type="password" name="pwd" />
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;
                            
                        </td>
                        <td>
                            <input type="submit" value="进入管理中心" class="button" />
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    </form>
</body>
</html>
