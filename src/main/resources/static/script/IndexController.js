//tree
//当前目录
layui.use('tree', function treeFunction() {
    var currentDirectory = "/";
    var getFiles = "http://localhost:8888/littlefox/getFiles";

    function getTreeData(getFiles, currentDirectory) {
        var result = null;
        //获取该目录下的内容
        $.ajax({
                url: getFiles,
                type: 'POST',
                async: false,
                data: {path: currentDirectory},
                success: function (data) {
                    //由于是异步请求，所以在result返回之后这个方法才被执行，于是async=false
                    // console.log("got: " + data);
                    //最后转回json对象
                    result = JSON.parse(data);
                    // console.log([result]);
                },
                error: function () {
                    console.log("failed to get the tree data");
                }
            }
        );
        return result.children;
    }

    var treeData = getTreeData(getFiles, currentDirectory);
    refresh();
    refreshList(treeData);
    function refresh() {
        // console.log(treeData);
        layui.tree.render({
            elem: '#fileTree',
            data: treeData,//特别注意：这个data要是数组，不能是单一json
            accordion: false,
            click: function (obj) {
                console.log(obj);
                //更新树
                if (obj.data.children.length === 0) {
                    //不需要像原来labThings那样逐个节点递归检索，点击哪个节点就粘在哪个节点下面
                    //注意data是json，children是json数组
                    obj.data.children = getTreeData(getFiles, obj.data.canonicalPath);
                    // console.log(obj);
                    refresh();
                } else {
                    refreshList(obj.data.children);
                }
            }
        });
    }

    function refreshList(children){
        //更新列表  fileListBar
        var list = document.getElementById('filelist');
        while (list.firstChild) {
            list.removeChild(list.firstChild);
        }
        console.log(children);
        for (var file in children) {
            var li = document.createElement("li");
            var img = document.createElement("img");
            console.log(file);
            if (file.type === "directory")//文件夹
                img.src = "https://img.icons8.com/windows/32/000000/folder-invoices.png";
            else if (file.type.indexOf("image") !== -1 || file.type.indexOf("video") !== -1)//图片
                img.src = "https://img.icons8.com/windows/32/000000/image-file.png";
            else if (file.type.indexOf("text") !== -1)//文本文档
                img.src = "https://img.icons8.com/windows/32/000000/document.png";
            else //文件
                img.src = "https://img.icons8.com/windows/32/000000/file.png";
            li.appendChild(img);
            li.innerText(file.title + "  " + file.type + " " + file.size);
            list.appendChild(li);
        }
    }
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
