package com.example.staffhouse.controller;

import com.example.staffhouse.entity.PathDTO;
import com.example.staffhouse.entity.UserInfo;
import com.example.staffhouse.entity.Message;
import com.example.staffhouse.entity.UserLoginDTO;
import com.example.staffhouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.FileNotFoundException;
import java.util.Map;

/**
 * @author NIIT
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param session
     * @param userInfo
     * @return
     */
    @RequestMapping("/doLogin")
    public UserInfo login(HttpSession session,@RequestBody UserInfo userInfo){
        UserInfo user = userService.getUserByLoginName(userInfo.getLoginName());
        String rawPassword = userInfo.getPassword();
        System.out.println(user.getLoginName());
        String rightPassword = user.getPassword();
        System.out.println(rightPassword);
        if (rawPassword.equalsIgnoreCase(rightPassword)){
            user.setPassword("");
            return user;
        }
        else{
            UserInfo user_not = new UserInfo();
            user_not.setStatus(-1);
            user_not.setUserName("notfound");
            user_not.setLoginName("notfound");
            return user_not;
        }
    }

    /**
     * 人脸登录
     * @param base
     * @return
     */
    @RequestMapping("/faceLogin")
    public UserLoginDTO faceLogin(@RequestParam String base){
        System.out.println(base);
        UserInfo loginUser = userService.faceLogin(base);
        return new UserLoginDTO(loginUser.getId(), loginUser.getLoginName(), loginUser.getStatus());
    }

    /**
     *
     * @param map
     * @return
     * @throws FileNotFoundException
     */
    @RequestMapping("/faceRegister")
    public @ResponseBody Message faceRegister(@RequestBody Map<String, String> map) throws FileNotFoundException {
        System.out.println(map);
        String base = map.get("base");
        String userId = map.get("userId");
        UserInfo loginUser = userService.getUserInfoById(Integer.valueOf(userId));
        System.out.println(base);
        //把用户照片保存到本地
        String path = ResourceUtils.getURL("src/main/resources/static/faceImage/").getPath();
        System.out.println(path);
        String urlPath = path + loginUser.getId() + ".jpg";
        PathDTO pathDTO = userService.writeImgToDisc(base, path, urlPath, loginUser);
        //更新人脸信息
        userService.updateUserFace(pathDTO,loginUser);
        //生成返回信息
        Message message = new Message();
        message.setMessage("注册成功");
        return message;
    }

    /**
     * 更新密码
     * @param loginName
     * @param password
     * @param newPassword
     * @return
     */
    @RequestMapping("/updateUserPassword")
    public boolean updateUserPassword(@RequestParam String loginName,
                                       @RequestParam String password,
                                       @RequestParam String newPassword){
        UserInfo userInfo=userService.getUserByLoginName(loginName);
        if (userInfo.getPassword()!=password){
            return false;
        }
        return true;
    }
}