package com.dao;

import com.entity.DaoshizuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DaoshizuVO;
import com.entity.view.DaoshizuView;


/**
 * 导师组
 * 
 * @author 
 * @email 
 * @date 2021-04-23 13:26:15
 */
public interface DaoshizuDao extends BaseMapper<DaoshizuEntity> {
	
	List<DaoshizuVO> selectListVO(@Param("ew") Wrapper<DaoshizuEntity> wrapper);
	
	DaoshizuVO selectVO(@Param("ew") Wrapper<DaoshizuEntity> wrapper);
	
	List<DaoshizuView> selectListView(@Param("ew") Wrapper<DaoshizuEntity> wrapper);

	List<DaoshizuView> selectListView(Pagination page,@Param("ew") Wrapper<DaoshizuEntity> wrapper);
	
	DaoshizuView selectView(@Param("ew") Wrapper<DaoshizuEntity> wrapper);
	
}
