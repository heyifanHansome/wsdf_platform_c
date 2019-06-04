package cn.stylefeng.guns.modular.deviceGroup.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.deviceGroup.entity.DeviceGroup;
import cn.stylefeng.guns.modular.deviceGroup.model.params.DeviceGroupParam;
import cn.stylefeng.guns.modular.deviceGroup.model.result.DeviceGroupResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 设备组 服务类
 * </p>
 *
 * @author heyifan
 * @since 2019-06-04
 */
public interface DeviceGroupService extends IService<DeviceGroup> {

    /**
     * 新增
     *
     * @author heyifan
     * @Date 2019-06-04
     */
    void add(DeviceGroupParam param);

    /**
     * 删除
     *
     * @author heyifan
     * @Date 2019-06-04
     */
    void delete(DeviceGroupParam param);

    /**
     * 更新
     *
     * @author heyifan
     * @Date 2019-06-04
     */
    void update(DeviceGroupParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author heyifan
     * @Date 2019-06-04
     */
    DeviceGroupResult findBySpec(DeviceGroupParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author heyifan
     * @Date 2019-06-04
     */
    List<DeviceGroupResult> findListBySpec(DeviceGroupParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author heyifan
     * @Date 2019-06-04
     */
     LayuiPageInfo findPageBySpec(DeviceGroupParam param);

}
