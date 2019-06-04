package cn.stylefeng.guns.modular.deviceGroup.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.deviceGroup.entity.DeviceGroup;
import cn.stylefeng.guns.modular.deviceGroup.model.params.DeviceGroupParam;
import cn.stylefeng.guns.modular.deviceGroup.service.DeviceGroupService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 设备组控制器
 *
 * @author heyifan
 * @Date 2019-06-04 10:09:51
 */
@Controller
@RequestMapping("/deviceGroup")
public class DeviceGroupController extends BaseController {

    private String PREFIX = "/modular/deviceGroup";

    @Autowired
    private DeviceGroupService deviceGroupService;

    /**
     * 跳转到主页面
     *
     * @author heyifan
     * @Date 2019-06-04
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/deviceGroup.html";
    }

    /**
     * 新增页面
     *
     * @author heyifan
     * @Date 2019-06-04
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/deviceGroup_add.html";
    }

    /**
     * 编辑页面
     *
     * @author heyifan
     * @Date 2019-06-04
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/deviceGroup_edit.html";
    }

    /**
     * 新增接口
     *
     * @author heyifan
     * @Date 2019-06-04
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(DeviceGroupParam deviceGroupParam) {
        this.deviceGroupService.add(deviceGroupParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author heyifan
     * @Date 2019-06-04
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(DeviceGroupParam deviceGroupParam) {
        this.deviceGroupService.update(deviceGroupParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author heyifan
     * @Date 2019-06-04
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(DeviceGroupParam deviceGroupParam) {
        this.deviceGroupService.delete(deviceGroupParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author heyifan
     * @Date 2019-06-04
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(DeviceGroupParam deviceGroupParam) {
        DeviceGroup detail = this.deviceGroupService.getById(deviceGroupParam.getDeptId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author heyifan
     * @Date 2019-06-04
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(DeviceGroupParam deviceGroupParam) {
        return this.deviceGroupService.findPageBySpec(deviceGroupParam);
    }

}


