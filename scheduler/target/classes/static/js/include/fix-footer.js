

 function showPhone(phone){
	//正上方
	 layer.msg('13719490070', {
	   offset: 't',
	   anim: 6
	 });
}
 
 function showWeixin(weixin){
	//示范一个公告层
	 layer.open({
	   type: 1
	   ,title: false //不显示标题栏
	   ,closeBtn: false
	   ,area: '200px;'
	   ,shade: 0.6
	   ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
	   ,resize: false
	   ,btn: ['退出']
	   ,btnAlign: 'c'
	   ,moveType: 1 //拖拽模式，0或者1
	   ,content: '<div class="text-center"><img class="img-responsive"  src="'+weixin+'" /></div>'
	   ,success: function(layero){
	     return;
	   }
	 });
 }


