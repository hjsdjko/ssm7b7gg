package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DaoshixuanzeliebiaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DaoshixuanzeliebiaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DaoshixuanzeliebiaoView;


/**
 * 导师选择列表
 *
 * @author 
 * @email 
 * @date 2021-04-23 13:26:15
 */
public interface DaoshixuanzeliebiaoService extends IService<DaoshixuanzeliebiaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DaoshixuanzeliebiaoVO> selectListVO(Wrapper<DaoshixuanzeliebiaoEntity> wrapper);
   	
   	DaoshixuanzeliebiaoVO selectVO(@Param("ew") Wrapper<DaoshixuanzeliebiaoEntity> wrapper);
   	
   	List<DaoshixuanzeliebiaoView> selectListView(Wrapper<DaoshixuanzeliebiaoEntity> wrapper);
   	
   	DaoshixuanzeliebiaoView selectView(@Param("ew") Wrapper<DaoshixuanzeliebiaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DaoshixuanzeliebiaoEntity> wrapper);
   	
}

