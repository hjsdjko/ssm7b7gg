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

import com.entity.WodexueshengEntity;
import com.entity.view.WodexueshengView;

import com.service.WodexueshengService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 我的学生
 * 后端接口
 * @author 
 * @email 
 * @date 2021-04-23 13:26:15
 */
@RestController
@RequestMapping("/wodexuesheng")
public class WodexueshengController {
    @Autowired
    private WodexueshengService wodexueshengService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WodexueshengEntity wodexuesheng, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("daoshi")) {
			wodexuesheng.setDaoshizhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			wodexuesheng.setXuegonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<WodexueshengEntity> ew = new EntityWrapper<WodexueshengEntity>();
		PageUtils page = wodexueshengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wodexuesheng), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WodexueshengEntity wodexuesheng, 
		HttpServletRequest request){
        EntityWrapper<WodexueshengEntity> ew = new EntityWrapper<WodexueshengEntity>();
		PageUtils page = wodexueshengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wodexuesheng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WodexueshengEntity wodexuesheng){
       	EntityWrapper<WodexueshengEntity> ew = new EntityWrapper<WodexueshengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( wodexuesheng, "wodexuesheng")); 
        return R.ok().put("data", wodexueshengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WodexueshengEntity wodexuesheng){
        EntityWrapper< WodexueshengEntity> ew = new EntityWrapper< WodexueshengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( wodexuesheng, "wodexuesheng")); 
		WodexueshengView wodexueshengView =  wodexueshengService.selectView(ew);
		return R.ok("查询我的学生成功").put("data", wodexueshengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WodexueshengEntity wodexuesheng = wodexueshengService.selectById(id);
        return R.ok().put("data", wodexuesheng);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WodexueshengEntity wodexuesheng = wodexueshengService.selectById(id);
        return R.ok().put("data", wodexuesheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WodexueshengEntity wodexuesheng, HttpServletRequest request){
    	wodexuesheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wodexuesheng);

        wodexueshengService.insert(wodexuesheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody WodexueshengEntity wodexuesheng, HttpServletRequest request){
    	wodexuesheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wodexuesheng);

        wodexueshengService.insert(wodexuesheng);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody WodexueshengEntity wodexuesheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wodexuesheng);
        wodexueshengService.updateById(wodexuesheng);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        wodexueshengService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<WodexueshengEntity> wrapper = new EntityWrapper<WodexueshengEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("daoshi")) {
			wrapper.eq("daoshizhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			wrapper.eq("xuegonghao", (String)request.getSession().getAttribute("username"));
		}

		int count = wodexueshengService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
