﻿/*
License: New BSD License
Date: 2009/3/4
Author: Kim Wang
Email: wxnet2008@gmail.com
version: 1.1.1
*/
(function(){
function progressBar(opt)
{
	opt = opt || {};
	
	this.width = opt.width || 500;
	this.height = opt.height || 20;
	this.color = opt.color || "#B1D632";
	this.progress = opt.progress || 0;
	this.text = opt.text || "";
	this.contentId = opt.contentId;
}

progressBar.prototype = {
	toString : function(){
	var contentDiv = create("div"),mainDiv = create("div"),spanElem = create("span"),
	barDiv = create("div");
	
	append(barDiv,spanElem),append(mainDiv,barDiv),
	append(spanElem,!this.text?range(this.progress,100,0) + "%":this.text),append(contentDiv,mainDiv);

	setCSS([mainDiv], {
		position: "relative",
    		width: this.width + "px",
    		border: "1px solid #B1D632",
    		padding: "1px",
    		height: this.height + "px"
	});

	setCSS([barDiv],{
    		display: "block",
    		position: "relative",
    		background: this.color,
    		color: "#333333",
    		height: this.height + "px",
    		lineHeight: this.height + "px",
    		width: range(this.progress,100,0) + "%"
	});

	setCSS([spanElem], { 
    		position: "absolute",
    		width: this.width + "px",
    		textAlign: "center",
    		fontWeight: "bold"
	});

	return contentDiv.innerHTML.toLowerCase();
	},

	//刷新进度
	setProgress:function(value){
		if(!this.contentId) return;
		this.show();
		
		setCSS([last(last(id(this.contentId)))],{width: range(value,100,0) + "%"});

		//更新显示值
		last(last(last(id(this.contentId)))).innerHTML = range(value,100,0) + "%";

		return value;
		
	},

	show:function(){
		if(!this.contentId) return;
		id(this.contentId).innerHTML = this.toString();
	}
}

function range(value,max,min)
{
	return ((value>max) ? max : ((value < min) ? min : value));
}

nameSpace("progressBar",progressBar);
})();
