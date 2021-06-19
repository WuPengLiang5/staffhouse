package com.example.staffhouse.controller;

import com.example.staffhouse.entity.PathDTO;
import com.example.staffhouse.entity.UserInfo;
import com.example.staffhouse.entity.Message;
import com.example.staffhouse.entity.UserLoginDTO;
import com.example.staffhouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
     *
     * @param userInfo
     * @return
     */
    @RequestMapping("/doLogin")
    public UserLoginDTO login(@RequestBody UserInfo userInfo) {
        UserInfo user = userService.getUserByLoginName(userInfo.getLoginName());
        String rawPassword = userInfo.getPassword();
        String rightPassword = user.getPassword();
        if (rawPassword.equalsIgnoreCase(rightPassword)) {
            UserLoginDTO userLoginDTO = new UserLoginDTO(user.getId(), user.getLoginName(), user.getStatus());
            return userLoginDTO;
        } else {
            UserLoginDTO userLoginDTO = new UserLoginDTO();
            userLoginDTO.setStatus(-1);
            userLoginDTO.setLoginName("notfound");
            return userLoginDTO;
        }
    }

    /**
     * 人脸登录
     *
     * @param base
     * @return
     */
    @RequestMapping("/faceLogin")
    public UserLoginDTO faceLogin(String base) {
        System.out.println(base);
        UserInfo loginUser = userService.faceLogin(base);
        return new UserLoginDTO(loginUser.getId(), loginUser.getLoginName(), loginUser.getStatus());
    }

    /**
     * 人脸注册
     *
     * @param base
     * @param userId
     * @return
     */
    @RequestMapping("/faceRegister")
    public @ResponseBody
    Message faceRegister(String base, Integer userId) {
        UserInfo loginUser = userService.getUserInfoById(userId);
        //把用户照片保存到本地
//        String path = request.getServletContext().getRealPath("/") + "headphoto\\";
//        String urlPath = request.getContextPath() + "/headphoto/" + loginUser.getId() + ".jpg";
//        PathDTO pathDTO = userService.writeImgToDisc(base, path, urlPath, loginUser);
        //更新人脸信息
//        userService.updateUserFace(pathDTO,loginUser);
        //生成返回信息
        Message message = new Message();
        message.setMessage("注册成功");
        return message;
    }

    /**
     * 更新密码
     *
     * @param map
     * @return
     */
    @RequestMapping("/updateUserPassword")
    public boolean updateUserPassword(@RequestBody Map<String, String> map) {
        String loginName = map.get("loginName");
        String password = map.get("password");
        String newPassword = map.get("newPassword");
        UserInfo userInfo = userService.getUserByLoginName(loginName);
        if (!userInfo.getPassword().equalsIgnoreCase(password)) {
            return false;
        } else {
            userInfo.setPassword(newPassword);
            userService.updateUserPassword(userInfo);
            return true;
        }
    }
}