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
	            <form  action="/wxbind/unbind"  method="post" > 
	                <h1>解绑</h1> 
	                <p> 
	                    <label  class="uname" data-icon="u" > 手机号</label>
	               		<textarea id="mobilePhone" name="mobilePhone" rows="10" cols="100" wrap="true" >请在此处输入手机号 以英文,分割</textarea> 
	                </p>
	                <p class="login button"> 
	                    <input type="submit" value="解绑" /> 
					</p>
	            </form>
	        </div>
	   </div>
	</div>
	
	
</body>
</html>