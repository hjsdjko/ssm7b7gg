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


import com.dao.YixuandaoshiDao;
import com.entity.YixuandaoshiEntity;
import com.service.YixuandaoshiService;
import com.entity.vo.YixuandaoshiVO;
import com.entity.view.YixuandaoshiView;

@Service("yixuandaoshiService")
public class YixuandaoshiServiceImpl extends ServiceImpl<YixuandaoshiDao, YixuandaoshiEntity> implements YixuandaoshiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YixuandaoshiEntity> page = this.selectPage(
                new Query<YixuandaoshiEntity>(params).getPage(),
                new EntityWrapper<YixuandaoshiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YixuandaoshiEntity> wrapper) {
		  Page<YixuandaoshiView> page =new Query<YixuandaoshiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YixuandaoshiVO> selectListVO(Wrapper<YixuandaoshiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YixuandaoshiVO selectVO(Wrapper<YixuandaoshiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YixuandaoshiView> selectListView(Wrapper<YixuandaoshiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YixuandaoshiView selectView(Wrapper<YixuandaoshiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
