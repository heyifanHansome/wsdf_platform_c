package cn.stylefeng.guns.modular.deviceGroup.mapper;

import cn.stylefeng.guns.modular.deviceGroup.entity.DeviceGroup;
import cn.stylefeng.guns.modular.deviceGroup.model.params.DeviceGroupParam;
import cn.stylefeng.guns.modular.deviceGroup.model.result.DeviceGroupResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 设备组 Mapper 接口
 * </p>
 *
 * @author heyifan
 * @since 2019-06-04
 */
public interface DeviceGroupMapper extends BaseMapper<DeviceGroup> {

    /**
     * 获取列表
     *
     * @author heyifan
     * @Date 2019-06-04
     */
    List<DeviceGroupResult> customList(@Param("paramCondition") DeviceGroupParam paramCondition);

    /**
     * 获取map列表
     *
     * @author heyifan
     * @Date 2019-06-04
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") DeviceGroupParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author heyifan
     * @Date 2019-06-04
     */
    Page<DeviceGroupResult> customPageList(@Param("page") Page page, @Param("paramCondition") DeviceGroupParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author heyifan
     * @Date 2019-06-04
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") DeviceGroupParam paramCondition);

}
