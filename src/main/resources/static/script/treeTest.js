a = [{
    title: "一级1"

    , field: "name1"
    , checked: true
    , spread: true
    , children: [{
        title: '二级1-1 可允许跳转'

        , field: 'name11'
        , href: 'https://www.layui.com/'
        , children: [{
            title: '三级1-1-3'

            , field: ''
            , children: [{
                title: '四级1-1-3-1'

                , field: ''
                , children: [{
                    title: '五级1-1-3-1-1'
                    , id: 30
                    , field: ''
                }, {
                    title: '五级1-1-3-1-2'
                    , id: 31
                    , field: ''
                }]
            }]
        }, {
            title: '三级1-1-1'
            , id: 7
            , field: ''
            , children: [{
                title: '四级1-1-1-1 可允许跳转'
                , id: 15
                , field: ''
                , href: 'https://www.layui.com/doc/'
            }]
        }, {
            title: '三级1-1-2'
            , id: 8
            , field: ''
            , children: [{
                title: '四级1-1-2-1'
                , id: 32
                , field: ''
            }]
        }]
    }, {
        title: '二级1-2'
        , id: 4
        , spread: true
        , children: [{
            title: '三级1-2-1'
            , id: 9
            , field: ''
            , disabled: true
        }, {
            title: '三级1-2-2'
            , id: 10
            , field: ''
        }]
    }, {
        title: '二级1-3'
        , id: 20
        , field: ''
        , children: [{
            title: '三级1-3-1'
            , id: 21
            , field: ''
        }, {
            title: '三级1-3-2'
            , id: 22
            , field: ''
        }]
    }]
}, {
    title: '一级2'
    , id: 2
    , field: ''
    , spread: true
    , children: [{
        title: '二级2-1'
        , id: 5
        , field: ''
        , spread: true
        , children: [{
            title: '三级2-1-1'
            , id: 11
            , field: ''
        }, {
            title: '三级2-1-2'
            , id: 12
            , field: ''
        }]
    }, {
        title: '二级2-2'
        , id: 6
        , field: ''
        , children: [{
            title: '三级2-2-1'
            , id: 13
            , field: ''
        }, {
            title: '三级2-2-2'
            , id: 14
            , field: ''
            , disabled: true
        }]
    }]
}, {
    title: '一级3'
    , id: 16
    , field: ''
    , children: [{
        title: '二级3-1'
        , id: 17
        , field: ''
        , fixed: true
        , children: [{
            title: '三级3-1-1'
            , id: 18
            , field: ''
        }, {
            title: '三级3-1-2'
            , id: 19
            , field: ''
        }]
    }, {
        title: '二级3-2'
        , id: 27
        , field: ''
        , children: [{
            title: '三级3-2-1'
            , id: 28
            , field: ''
        }, {
            title: '三级3-2-2'
            , id: 29
            , field: ''
        }]
    }]
}];
b = {field: "http://localhost:8888/littlefox", children: Array(28), title: "root"};
//tree
c = {
    title: "一级1"

    , field: "name1"
    , checked: true
    , spread: true
    , children: [{
        title: '二级1-1 可允许跳转'

        , field: 'name11'
        , href: 'https://www.layui.com/'
        , children: [{
            title: '三级1-1-3'

            , field: ''
            , children: [{
                title: '四级1-1-3-1'

                , field: ''
                , children: [{
                    title: '五级1-1-3-1-1'
                    , id: 30
                    , field: ''
                }, {
                    title: '五级1-1-3-1-2'
                    , id: 31
                    , field: ''
                }]
            }]
        }, {
            title: '三级1-1-1'
            , id: 7
            , field: ''
            , children: [{
                title: '四级1-1-1-1 可允许跳转'
                , id: 15
                , field: ''
                , href: 'https://www.layui.com/doc/'
            }]
        }, {
            title: '三级1-1-2'
            , id: 8
            , field: ''
            , children: [{
                title: '四级1-1-2-1'
                , id: 32
                , field: ''
            }]
        }]
    }, {
        title: '二级1-2'
        , id: 4
        , spread: true
        , children: [{
            title: '三级1-2-1'
            , id: 9
            , field: ''
            , disabled: true
        }, {
            title: '三级1-2-2'
            , id: 10
            , field: ''
        }]
    }, {
        title: '二级1-3'
        , id: 20
        , field: ''
        , children: [{
            title: '三级1-3-1'
            , id: 21
            , field: ''
        }, {
            title: '三级1-3-2'
            , id: 22
            , field: ''
        }]
    }]
};

layui.use('tree', function () {
    var tree = layui.tree;
    console.log(c);
    //渲染
    var inst1 = tree.render({
        elem: '#fileTree'
        , data: c
        , accordion: false
    });


});

//leftpane
var leftpanestatus = false;

function toggleLeftpane() {
    var leftpane = document.getElementById('leftpane');//此句话不能放在外面
    // console.log(leftpane+leftpanestatus);
    // console.log("clicked " + leftpane.style.display);
    if (leftpanestatus)
        leftpane.style.display = 'block';
    else
        leftpane.style.display = 'none';
    leftpanestatus = !leftpanestatus;
}

//mainpanel
function closeMainpanel() {
    var mainpanel = document.getElementById('mainpanel');
    mainpanel.style.display = 'none';
}

//fileListBar


//commBar
var commBarStatus = true;

function toggleCommBarStatus() {
    var commBar = document.getElementById('commBar');
    if (commBarStatus)
        commBar.style.display = 'block';
    else
        commBar.style.display = 'none';
    commBarStatus = !commBarStatus;
}

//uploadBar
var uploadBarStatus = true;

function toggleUploadBarStatus() {
    var uploadBar = document.getElementById('uploadBar');
    if (uploadBarStatus)
        uploadBar.style.display = 'block';
    else
        uploadBar.style.display = 'none';
    uploadBarStatus = !uploadBarStatus;
}

//img carousel
imgs = [{name: '', url: ''}];
layui.use('carousel', function () {
    var carousel = layui.carousel;
    //建造实例
    carousel.render({
        elem: '#carousel'
        , width: '100%' //设置容器宽度
        , arrow: 'hover' //始终显示箭头
        , autoplay: false
    });
    //图像标签的生成 一次加载五张，浏览到最后，向服务器发送传输请求
    //监听轮播切换事件
    carousel.on('change(carousel)', function (obj) {
        console.log(obj.index + " " + carousel.length); //当前条目的索引
        if (obj.index === carousel.length) {

        } else if (obj.index === 0) {

        }
    });
});

//video
