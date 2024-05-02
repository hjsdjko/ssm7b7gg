package com.dao;

import com.entity.YixuandaoshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YixuandaoshiVO;
import com.entity.view.YixuandaoshiView;


/**
 * 已选导师
 * 
 * @author 
 * @email 
 * @date 2021-04-23 13:26:15
 */
public interface YixuandaoshiDao extends BaseMapper<YixuandaoshiEntity> {
	
	List<YixuandaoshiVO> selectListVO(@Param("ew") Wrapper<YixuandaoshiEntity> wrapper);
	
	YixuandaoshiVO selectVO(@Param("ew") Wrapper<YixuandaoshiEntity> wrapper);
	
	List<YixuandaoshiView> selectListView(@Param("ew") Wrapper<YixuandaoshiEntity> wrapper);

	List<YixuandaoshiView> selectListView(Pagination page,@Param("ew") Wrapper<YixuandaoshiEntity> wrapper);
	
	YixuandaoshiView selectView(@Param("ew") Wrapper<YixuandaoshiEntity> wrapper);
	
}
