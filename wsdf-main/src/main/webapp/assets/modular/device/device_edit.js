/**
 * 详情对话框
 */
var DeviceInfoDlg = {
    data: {
        name: "",
        deviceId: "",
        userId: "",
        mac: "",
        status: "",
        wspId: "",
        createTime: "",
        updateTime: "",
        createBy: "",
        updateBy: "",
        type: "",
        belongId: "",
        eventCount: "",
        deviceBatch: "",
        isAssign: "",
        prefix: "",
        prefixNumber: "",
        tempDeptId: "",
        testCount: "",
        defaultCount: "",
        version: ""
    }
};

layui.use(['form', 'admin', 'ax'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;

    //让当前iframe弹层高度适应
    admin.iframeAuto();

    //获取详情信息，填充表单
    var ajax = new $ax(Feng.ctxPath + "/device/detail?id=" + Feng.getUrlParam("id"));
    var result = ajax.start();
    form.val('deviceForm', result.data);

    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var ajax = new $ax(Feng.ctxPath + "/device/editItem", function (data) {
            Feng.success("更新成功！");
            window.location.href = Feng.ctxPath + '/device'
        }, function (data) {
            Feng.error("更新失败！" + data.responseJSON.message)
        });
        ajax.set(data.field);
        ajax.start();

        return false;
    });

    //返回按钮
    $("#backupPage").click(function () {
        window.location.href = Feng.ctxPath + '/device'
    });

});