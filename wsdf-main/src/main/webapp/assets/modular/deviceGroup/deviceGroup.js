layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 设备组管理
     */
    var DeviceGroup = {
        tableId: "deviceGroupTable"
    };

    /**
     * 初始化表格的列
     */
    DeviceGroup.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'deptId', hide: true, title: '主键id'},
            {field: 'pid', sort: true, title: '父部门id'},
            {field: 'pids', sort: true, title: '父级ids'},
            {field: 'simpleName', sort: true, title: '简称'},
            {field: 'fullName', sort: true, title: '全称'},
            {field: 'description', sort: true, title: '描述'},
            {field: 'version', sort: true, title: '版本（乐观锁保留字段）'},
            {field: 'sort', sort: true, title: '排序'},
            {field: 'createTime', sort: true, title: '创建时间'},
            {field: 'updateTime', sort: true, title: '修改时间'},
            {field: 'createUser', sort: true, title: '创建人'},
            {field: 'updateUser', sort: true, title: '修改人'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    DeviceGroup.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(DeviceGroup.tableId, {where: queryData});
    };

    /**
     * 弹出添加对话框
     */
    DeviceGroup.openAddDlg = function () {
        window.location.href = Feng.ctxPath + '/deviceGroup/add';
    };

    /**
     * 导出excel按钮
     */
    DeviceGroup.exportExcel = function () {
        var checkRows = table.checkStatus(DeviceGroup.tableId);
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
    DeviceGroup.openEditDlg = function (data) {
        window.location.href = Feng.ctxPath + '/deviceGroup/edit?deptId=' + data.deptId;
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    DeviceGroup.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/deviceGroup/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(DeviceGroup.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("deptId", data.deptId);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + DeviceGroup.tableId,
        url: Feng.ctxPath + '/deviceGroup/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: DeviceGroup.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        DeviceGroup.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        DeviceGroup.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        DeviceGroup.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + DeviceGroup.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            DeviceGroup.openEditDlg(data);
        } else if (layEvent === 'delete') {
            DeviceGroup.onDeleteItem(data);
        }
    });
});
