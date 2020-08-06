package com.wwn.film.api.service.film.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-06
 * Time: 11:19
 */
@Data
public class FilmVO implements Serializable {

    private int filmNum;

    private List<FilmInfo> filmInfos;
}
