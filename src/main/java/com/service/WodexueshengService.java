package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WodexueshengEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WodexueshengVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WodexueshengView;


/**
 * 我的学生
 *
 * @author 
 * @email 
 * @date 2021-04-23 13:26:15
 */
public interface WodexueshengService extends IService<WodexueshengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WodexueshengVO> selectListVO(Wrapper<WodexueshengEntity> wrapper);
   	
   	WodexueshengVO selectVO(@Param("ew") Wrapper<WodexueshengEntity> wrapper);
   	
   	List<WodexueshengView> selectListView(Wrapper<WodexueshengEntity> wrapper);
   	
   	WodexueshengView selectView(@Param("ew") Wrapper<WodexueshengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WodexueshengEntity> wrapper);
   	
}

