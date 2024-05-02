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


import com.dao.DaoshizuDao;
import com.entity.DaoshizuEntity;
import com.service.DaoshizuService;
import com.entity.vo.DaoshizuVO;
import com.entity.view.DaoshizuView;

@Service("daoshizuService")
public class DaoshizuServiceImpl extends ServiceImpl<DaoshizuDao, DaoshizuEntity> implements DaoshizuService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DaoshizuEntity> page = this.selectPage(
                new Query<DaoshizuEntity>(params).getPage(),
                new EntityWrapper<DaoshizuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DaoshizuEntity> wrapper) {
		  Page<DaoshizuView> page =new Query<DaoshizuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DaoshizuVO> selectListVO(Wrapper<DaoshizuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DaoshizuVO selectVO(Wrapper<DaoshizuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DaoshizuView> selectListView(Wrapper<DaoshizuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DaoshizuView selectView(Wrapper<DaoshizuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
