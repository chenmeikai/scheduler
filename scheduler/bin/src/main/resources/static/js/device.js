$().ready(function () {
    checkDevice()
})

function checkDevice() {
    if (/Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)) {

        $(".navbar-fixed-top").css({'margin-top': '-45px'})
        $(".menu-container").css({'position': 'relative', 'top': '15px'})
        $(".beian").css({'font-size': '0.8em', 'padding-bottom': '15px'})
    } else {
        $(".fix-nav").hide();
    }
}