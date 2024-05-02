package com.dao;

import com.entity.WodexueshengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WodexueshengVO;
import com.entity.view.WodexueshengView;


/**
 * 我的学生
 * 
 * @author 
 * @email 
 * @date 2021-04-23 13:26:15
 */
public interface WodexueshengDao extends BaseMapper<WodexueshengEntity> {
	
	List<WodexueshengVO> selectListVO(@Param("ew") Wrapper<WodexueshengEntity> wrapper);
	
	WodexueshengVO selectVO(@Param("ew") Wrapper<WodexueshengEntity> wrapper);
	
	List<WodexueshengView> selectListView(@Param("ew") Wrapper<WodexueshengEntity> wrapper);

	List<WodexueshengView> selectListView(Pagination page,@Param("ew") Wrapper<WodexueshengEntity> wrapper);
	
	WodexueshengView selectView(@Param("ew") Wrapper<WodexueshengEntity> wrapper);
	
}
