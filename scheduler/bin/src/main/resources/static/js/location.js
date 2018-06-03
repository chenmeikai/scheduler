            
            var map = new BMap.Map("dituContent");          // 创建地图实例
            var point = new BMap.Point(113.286268,23.231233);  // 创建点坐标
            map.centerAndZoom(point, 20);                 // 初始化地图，设置中心点坐标和地图级别
            map.addControl(new BMap.NavigationControl());
            var marker = new BMap.Marker(point);  // 创建标注
            map.addOverlay(marker);               // 将标注添加到地图中
            marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
            map.enableScrollWheelZoom(true);		//允许滚轮缩放
            var opts = {
  				  width : 200,     // 信息窗口宽度
  				  height: 100,     // 信息窗口高度
  				  title : "广州绘声建筑材料有限公司" , // 信息窗口标题
  				  enableMessage:true,//设置允许信息窗发送短息
  				  message:""
  				}

            var infoWindow = new BMap.InfoWindow("地址：广州白云区黄边路63号嘉禾创意园二期C区3栋407室", opts);  // 创建信息窗口对象 
            map.openInfoWindow(infoWindow,point); //开启信息窗口
			marker.addEventListener("click", function(){          
				map.openInfoWindow(infoWindow,point); //开启信息窗口
			});

