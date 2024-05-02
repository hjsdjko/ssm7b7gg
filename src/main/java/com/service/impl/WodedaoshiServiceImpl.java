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


import com.dao.WodedaoshiDao;
import com.entity.WodedaoshiEntity;
import com.service.WodedaoshiService;
import com.entity.vo.WodedaoshiVO;
import com.entity.view.WodedaoshiView;

@Service("wodedaoshiService")
public class WodedaoshiServiceImpl extends ServiceImpl<WodedaoshiDao, WodedaoshiEntity> implements WodedaoshiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WodedaoshiEntity> page = this.selectPage(
                new Query<WodedaoshiEntity>(params).getPage(),
                new EntityWrapper<WodedaoshiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WodedaoshiEntity> wrapper) {
		  Page<WodedaoshiView> page =new Query<WodedaoshiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WodedaoshiVO> selectListVO(Wrapper<WodedaoshiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WodedaoshiVO selectVO(Wrapper<WodedaoshiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WodedaoshiView> selectListView(Wrapper<WodedaoshiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WodedaoshiView selectView(Wrapper<WodedaoshiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
