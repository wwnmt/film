package com.wwn.film.api.service.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-06
 * Time: 11:21
 */
@Data
public class FilmInfo implements Serializable {

    private String filmId;

    private int fileType;

    private String imgAddress;

    private String filmName;

    private String filmScore;

    private int expectNum;

    private String showTime;

    private int boxNum;

    private String score;
}
