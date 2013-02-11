<%@ page contentType="text/html"%>
<html>
<head></head>
<body style="color:#666">
<table height="100%" width="100%" cellpadding="50" bgcolor="#e9e9e9">
<tbody>
<tr valign="top">
<td>
<table width="590" cellpadding="25" bgcolor="#ffffff" align="center">
<tbody>
<tr>
<td>
<div style="color:#fff; border-bottom: 1px solid rgb(204, 204, 204); background-color: #000; padding: 10px;">${meta(name: 'app.name')}</div>
<br>
<p style="font-size: 10pt; font-family: Arial; color:#666; margin-bottom:13px">Hello <b>${user.fullName.split()[0].encodeAsHTML()}</b>,</p>
<p style="font-size: 10pt; font-family: Arial; color:#666; margin-bottom:13px">Congratulations!
You've successfully set up your ${meta(name: 'app.name')} account.<br>

<br>
<p style="border-top: 1px solid rgb(204, 204, 204); font-size: 8pt; color: rgb(128, 128, 128); padding-top: 10px; font-family: Arial; text-align: center; margin:10px 0">
Didn't register? Please <a href="mailto:support@${meta(name: 'app.name')}.com">let us know</a>.
</p>
<p style="font-size: 8pt; color: #999; padding-top: 0px; margin-bottom: 0px; font-family: Arial; text-align: center;">
Company, Inc.
</p>

</td>
</tr>
</tbody>
</table>
</td>
</tr>
</tbody>
</table>
</body>
</html>
