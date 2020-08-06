package com.wwn.film.gateway.modual.film;

import com.wwn.film.gateway.response.ResponseVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-06
 * Time: 11:04
 */

@RestController
@RequestMapping("/film/")
public class FilmController {

    /**
     * API网关：功能聚合
     *  1.多个接口，一次请求
     *  2.同一个接口对外暴露，降低前后端分离的开发难度
     * @return
     */
    @RequestMapping(value = "getIndex", method = RequestMethod.GET)
    public ResponseVO<?> getIndex() {
        //获取banner信息

        //获取正在热映的电影

        //获取即将上映的电影

        //票房排行榜

        //获取受欢迎的榜单

        //获取前100

        return null;
    }
}
