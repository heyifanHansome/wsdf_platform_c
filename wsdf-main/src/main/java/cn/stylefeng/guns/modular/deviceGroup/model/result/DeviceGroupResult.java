package cn.stylefeng.guns.modular.deviceGroup.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 设备组
 * </p>
 *
 * @author heyifan
 * @since 2019-06-04
 */
@Data
public class DeviceGroupResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    private Long deptId;

    /**
     * 父部门id
     */
    private Long pid;

    /**
     * 父级ids
     */
    private String pids;

    /**
     * 简称
     */
    private String simpleName;

    /**
     * 全称
     */
    private String fullName;

    /**
     * 描述
     */
    private String description;

    /**
     * 版本（乐观锁保留字段）
     */
    private Integer version;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 修改人
     */
    private Long updateUser;

}
