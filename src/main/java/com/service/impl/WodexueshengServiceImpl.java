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


import com.dao.WodexueshengDao;
import com.entity.WodexueshengEntity;
import com.service.WodexueshengService;
import com.entity.vo.WodexueshengVO;
import com.entity.view.WodexueshengView;

@Service("wodexueshengService")
public class WodexueshengServiceImpl extends ServiceImpl<WodexueshengDao, WodexueshengEntity> implements WodexueshengService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WodexueshengEntity> page = this.selectPage(
                new Query<WodexueshengEntity>(params).getPage(),
                new EntityWrapper<WodexueshengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WodexueshengEntity> wrapper) {
		  Page<WodexueshengView> page =new Query<WodexueshengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WodexueshengVO> selectListVO(Wrapper<WodexueshengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WodexueshengVO selectVO(Wrapper<WodexueshengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WodexueshengView> selectListView(Wrapper<WodexueshengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WodexueshengView selectView(Wrapper<WodexueshengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
