package cn.stylefeng.guns.modular.device.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.device.entity.Device;
import cn.stylefeng.guns.modular.device.model.params.DeviceParam;
import cn.stylefeng.guns.modular.device.service.DeviceService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 设备控制器
 *
 * @author heyifan
 * @Date 2019-06-03 18:35:01
 */
@Controller
@RequestMapping("/device")
public class DeviceController extends BaseController {

    private String PREFIX = "/modular/device";

    @Autowired
    private DeviceService deviceService;

    /**
     * 跳转到主页面
     *
     * @author heyifan
     * @Date 2019-06-03
     */
    @RequestMapping("")
    public String index() {

        return PREFIX + "/device.html";
    }

    /**
     * 新增页面
     *
     * @author heyifan
     * @Date 2019-06-03
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/device_add.html";
    }

    /**
     * 编辑页面
     *
     * @author heyifan
     * @Date 2019-06-03
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/device_edit.html";
    }

    /**
     * 新增接口
     *
     * @author heyifan
     * @Date 2019-06-03
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(DeviceParam deviceParam) {
        this.deviceService.add(deviceParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author heyifan
     * @Date 2019-06-03
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(DeviceParam deviceParam) {
        this.deviceService.update(deviceParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author heyifan
     * @Date 2019-06-03
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(DeviceParam deviceParam) {
        this.deviceService.delete(deviceParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author heyifan
     * @Date 2019-06-03
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(DeviceParam deviceParam) {
        Device detail = this.deviceService.getById(deviceParam.getId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author heyifan
     * @Date 2019-06-03
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(DeviceParam deviceParam) {
        return this.deviceService.findPageBySpec(deviceParam);
    }

}


