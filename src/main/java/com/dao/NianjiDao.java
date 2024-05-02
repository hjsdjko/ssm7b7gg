package com.dao;

import com.entity.NianjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.NianjiVO;
import com.entity.view.NianjiView;


/**
 * 年级
 * 
 * @author 
 * @email 
 * @date 2021-04-23 13:26:15
 */
public interface NianjiDao extends BaseMapper<NianjiEntity> {
	
	List<NianjiVO> selectListVO(@Param("ew") Wrapper<NianjiEntity> wrapper);
	
	NianjiVO selectVO(@Param("ew") Wrapper<NianjiEntity> wrapper);
	
	List<NianjiView> selectListView(@Param("ew") Wrapper<NianjiEntity> wrapper);

	List<NianjiView> selectListView(Pagination page,@Param("ew") Wrapper<NianjiEntity> wrapper);
	
	NianjiView selectView(@Param("ew") Wrapper<NianjiEntity> wrapper);
	
}
