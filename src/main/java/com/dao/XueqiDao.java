package com.dao;

import com.entity.XueqiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XueqiVO;
import com.entity.view.XueqiView;


/**
 * 学期
 * 
 * @author 
 * @email 
 * @date 2021-04-23 13:26:15
 */
public interface XueqiDao extends BaseMapper<XueqiEntity> {
	
	List<XueqiVO> selectListVO(@Param("ew") Wrapper<XueqiEntity> wrapper);
	
	XueqiVO selectVO(@Param("ew") Wrapper<XueqiEntity> wrapper);
	
	List<XueqiView> selectListView(@Param("ew") Wrapper<XueqiEntity> wrapper);

	List<XueqiView> selectListView(Pagination page,@Param("ew") Wrapper<XueqiEntity> wrapper);
	
	XueqiView selectView(@Param("ew") Wrapper<XueqiEntity> wrapper);
	
}
