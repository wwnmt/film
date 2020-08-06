package com.wwn.film.film;

import com.wwn.film.api.service.film.FilmService;
import com.wwn.film.api.service.film.vo.FilmVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-06
 * Time: 15:48
 */
@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @ResponseBody
    @RequestMapping("/array/{currPage}/{pageSize}")
    public FilmVO getStudentByArray(@PathVariable("currPage") int currPage, @PathVariable("pageSize") int pageSize) {
        FilmVO filmVO = filmService.queryFilmsByArray(currPage, pageSize);
        return filmVO;
    }
}
