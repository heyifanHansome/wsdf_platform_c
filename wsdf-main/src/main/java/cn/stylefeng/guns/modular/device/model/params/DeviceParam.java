package cn.stylefeng.guns.modular.device.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 设备
 * </p>
 *
 * @author heyifan
 * @since 2019-06-03
 */
@Data
public class DeviceParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */
    private Integer id;

    /**
     * 设备名称
     */
    private String name;

    /**
     * 电信返回设备id
     */
    private String deviceId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 设备mac地址
     */
    private String mac;

    /**
     * 设备状态(0:离线，1:在线，2:异常，-1:删除)
     */
    private String status;

    /**
     * 万山产品编号id
     */
    private String wspId;

    /**
     * 生产时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * (0:测试，1:正式)
     */
    private String type;

    /**
     * 属于大类
     */
    private Integer belongId;

    /**
     * 设备指令条数
     */
    private Long eventCount;

    /**
     * 设备批次(时间戳)
     */
    private String deviceBatch;

    /**
     * 设备是否已分配(0：未分配 1：已分配)
     */
    private Integer isAssign;

    /**
     * 设备编号前缀
     */
    private String prefix;

    /**
     * 设备递增编号
     */
    private Long prefixNumber;

    /**
     * 临时部门id
     */
    private String tempDeptId;

    /**
     * 测试次数
     */
    private Integer testCount;

    /**
     * 默认测试次数
     */
    private Integer defaultCount;

    /**
     * 乐观锁用到
     */
    private Integer version;

    @Override
    public String checkParam() {
        return null;
    }

}
