package com.dao;

import com.entity.WodedaoshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WodedaoshiVO;
import com.entity.view.WodedaoshiView;


/**
 * 我的导师
 * 
 * @author 
 * @email 
 * @date 2021-04-23 13:26:15
 */
public interface WodedaoshiDao extends BaseMapper<WodedaoshiEntity> {
	
	List<WodedaoshiVO> selectListVO(@Param("ew") Wrapper<WodedaoshiEntity> wrapper);
	
	WodedaoshiVO selectVO(@Param("ew") Wrapper<WodedaoshiEntity> wrapper);
	
	List<WodedaoshiView> selectListView(@Param("ew") Wrapper<WodedaoshiEntity> wrapper);

	List<WodedaoshiView> selectListView(Pagination page,@Param("ew") Wrapper<WodedaoshiEntity> wrapper);
	
	WodedaoshiView selectView(@Param("ew") Wrapper<WodedaoshiEntity> wrapper);
	
}
