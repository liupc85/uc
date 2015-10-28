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
                            <form  action="/codis/removeCache"  method="post" > 
                                <h1>清除缓存</h1> 
                                <p> 
                                    <label for="username" class="uname" data-icon="u" > 记录主键（即id）</label>
                                    <input id="key" name="key" required="required" type="text" placeholder="主键"/>
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd" data-icon="p"> 类型 </label>
                                    <input name ="cacheType" id="cacheType" type="radio" value="1">user</input>
                                    <input name ="cacheType" id="cacheType" type="radio" value="2">wx_bind_user</input> 
                                </p>
                                <p class="login button"> 
                                    <input type="submit" value="清除" /> 
								</p>
                                 
                            </form>
                        </div>
	
	
	
</body>
</html>