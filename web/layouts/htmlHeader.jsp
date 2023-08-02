 <% String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
<head>
	<base href="<%=basePath%>"/>
	<title>SmartBPM main page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="Smart Business Process Management,Smart BPM,Brevissimus Co. Smart BPM">
	<meta http-equiv="description" content="Brevissimus Co. BPM">
	<meta http-equiv="content-type" content="text/html; charset=iso-8859-2" />
	<style media="all" type="text/css">@import "css/all.css";</style>
</head>