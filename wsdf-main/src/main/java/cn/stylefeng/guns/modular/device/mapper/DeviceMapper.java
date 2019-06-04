package cn.stylefeng.guns.modular.device.mapper;

import cn.stylefeng.guns.modular.device.entity.Device;
import cn.stylefeng.guns.modular.device.model.params.DeviceParam;
import cn.stylefeng.guns.modular.device.model.result.DeviceResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 设备 Mapper 接口
 * </p>
 *
 * @author heyifan
 * @since 2019-06-03
 */
public interface DeviceMapper extends BaseMapper<Device> {

    /**
     * 获取列表
     *
     * @author heyifan
     * @Date 2019-06-03
     */
    List<DeviceResult> customList(@Param("paramCondition") DeviceParam paramCondition);

    /**
     * 获取map列表
     *
     * @author heyifan
     * @Date 2019-06-03
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") DeviceParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author heyifan
     * @Date 2019-06-03
     */
    Page<DeviceResult> customPageList(@Param("page") Page page, @Param("paramCondition") DeviceParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author heyifan
     * @Date 2019-06-03
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") DeviceParam paramCondition);

}
