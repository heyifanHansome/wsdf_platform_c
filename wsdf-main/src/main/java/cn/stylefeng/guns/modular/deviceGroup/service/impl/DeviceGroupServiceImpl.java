package cn.stylefeng.guns.modular.deviceGroup.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.deviceGroup.entity.DeviceGroup;
import cn.stylefeng.guns.modular.deviceGroup.mapper.DeviceGroupMapper;
import cn.stylefeng.guns.modular.deviceGroup.model.params.DeviceGroupParam;
import cn.stylefeng.guns.modular.deviceGroup.model.result.DeviceGroupResult;
import  cn.stylefeng.guns.modular.deviceGroup.service.DeviceGroupService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 设备组 服务实现类
 * </p>
 *
 * @author heyifan
 * @since 2019-06-04
 */
@Service
public class DeviceGroupServiceImpl extends ServiceImpl<DeviceGroupMapper, DeviceGroup> implements DeviceGroupService {

    @Override
    public void add(DeviceGroupParam param){
        DeviceGroup entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(DeviceGroupParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(DeviceGroupParam param){
        DeviceGroup oldEntity = getOldEntity(param);
        DeviceGroup newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public DeviceGroupResult findBySpec(DeviceGroupParam param){
        return null;
    }

    @Override
    public List<DeviceGroupResult> findListBySpec(DeviceGroupParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(DeviceGroupParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(DeviceGroupParam param){
        return param.getDeptId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private DeviceGroup getOldEntity(DeviceGroupParam param) {
        return this.getById(getKey(param));
    }

    private DeviceGroup getEntity(DeviceGroupParam param) {
        DeviceGroup entity = new DeviceGroup();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
