package com.dao;

import com.entity.LaoshipingjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LaoshipingjiaVO;
import com.entity.view.LaoshipingjiaView;


/**
 * 老师评价
 * 
 * @author 
 * @email 
 * @date 2021-04-23 13:26:15
 */
public interface LaoshipingjiaDao extends BaseMapper<LaoshipingjiaEntity> {
	
	List<LaoshipingjiaVO> selectListVO(@Param("ew") Wrapper<LaoshipingjiaEntity> wrapper);
	
	LaoshipingjiaVO selectVO(@Param("ew") Wrapper<LaoshipingjiaEntity> wrapper);
	
	List<LaoshipingjiaView> selectListView(@Param("ew") Wrapper<LaoshipingjiaEntity> wrapper);

	List<LaoshipingjiaView> selectListView(Pagination page,@Param("ew") Wrapper<LaoshipingjiaEntity> wrapper);
	
	LaoshipingjiaView selectView(@Param("ew") Wrapper<LaoshipingjiaEntity> wrapper);
	
}
