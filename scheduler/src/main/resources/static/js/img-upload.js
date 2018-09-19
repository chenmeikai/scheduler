//对应的标签
//<div class="form-group" style="margin-top: 20px;">
//	<label class="control-label">缩略图</label>
//	<div class="controls">
//		<input type="button" value="上传图片" onclick="f.click()"
//			class="btn_mouseout" /><br/>
//		<p>
//			<input type="file" id="f" name="f" onchange="sc(this);"
//				style="display: none" />
//		</p>
//		<div id="result">
//			<img id="notice-picture" th:src="${product.picture}" class="img-responsive col-sm-4"    />
//		</div>
//	</div>
//</div>

// 上传图片
function sc() {
    var animateimg = $("#f").val(); // 获取上传的图片名 带//
    var imgarr = animateimg.split('\\'); // 分割
    var myimg = imgarr[imgarr.length - 1]; // 去掉 // 获取图片名
    var houzui = myimg.lastIndexOf('.'); // 获取 . 出现的位置
    var ext = myimg.substring(houzui, myimg.length).toUpperCase(); // 切割 .
    var file = $('#f').get(0).files[0]; // 获取上传的文件
    var fileSize = file.size; // 获取上传的文件大小
    var maxSize = 1048576; // 最大1MB
    if (ext != '.PNG' && ext != '.GIF' && ext != '.JPG' && ext != '.JPEG'
        && ext != '.BMP') {
        parent.layer.msg('文件类型错误,请上传图片类型');
        return false;
    } else if (parseInt(fileSize) >= parseInt(maxSize)) {
        parent.layer.msg('上传的文件不能超过1MB');
        return false;
    } else {
        /* var data = new FormData($('#form1')[0]); */
        var folder = $("#upload-file").attr("data-folder")
        var formData = new FormData();
        formData.append("file", file);
        formData.append("folder", folder);
        $.ajax({
            url: "/manager/file/upload.do",
            type: 'POST',
            data: formData,
            dataType: 'JSON',
            cache: false,
            processData: false,
            contentType: false
        }).done(
            function (ret) {
                if (ret['code'] == 200) {
                    var result = '';
                    var result1 = '';
                    // $("#show").attr('value',+ ret['f'] +);
                    result += '<img id="notice-picture" src="'
                        + ret['url'] + '" width="100">';
                    $('#result').html(result);
                } else {
                    parent.layer.msg('上传失败');
                }
            });
        return false;
    }
}


function sc2() {
    var animateimg = $("#f2").val(); // 获取上传的图片名 带//
    var imgarr = animateimg.split('\\'); // 分割
    var myimg = imgarr[imgarr.length - 1]; // 去掉 // 获取图片名
    var houzui = myimg.lastIndexOf('.'); // 获取 . 出现的位置
    var ext = myimg.substring(houzui, myimg.length).toUpperCase(); // 切割 .
    var file = $('#f2').get(0).files[0]; // 获取上传的文件
    var fileSize = file.size; // 获取上传的文件大小
    var maxSize = 1048576; // 最大1MB
    if (ext != '.PNG' && ext != '.GIF' && ext != '.JPG' && ext != '.JPEG'
        && ext != '.BMP') {
        parent.layer.msg('文件类型错误,请上传图片类型');
        return false;
    } else if (parseInt(fileSize) >= parseInt(maxSize)) {
        parent.layer.msg('上传的文件不能超过1MB');
        return false;
    } else {
        /* var data = new FormData($('#form1')[0]); */
        var folder = $("#upload-file2").attr("data-folder")
        var formData = new FormData();
        formData.append("file", file);
        formData.append("folder", folder);
        $.ajax({
            url: "/manager/file/upload.do",
            type: 'POST',
            data: formData,
            dataType: 'JSON',
            cache: false,
            processData: false,
            contentType: false
        }).done(
            function (ret) {
                if (ret['code'] == 200) {
                    var result = '';
                    var result1 = '';
                    // $("#show").attr('value',+ ret['f'] +);
                    result += '<img id="notice-picture2" src="'
                        + ret['url'] + '" width="100">';
                    $('#result2').html(result);
                } else {
                    parent.layer.msg('上传失败');
                }
            });
        return false;
    }
}

