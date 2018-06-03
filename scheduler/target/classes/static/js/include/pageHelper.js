
$(document).ready(function(){
	
	pagePrevent();    
	
	/**
     * 跳转页面
     */
    $("#slectPage").click(function(){
   	 selectPage();
    })
		 
		  
})	

  //页数尽头添加禁止图标
  function pagePrevent(){
	
	var pageNum = $(".pagination>.active").text();	
	
	var pages   = $("#End").attr("data-pages");
	
	if(pageNum==1){
		$("#Previous").addClass("button-disabled");
		$("#First").addClass("button-disabled");
	}else{
		$("#Previous").removeClass("button-disabled");
		$("#First").removeClass("button-disabled");
	}
	
	if(pageNum==pages){
		$("#Next").addClass("button-disabled");
		$("#End").addClass("button-disabled");
	}else{
		$("#Next").removeClass("button-disabled");
		$("#End").removeClass("button-disabled");
	}	
}

/**
 * 跳转页码
 * @param skipToPage
 * @returns
 */
 function  skipPage(skipToPage){ 
    	 
	    var pageNum = $(".pagination>.active").text();	
		
		var pages   = $("#End").attr("data-pages");
	    
		/**
		 * 判断当前页，是否可以跳转
		 */
		if(pageNum == 0){
			return false ;
		}
		else if(skipToPage>pages||skipToPage<=0){
			return false;
		}
		var pageNum = skipToPage;
		var type=$(".type.active").attr("data-type");
		var url =$("#data-url").attr("data-url");
		
		window.location.href=url+"?type="+type+"&pageNum="+pageNum
					
} 


/**
 * 选择页码
 */          
function selectPage(){
	var targetPage = $("#jumpPage").val();
	var pages   = $("#End").attr("data-pages");
	if(targetPage<=0 || targetPage>pages){
		return false;
	}
	
	var type=$(".type.active").attr("data-type");
	var url =$("#data-url").attr("data-url");
	
	window.location.href=url+"?type="+type+"&pageNum="+targetPage

}	



