package com.wwn.film.api.service.film;

import com.wwn.film.api.service.film.vo.BannerVO;
import com.wwn.film.api.service.film.vo.FilmInfo;
import com.wwn.film.api.service.film.vo.FilmVO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-06
 * Time: 14:27
 */
public interface FilmService {

    //获取banner信息
    List<BannerVO> getBanners();

    //获取正在热映的电影
    FilmVO getHotFilms(boolean isLimit, int nums);

    //获取即将上映的电影
    FilmVO getSoonFilms(boolean isLimit, int nums);

    //票房排行榜
    List<FilmInfo> getBoxRanking();

    //获取受欢迎的榜单
    List<FilmInfo> getExpectRanking();

    //获取前100
    List<FilmInfo> getTop();

    FilmVO queryFilmsByArray(int currPage, int pageSize);
}
