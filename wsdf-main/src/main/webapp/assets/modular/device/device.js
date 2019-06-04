layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 设备管理
     */
    var Device = {
        tableId: "deviceTable"
    };

    /**
     * 初始化表格的列
     */
    Device.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: '主键'},
            {field: 'name', sort: true, title: '设备名称'},
            {field: 'deviceId', sort: true, title: '电信返回设备id'},
            {field: 'userId', sort: true, title: '用户id'},
            {field: 'mac', sort: true, title: '设备mac地址'},
            {field: 'status', sort: true, title: '设备状态(0:离线，1:在线，2:异常，-1:删除)'},
            {field: 'wspId', sort: true, title: '万山产品编号id'},
            {field: 'createTime', sort: true, title: '生产时间'},
            {field: 'updateTime', sort: true, title: '更新时间'},
            {field: 'createBy', sort: true, title: '创建人'},
            {field: 'updateBy', sort: true, title: '更新人'},
            {field: 'type', sort: true, title: '(0:测试，1:正式)'},
            {field: 'belongId', sort: true, title: '属于大类'},
            {field: 'eventCount', sort: true, title: '设备指令条数'},
            {field: 'deviceBatch', sort: true, title: '设备批次(时间戳)'},
            {field: 'isAssign', sort: true, title: '设备是否已分配(0：未分配 1：已分配)'},
            {field: 'prefix', sort: true, title: '设备编号前缀'},
            {field: 'prefixNumber', sort: true, title: '设备递增编号'},
            {field: 'tempDeptId', sort: true, title: '临时部门id'},
            {field: 'testCount', sort: true, title: '测试次数'},
            {field: 'defaultCount', sort: true, title: '默认测试次数'},
            {field: 'version', sort: true, title: '乐观锁用到'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Device.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Device.tableId, {where: queryData});
    };

    /**
     * 弹出添加对话框
     */
    Device.openAddDlg = function () {
        window.location.href = Feng.ctxPath + '/device/add';
    };

    /**
     * 导出excel按钮
     */
    Device.exportExcel = function () {
        var checkRows = table.checkStatus(Device.tableId);
        if (checkRows.data.length === 0) {
            Feng.error("请选择要导出的数据");
        } else {
            table.exportFile(tableResult.config.id, checkRows.data, 'xls');
        }
    };

    /**
     * 点击编辑
     *
     * @param data 点击按钮时候的行数据
     */
    Device.openEditDlg = function (data) {
        window.location.href = Feng.ctxPath + '/device/edit?id=' + data.id;
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    Device.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/device/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Device.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("id", data.id);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + Device.tableId,
        url: Feng.ctxPath + '/device/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Device.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Device.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Device.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Device.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Device.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Device.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Device.onDeleteItem(data);
        }
    });
});
