package com.wwn.film.film.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.wwn.film.api.service.film.FilmService;
import com.wwn.film.api.service.film.vo.BannerVO;
import com.wwn.film.api.service.film.vo.FilmInfo;
import com.wwn.film.api.service.film.vo.FilmVO;
import com.wwn.film.film.dao.BannerPOMapper;
import com.wwn.film.film.dao.FilmInfoPOMapper;
import com.wwn.film.film.dao.FilmPOMapper;
import com.wwn.film.film.entity.BannerPO;
import com.wwn.film.film.entity.FilmPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-06
 * Time: 14:41
 */
@Component
@Service(interfaceClass = FilmService.class)
public class FilmServiceImpl implements FilmService{

    @Autowired
    private BannerPOMapper bannerPOMapper;

    @Autowired
    private FilmPOMapper filmPOMapper;

    @Autowired
    private FilmInfoPOMapper filmInfoPOMapper;

    @Override
    public List<BannerVO> getBanners() {
        List<BannerPO> result = bannerPOMapper.selectList();
        List<BannerVO> bannerVOList = null;
        if (result != null && result.size() > 0)
            bannerVOList = result.parallelStream().map(bannerPO -> {
                BannerVO bannerVO = new BannerVO();
                bannerVO.setBannerId(bannerPO.getUuid()+"");
                bannerVO.setBannerUrl(bannerPO.getBannerUrl());
                bannerVO.setBannerAddress(bannerPO.getBannerAddress());
                return bannerVO;
            }).collect(Collectors.toList());
        return bannerVOList;
    }

    @Override
    public FilmVO getHotFilms(boolean isLimit, int nums) {
        return null;
    }

    @Override
    public FilmVO getSoonFilms(boolean isLimit, int nums) {
        return null;
    }

    @Override
    public List<FilmInfo> getBoxRanking() {
        return null;
    }

    @Override
    public List<FilmInfo> getExpectRanking() {
        return null;
    }

    @Override
    public List<FilmInfo> getTop() {
        return null;
    }

    @Override
    public FilmVO queryFilmsByArray(int currPage, int pageSize) {
//        Map<String, Object> data = new HashMap<>();
//        data.put("currIndex", (currPage-1)*pageSize);
//        data.put("pageSize", pageSize);
//        List<FilmPO> filmPOList = filmPOMapper.findByPager(data);
        List<FilmPO> filmPOList = filmPOMapper.getAllFilmByPage(currPage, pageSize);
        FilmVO filmVO = new FilmVO();
        List<FilmInfo> filmInfos = new ArrayList<>();
        for (FilmPO filmPO : filmPOList) {
            FilmInfo filmInfo = new FilmInfo();
            filmInfo.setFilmId(filmPO.getUuid()+"");
            filmInfo.setFilmName(filmPO.getFilmName());
            filmInfo.setFilmScore(filmPO.getFilmScore());
            filmInfos.add(filmInfo);
        }
        filmVO.setFilmInfos(filmInfos);
        filmVO.setFilmNum(filmInfos.size());
        return filmVO;
    }
}
