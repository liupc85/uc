<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>小麦统一登录系统</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="stylesheet" type="text/css" href="/static/css/demo.css" />
        <link rel="stylesheet" type="text/css" href="/static/css/style.css" />
		<link rel="stylesheet" type="text/css" href="/static/css/animate-custom.css" />
    </head>
    <body>
        <div class="container">
            <!-- Codrops top bar -->
            <div class="codrops-top">
                <a href="">
                    <strong>小麦统一登录系统，如有问题请联系管理员	
                </a>
                <span class="right">
                    <a href=" ">
                        <strong>帮助／集成文档</strong>
                    </a>
                </span>
             <div class="clr"></div>
            </div><!--/ Codrops top bar -->
            </br>
      		</br>
            <header>
                <h1>登录系统之前，请仔细阅读以下说明</span></h1>
				<nav class="codrops-demos">
					<span>请依次点击阅读</span>
					<a href="" class="current-demo">说明1</a>
					<a href="">说明2</a>
					<a href="">说明3</a>
				</nav>
            </header>
            </br>
            </br>
            </br>
            </br>
            <section>				
                <div id="container_demo" >
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form  action="/login/ssoLogin"  method="post" > 
                            	 <input type="hidden" name="APP_NAME" value="${APP_NAME}" class="initialized">
                            	 <input type="hidden" name="BACK_URL" value="${BACK_URL}" class="initialized">
                            	 <input type="hidden" name="SSO_TOKEN" value="${SSO_TOKEN}" class="initialized"> 
                            	  
                                <h1>登录</h1> 
                                <p> 
                                    <label for="username" class="uname" data-icon="u" > 用户名邮箱 </label>
                                    <input id="username" name="username" required="required" value ="123" type="text" placeholder="如wendeliang@imxiaomai.com"/>
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd" data-icon="p"> 密码 </label>
                                    <input id="password" name="password" required="required" value ="123" type="password" placeholder="密码" /> 
                                </p>
                                <font color="#ff0000">${codeMessage}</font>
                                <!--
                                <p class="keeplogin"> 
									<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" /> 
									<label for="loginkeeping">记住我</label>
								</p>
								
								-->
                                <p class="login button"> 
                                    <input type="submit" value="登录" /> 
								</p>
                                <p class="change_link">
									没有用户 ? 联系管理员添加
									<!--
									<a href="#toregister" class="to_register">点击这里注册</a>
									-->
								</p>
                            </form>
                        </div>
						<!-- 注册代码先注释掉，以后如果需要我们在开放
                        <div id="register" class="animate form">
                            <form  action="mysuperscript.php" autocomplete="on"> 
                                <h1> Sign up </h1> 
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">Your username</label>
                                    <input id="usernamesignup" name="usernamesignup" required="required" type="text" placeholder="mysuperusername690" />
                                </p>
                                <p> 
                                    <label for="emailsignup" class="youmail" data-icon="e" > Your email</label>
                                    <input id="emailsignup" name="emailsignup" required="required" type="email" placeholder="mysupermail@mail.com"/> 
                                </p>
                                <p> 
                                    <label for="passwordsignup" class="youpasswd" data-icon="p">Your password </label>
                                    <input id="passwordsignup" name="passwordsignup" required="required" type="password" placeholder="eg. X8df!90EO"/>
                                </p>
                                <p> 
                                    <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">Please confirm your password </label>
                                    <input id="passwordsignup_confirm" name="passwordsignup_confirm" required="required" type="password" placeholder="eg. X8df!90EO"/>
                                </p>
                                <p class="signin button"> 
									<input type="submit" value="Sign up"/> 
								</p>
                                <p class="change_link">  
									Already a member ?
									<a href="#tologin" class="to_register"> Go and log in </a>
								</p>
                            </form>
                        </div>
						-->
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>