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


import com.dao.LaoshipingjiaDao;
import com.entity.LaoshipingjiaEntity;
import com.service.LaoshipingjiaService;
import com.entity.vo.LaoshipingjiaVO;
import com.entity.view.LaoshipingjiaView;

@Service("laoshipingjiaService")
public class LaoshipingjiaServiceImpl extends ServiceImpl<LaoshipingjiaDao, LaoshipingjiaEntity> implements LaoshipingjiaService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LaoshipingjiaEntity> page = this.selectPage(
                new Query<LaoshipingjiaEntity>(params).getPage(),
                new EntityWrapper<LaoshipingjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LaoshipingjiaEntity> wrapper) {
		  Page<LaoshipingjiaView> page =new Query<LaoshipingjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LaoshipingjiaVO> selectListVO(Wrapper<LaoshipingjiaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LaoshipingjiaVO selectVO(Wrapper<LaoshipingjiaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LaoshipingjiaView> selectListView(Wrapper<LaoshipingjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LaoshipingjiaView selectView(Wrapper<LaoshipingjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
