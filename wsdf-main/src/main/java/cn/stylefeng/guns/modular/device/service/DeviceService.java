package cn.stylefeng.guns.modular.device.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.device.entity.Device;
import cn.stylefeng.guns.modular.device.model.params.DeviceParam;
import cn.stylefeng.guns.modular.device.model.result.DeviceResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 设备 服务类
 * </p>
 *
 * @author heyifan
 * @since 2019-06-03
 */
public interface DeviceService extends IService<Device> {

    /**
     * 新增
     *
     * @author heyifan
     * @Date 2019-06-03
     */
    void add(DeviceParam param);

    /**
     * 删除
     *
     * @author heyifan
     * @Date 2019-06-03
     */
    void delete(DeviceParam param);

    /**
     * 更新
     *
     * @author heyifan
     * @Date 2019-06-03
     */
    void update(DeviceParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author heyifan
     * @Date 2019-06-03
     */
    DeviceResult findBySpec(DeviceParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author heyifan
     * @Date 2019-06-03
     */
    List<DeviceResult> findListBySpec(DeviceParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author heyifan
     * @Date 2019-06-03
     */
     LayuiPageInfo findPageBySpec(DeviceParam param);

}
