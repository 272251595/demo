package com.panshi.demo.controller;

import com.panshi.demo.domain.UserDao;
import com.panshi.demo.domain.UserVo;
import com.panshi.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    @Autowired
    private UserService userSerivce;
 

    @GetMapping("/users")
    public UserVo query(@RequestParam("page") int page,@RequestParam("limit") int limit,@RequestParam("name") String name){
     
       
        UserVo query = userSerivce.query(page,limit,name);

        return query;
    }

    @PostMapping("/sevaUser")
    public UserVo stuAdd(@RequestBody UserDao user){
    	 try {
 			Thread.sleep(5000);
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
        UserVo vo = new UserVo();
        try {
            userSerivce.stuAdd(user);
            vo.setCode(1);
        }catch (Exception e){
            vo.setCode(0);
            vo.setMsg(e.getMessage());
        }
        return vo;
    }

    @DeleteMapping("/deleteUser/{ids}")
    public UserVo stuDelete(@PathVariable String ids) throws InterruptedException{
    	
    	Thread.sleep(5000);
        UserVo vo = new UserVo();
        try{
            userSerivce.stuDelete(ids);
            vo.setCode(1);
        }catch (Exception e){
            vo.setCode(0);
        }
        return vo;
    }

    
    @PutMapping("/updateUser")
    public UserVo updateUser(@RequestBody UserDao user) {
    	  UserVo vo = new UserVo();
          try{
        	  userSerivce.updateUser(user);
              vo.setCode(1);
          }catch (Exception e){
              vo.setCode(0);
          }
          return vo;
    	
    }


}
