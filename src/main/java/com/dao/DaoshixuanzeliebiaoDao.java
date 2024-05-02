package com.dao;

import com.entity.DaoshixuanzeliebiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DaoshixuanzeliebiaoVO;
import com.entity.view.DaoshixuanzeliebiaoView;


/**
 * 导师选择列表
 * 
 * @author 
 * @email 
 * @date 2021-04-23 13:26:15
 */
public interface DaoshixuanzeliebiaoDao extends BaseMapper<DaoshixuanzeliebiaoEntity> {
	
	List<DaoshixuanzeliebiaoVO> selectListVO(@Param("ew") Wrapper<DaoshixuanzeliebiaoEntity> wrapper);
	
	DaoshixuanzeliebiaoVO selectVO(@Param("ew") Wrapper<DaoshixuanzeliebiaoEntity> wrapper);
	
	List<DaoshixuanzeliebiaoView> selectListView(@Param("ew") Wrapper<DaoshixuanzeliebiaoEntity> wrapper);

	List<DaoshixuanzeliebiaoView> selectListView(Pagination page,@Param("ew") Wrapper<DaoshixuanzeliebiaoEntity> wrapper);
	
	DaoshixuanzeliebiaoView selectView(@Param("ew") Wrapper<DaoshixuanzeliebiaoEntity> wrapper);
	
}
