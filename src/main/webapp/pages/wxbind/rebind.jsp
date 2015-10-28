<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en" xmlns:fb="http://www.facebook.com/2008/fbml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body id="homepage" class="layout-landing" ryt12909="1">
	<div id="container_demo" >
	    <a class="hiddenanchor" id="toregister"></a>
	    <a class="hiddenanchor" id="tologin"></a>
	    <div id="wrapper">
	        <div id="login" class="animate form">
	            <form  action="/wxbind/rebind"  method="post" > 
	                <h1><center>更换手机号，只能操作未解绑的数据，已经解绑需重新绑定后再修改</center></h1>
	                <h1><center>只是解绑账号，请到解绑页面进行操作</center></h1>
	                <br>
	                <p> 
	                    <label  class="uname" data-icon="u" > 原手机号</label>
	                    <input id="oldPhone" name="oldPhone" required="required"  type="text" placeholder="原手机号"/>
	                </p>
	                <p> 
	                    <label  class="uname" data-icon="u" > 新手机号</label>
	                     <input id="newPhone" name="newPhone" required="required"  type="text" placeholder="新手机号"/>
	                </p>
	                <p class="login button"> 
	                    <input type="submit" value="更换手机号" /> 
					</p>
	            </form>
	        </div>
	   </div>
	</div>
	
	
</body>
</html>