<!DOCTYPE html>
<html>
  <head>
    <title>hello.ftl</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

  </head>
  
  <body>
  	<h1>hello ${user}</h1>
  	<h1>hello ${ok}</h1>
  	
    <#assign score="${score}"?number>
    <#if (score>90)>
    	Great
    	<#elseif (score>85)>
    		Good
    	<#elseif (score>60)>
    			OK
    	<#else>
    			I Think...eh...
    </#if>
    <#assign seq=["bupo","bubai","dongfang"]>
    <#list seq as z>
    	${z}
    	<#if z_has_next>
    		,
    	</#if>
    
    </#list>
    <#assign x=3>
    <#list 1..x as i>
    	${i}
    </#list>
  </body>
</html>
