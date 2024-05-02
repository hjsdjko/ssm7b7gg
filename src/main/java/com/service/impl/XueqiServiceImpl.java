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


import com.dao.XueqiDao;
import com.entity.XueqiEntity;
import com.service.XueqiService;
import com.entity.vo.XueqiVO;
import com.entity.view.XueqiView;

@Service("xueqiService")
public class XueqiServiceImpl extends ServiceImpl<XueqiDao, XueqiEntity> implements XueqiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XueqiEntity> page = this.selectPage(
                new Query<XueqiEntity>(params).getPage(),
                new EntityWrapper<XueqiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XueqiEntity> wrapper) {
		  Page<XueqiView> page =new Query<XueqiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XueqiVO> selectListVO(Wrapper<XueqiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XueqiVO selectVO(Wrapper<XueqiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XueqiView> selectListView(Wrapper<XueqiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XueqiView selectView(Wrapper<XueqiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
