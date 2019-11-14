/**  
* <p>Title: TestController</p>  
* <p>Description: </p>  
* @author lvchunhui 
* @date 2019年9月8日  

*/
package com.example.simple.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.simple.bean.Resp;
import com.example.simple.service.HelloService;
import com.example.simple.util.LogUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



/**
 * 
 * @author lvchunhui
 * @date 2019年11月8日
 */

@Api(tags="测试接口模块")
@RestController
@RequestMapping("/hello")
public class HelloController {
	@Autowired
	HelloService helloService;
	
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String get() {
		Logger log = LogUtils.getExceptionLogger();
    	Logger log1 = LogUtils.getBussinessLogger();
    	Logger log2 = LogUtils.getDBLogger();
    	log.error("getExceptionLogger===日志测试");
    	log1.info("getBussinessLogger===日志测试");
    	log2.debug("getDBLogger===日志测试");

		return "hello!!";

	}

	
	@ApiOperation(value="获取用户信息", notes = "获取用户信息")
	@RequestMapping(value = "/get/person/list", method = RequestMethod.GET)
	public Resp getPersonList() {
	
		return helloService.getPersonList();

	}
	

//	@RequestMapping(value = "/upload/image", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//	public ResponWXData upload(@RequestParam("file") MultipartFile file) {
//		ResponWXData resp = new ResponWXData();
//		if (file.isEmpty()) {
//			resp.setCode("400");
//			resp.setMsg("文件为空");
//		}
//		System.out.println("44444$$$$$");
//		// 图片转base64
//		InputStream inputStream = null;
//		byte[] data = null;
//		try {
//			inputStream = file.getInputStream();
//			data = new byte[inputStream.available()];
//			inputStream.read(data);
//			inputStream.close();
//			// 加密
//			Encoder encoder = Base64.getEncoder();
//			String base64 = encoder.encodeToString(data);
//			System.out.println(base64.length());
//			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//			nettyMapper.addPersonPic(uuid, base64);
//			resp.setCode("200");
//			resp.setMsg("success");
//			resp.setData(uuid);
//		} catch (Exception e) {
//			e.printStackTrace();
//			resp.setCode("500");
//			resp.setMsg("服务器凉了");
//		}
//		return resp;
//
//	}

//	@RequestMapping(value = "/add/person", method = RequestMethod.POST)
//	@Transactional
//	public ResponWXData wxAddPerson(@RequestBody Person person) {
//		ResponWXData resp = new ResponWXData();
//		System.out.println("4ukjly$$$$");
//		String startTime=person.getValid()+" 00:00";
//		String endTime=person.getPasstime()+" 23:59";
//		//默认全时段
//		String passTime = "[{\"endTime\":\"23:59\",\"startTime\":\"00:00\"}]";
//		person.setValid(startTime+","+endTime);
//		person.setPasstime(passTime);
//		try {
//			// 添加人员
//			nettyMapper.addPerson(person);
//			// 添加申请记录
//			nettyMapper.addApply(person);
//			// 人脸设备添加指令发出
//			// nettyService.sendMesgToDevices(person, "person_add_feature",
//			// person.getCompany());
//			resp.setCode("200");
//			resp.setMsg("success");
//			resp.setData(null);
//		} catch (Exception e) {
//			e.printStackTrace();
//			resp.setCode("500");
//			resp.setMsg("服务器凉了");
//		}
//		return resp;
//
//	}
//
//	@RequestMapping(value = "/is/agree/apply", method = RequestMethod.GET)
//	@Transactional
//	public ResponWXData wxIsAgreeApply(@RequestParam("applyId") Integer applyId,
//			@RequestParam("isAgree") String isAgree) {
//		ResponWXData resp = new ResponWXData();
//		System.out.println("4ukjly$$$$");
//		try {
//
//			// 同意通过
//			
//				nettyMapper.wxIsAgreeApply(applyId,isAgree);
//				if("yes".equals(isAgree)) {
//					Person person = nettyMapper.getPersonById(applyId);
//					nettyService.sendMesgToDevices(person, "person_add_feature", person.getCompany());
//				}
//				// 人脸设备添加指令发出
//				resp.setCode("200");
//				resp.setMsg("success");
//				resp.setData(null);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			resp.setCode("500");
//			resp.setMsg("服务器凉了");
//		}
//		return resp;
//
//	}
//
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public ResponWXData wxlogin(@RequestBody LoginInfo loginInfo) {
//		ResponWXData resp = new ResponWXData();
//		try {
//			LoginInfo loginMa = nettyMapper.wxlogin(loginInfo);
//			if (loginMa == null) {
//				resp.setCode("400");
//				resp.setMsg("用户名不存在");
//			} else {
//				if (loginInfo.getPassword().equals(loginMa.getPassword())) {
//					resp.setCode("200");
//					resp.setMsg("success");
//					resp.setData(loginMa.getNotes());
//				} else {
//					resp.setCode("400");
//					resp.setMsg("密码不正确");
//				}
//			}
//			// 人脸设备添加指令发出
////        	nettyService.sendMesgToDevices(person, "person_add_feature", person.getCompany());
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			resp.setCode("500");
//			resp.setMsg("服务器凉了");
//		}
//		return resp;
//
//	}

	
}
