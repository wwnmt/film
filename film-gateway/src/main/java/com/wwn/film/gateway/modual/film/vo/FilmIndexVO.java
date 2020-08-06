package com.wwn.film.gateway.modual.film.vo;

import com.wwn.film.api.service.film.vo.BannerVO;
import com.wwn.film.api.service.film.vo.FilmInfo;
import com.wwn.film.api.service.film.vo.FilmVO;
import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-06
 * Time: 11:12
 */
@Data
public class FilmIndexVO {

    private List<BannerVO> banners;

    private FilmVO hostFilms;

    private FilmVO soonFilms;

    private List<FilmInfo> boxRanking;

    private List<FilmInfo> expectRanking;

    private List<FilmInfo> top100;
}
