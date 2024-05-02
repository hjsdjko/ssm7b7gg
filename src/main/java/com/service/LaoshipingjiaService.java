package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LaoshipingjiaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LaoshipingjiaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LaoshipingjiaView;


/**
 * 老师评价
 *
 * @author 
 * @email 
 * @date 2021-04-23 13:26:15
 */
public interface LaoshipingjiaService extends IService<LaoshipingjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LaoshipingjiaVO> selectListVO(Wrapper<LaoshipingjiaEntity> wrapper);
   	
   	LaoshipingjiaVO selectVO(@Param("ew") Wrapper<LaoshipingjiaEntity> wrapper);
   	
   	List<LaoshipingjiaView> selectListView(Wrapper<LaoshipingjiaEntity> wrapper);
   	
   	LaoshipingjiaView selectView(@Param("ew") Wrapper<LaoshipingjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LaoshipingjiaEntity> wrapper);
   	
}

