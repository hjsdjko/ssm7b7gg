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


import com.dao.YanjiufangxiangDao;
import com.entity.YanjiufangxiangEntity;
import com.service.YanjiufangxiangService;
import com.entity.vo.YanjiufangxiangVO;
import com.entity.view.YanjiufangxiangView;

@Service("yanjiufangxiangService")
public class YanjiufangxiangServiceImpl extends ServiceImpl<YanjiufangxiangDao, YanjiufangxiangEntity> implements YanjiufangxiangService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YanjiufangxiangEntity> page = this.selectPage(
                new Query<YanjiufangxiangEntity>(params).getPage(),
                new EntityWrapper<YanjiufangxiangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YanjiufangxiangEntity> wrapper) {
		  Page<YanjiufangxiangView> page =new Query<YanjiufangxiangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YanjiufangxiangVO> selectListVO(Wrapper<YanjiufangxiangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YanjiufangxiangVO selectVO(Wrapper<YanjiufangxiangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YanjiufangxiangView> selectListView(Wrapper<YanjiufangxiangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YanjiufangxiangView selectView(Wrapper<YanjiufangxiangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
