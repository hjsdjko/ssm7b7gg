package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DaoshizuEntity;
import com.entity.view.DaoshizuView;

import com.service.DaoshizuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 导师组
 * 后端接口
 * @author 
 * @email 
 * @date 2021-04-23 13:26:15
 */
@RestController
@RequestMapping("/daoshizu")
public class DaoshizuController {
    @Autowired
    private DaoshizuService daoshizuService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DaoshizuEntity daoshizu, 
		HttpServletRequest request){

        EntityWrapper<DaoshizuEntity> ew = new EntityWrapper<DaoshizuEntity>();
		PageUtils page = daoshizuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, daoshizu), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DaoshizuEntity daoshizu, 
		HttpServletRequest request){
        EntityWrapper<DaoshizuEntity> ew = new EntityWrapper<DaoshizuEntity>();
		PageUtils page = daoshizuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, daoshizu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DaoshizuEntity daoshizu){
       	EntityWrapper<DaoshizuEntity> ew = new EntityWrapper<DaoshizuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( daoshizu, "daoshizu")); 
        return R.ok().put("data", daoshizuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DaoshizuEntity daoshizu){
        EntityWrapper< DaoshizuEntity> ew = new EntityWrapper< DaoshizuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( daoshizu, "daoshizu")); 
		DaoshizuView daoshizuView =  daoshizuService.selectView(ew);
		return R.ok("查询导师组成功").put("data", daoshizuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DaoshizuEntity daoshizu = daoshizuService.selectById(id);
        return R.ok().put("data", daoshizu);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DaoshizuEntity daoshizu = daoshizuService.selectById(id);
        return R.ok().put("data", daoshizu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DaoshizuEntity daoshizu, HttpServletRequest request){
    	daoshizu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(daoshizu);

        daoshizuService.insert(daoshizu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DaoshizuEntity daoshizu, HttpServletRequest request){
    	daoshizu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(daoshizu);

        daoshizuService.insert(daoshizu);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DaoshizuEntity daoshizu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(daoshizu);
        daoshizuService.updateById(daoshizu);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        daoshizuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<DaoshizuEntity> wrapper = new EntityWrapper<DaoshizuEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = daoshizuService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
