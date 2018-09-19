$().ready(function () {

    //提交留言
    $("#contact-submit").on("click", function () {

        var name = $("#contact-name").val();
        var email = $("#contact-email").val();
        var phone = $("#contact-phone").val();
        var content = $("#contact-content").val();

        //非空判断
        if (email.length == 0 && phone.length == 0) {
            layer.msg('请填写一项联系方式');
            return;
        }
        $.ajax({
            url: "/message",
            type: "POST",
            data: {
                name: name,
                email: email,
                phone: phone,
                content: content
            },
            success: function (data) {
                layer.msg(data['desc']);
            },
            error: function () {
                layer.msg("抱歉，留言貌似失败了");
            }
        })


    })

});