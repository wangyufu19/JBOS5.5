/**
 * JBOS 1.0
 * author youfu.wang
 * version 1.0
 * created 2015-08-20
 */

CreateJSPath=function(js){
	var scripts=document.getElementsByTagName("script");
	var path="";
	for(var i=0,l=scripts.length;i<l;i++){
		var src=scripts[i].src;
		if(src.indexOf(js)!=-1){
			var ss=src.split(js);
			path=ss[0];
			break;
		}
	}

	var href=location.href;
	href=href.split("#")[0];
	href=href.split("?")[0];
	var ss=href.split("/");
	ss.length=ss.length-1;
	href=ss.join("/");
	if(path.indexOf("https:")==-1&&path.indexOf("http:")==-1&&path.indexOf("file:")==-1&&path.indexOf("\/")!=0){
		path=href+"/"+path;
	}
	return path;
}
function getContextPath(){
	var contextPath = document.location.pathname;
	var index =contextPath.substr(1).indexOf("/");
	contextPath = contextPath.substr(0,index+1);
	delete index;
	return contextPath;
}
var JSPath=CreateJSPath("jbos.js");
var contextPath=getContextPath();