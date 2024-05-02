package com.dao;

import com.entity.YanjiufangxiangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YanjiufangxiangVO;
import com.entity.view.YanjiufangxiangView;


/**
 * 研究方向
 * 
 * @author 
 * @email 
 * @date 2021-04-23 13:26:15
 */
public interface YanjiufangxiangDao extends BaseMapper<YanjiufangxiangEntity> {
	
	List<YanjiufangxiangVO> selectListVO(@Param("ew") Wrapper<YanjiufangxiangEntity> wrapper);
	
	YanjiufangxiangVO selectVO(@Param("ew") Wrapper<YanjiufangxiangEntity> wrapper);
	
	List<YanjiufangxiangView> selectListView(@Param("ew") Wrapper<YanjiufangxiangEntity> wrapper);

	List<YanjiufangxiangView> selectListView(Pagination page,@Param("ew") Wrapper<YanjiufangxiangEntity> wrapper);
	
	YanjiufangxiangView selectView(@Param("ew") Wrapper<YanjiufangxiangEntity> wrapper);
	
}
