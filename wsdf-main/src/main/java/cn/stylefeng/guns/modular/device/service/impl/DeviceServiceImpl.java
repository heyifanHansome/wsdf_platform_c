package cn.stylefeng.guns.modular.device.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.device.entity.Device;
import cn.stylefeng.guns.modular.device.mapper.DeviceMapper;
import cn.stylefeng.guns.modular.device.model.params.DeviceParam;
import cn.stylefeng.guns.modular.device.model.result.DeviceResult;
import  cn.stylefeng.guns.modular.device.service.DeviceService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 设备 服务实现类
 * </p>
 *
 * @author heyifan
 * @since 2019-06-03
 */
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {

    @Override
    public void add(DeviceParam param){
        Device entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(DeviceParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(DeviceParam param){
        Device oldEntity = getOldEntity(param);
        Device newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public DeviceResult findBySpec(DeviceParam param){
        return null;
    }

    @Override
    public List<DeviceResult> findListBySpec(DeviceParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(DeviceParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(DeviceParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Device getOldEntity(DeviceParam param) {
        return this.getById(getKey(param));
    }

    private Device getEntity(DeviceParam param) {
        Device entity = new Device();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
