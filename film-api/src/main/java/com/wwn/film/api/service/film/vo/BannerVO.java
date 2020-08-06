package com.wwn.film.api.service.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-06
 * Time: 11:17
 */
@Data
public class BannerVO implements Serializable {

    private String bannerId;

    private String bannerAddress;

    private String bannerUrl;
}
