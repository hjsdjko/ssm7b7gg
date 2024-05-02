package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DaoshizuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DaoshizuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DaoshizuView;


/**
 * 导师组
 *
 * @author 
 * @email 
 * @date 2021-04-23 13:26:15
 */
public interface DaoshizuService extends IService<DaoshizuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DaoshizuVO> selectListVO(Wrapper<DaoshizuEntity> wrapper);
   	
   	DaoshizuVO selectVO(@Param("ew") Wrapper<DaoshizuEntity> wrapper);
   	
   	List<DaoshizuView> selectListView(Wrapper<DaoshizuEntity> wrapper);
   	
   	DaoshizuView selectView(@Param("ew") Wrapper<DaoshizuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DaoshizuEntity> wrapper);
   	
}

