package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DaoshixuanzeliebiaoDao;
import com.entity.DaoshixuanzeliebiaoEntity;
import com.service.DaoshixuanzeliebiaoService;
import com.entity.vo.DaoshixuanzeliebiaoVO;
import com.entity.view.DaoshixuanzeliebiaoView;

@Service("daoshixuanzeliebiaoService")
public class DaoshixuanzeliebiaoServiceImpl extends ServiceImpl<DaoshixuanzeliebiaoDao, DaoshixuanzeliebiaoEntity> implements DaoshixuanzeliebiaoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DaoshixuanzeliebiaoEntity> page = this.selectPage(
                new Query<DaoshixuanzeliebiaoEntity>(params).getPage(),
                new EntityWrapper<DaoshixuanzeliebiaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DaoshixuanzeliebiaoEntity> wrapper) {
		  Page<DaoshixuanzeliebiaoView> page =new Query<DaoshixuanzeliebiaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DaoshixuanzeliebiaoVO> selectListVO(Wrapper<DaoshixuanzeliebiaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DaoshixuanzeliebiaoVO selectVO(Wrapper<DaoshixuanzeliebiaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DaoshixuanzeliebiaoView> selectListView(Wrapper<DaoshixuanzeliebiaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DaoshixuanzeliebiaoView selectView(Wrapper<DaoshixuanzeliebiaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
