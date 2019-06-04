package cn.stylefeng.guns.modular.device.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 设备
 * </p>
 *
 * @author heyifan
 * @since 2019-06-03
 */
@TableName("sys_device")
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 设备名称
     */
    @TableField("name")
    private String name;

    /**
     * 电信返回设备id
     */
    @TableField("device_id")
    private String deviceId;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 设备mac地址
     */
    @TableField("mac")
    private String mac;

    /**
     * 设备状态(0:离线，1:在线，2:异常，-1:删除)
     */
    @TableField("status")
    private String status;

    /**
     * 万山产品编号id
     */
    @TableField("wsp_id")
    private String wspId;

    /**
     * 生产时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 创建人
     */
    @TableField("create_by")
    private String createBy;

    /**
     * 更新人
     */
    @TableField("update_by")
    private String updateBy;

    /**
     * (0:测试，1:正式)
     */
    @TableField("type")
    private String type;

    /**
     * 属于大类
     */
    @TableField("belong_id")
    private Integer belongId;

    /**
     * 设备指令条数
     */
    @TableField("event_count")
    private Long eventCount;

    /**
     * 设备批次(时间戳)
     */
    @TableField("device_batch")
    private String deviceBatch;

    /**
     * 设备是否已分配(0：未分配 1：已分配)
     */
    @TableField("is_assign")
    private Integer isAssign;

    /**
     * 设备编号前缀
     */
    @TableField("prefix")
    private String prefix;

    /**
     * 设备递增编号
     */
    @TableField("prefix_number")
    private Long prefixNumber;

    /**
     * 临时部门id
     */
    @TableField("temp_dept_id")
    private String tempDeptId;

    /**
     * 测试次数
     */
    @TableField("test_count")
    private Integer testCount;

    /**
     * 默认测试次数
     */
    @TableField("default_count")
    private Integer defaultCount;

    /**
     * 乐观锁用到
     */
    @TableField("version")
    private Integer version;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWspId() {
        return wspId;
    }

    public void setWspId(String wspId) {
        this.wspId = wspId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getBelongId() {
        return belongId;
    }

    public void setBelongId(Integer belongId) {
        this.belongId = belongId;
    }

    public Long getEventCount() {
        return eventCount;
    }

    public void setEventCount(Long eventCount) {
        this.eventCount = eventCount;
    }

    public String getDeviceBatch() {
        return deviceBatch;
    }

    public void setDeviceBatch(String deviceBatch) {
        this.deviceBatch = deviceBatch;
    }

    public Integer getIsAssign() {
        return isAssign;
    }

    public void setIsAssign(Integer isAssign) {
        this.isAssign = isAssign;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Long getPrefixNumber() {
        return prefixNumber;
    }

    public void setPrefixNumber(Long prefixNumber) {
        this.prefixNumber = prefixNumber;
    }

    public String getTempDeptId() {
        return tempDeptId;
    }

    public void setTempDeptId(String tempDeptId) {
        this.tempDeptId = tempDeptId;
    }

    public Integer getTestCount() {
        return testCount;
    }

    public void setTestCount(Integer testCount) {
        this.testCount = testCount;
    }

    public Integer getDefaultCount() {
        return defaultCount;
    }

    public void setDefaultCount(Integer defaultCount) {
        this.defaultCount = defaultCount;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Device{" +
        "id=" + id +
        ", name=" + name +
        ", deviceId=" + deviceId +
        ", userId=" + userId +
        ", mac=" + mac +
        ", status=" + status +
        ", wspId=" + wspId +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", createBy=" + createBy +
        ", updateBy=" + updateBy +
        ", type=" + type +
        ", belongId=" + belongId +
        ", eventCount=" + eventCount +
        ", deviceBatch=" + deviceBatch +
        ", isAssign=" + isAssign +
        ", prefix=" + prefix +
        ", prefixNumber=" + prefixNumber +
        ", tempDeptId=" + tempDeptId +
        ", testCount=" + testCount +
        ", defaultCount=" + defaultCount +
        ", version=" + version +
        "}";
    }
}
