package com.wwn.film.api.service.mybatis;

import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-06
 * Time: 15:09
 */
@Data
public class Page<T> {

    private int page;   //分页起始页

    private int size;   //每页记录数

    private List<T> rows;   //返回的记录集合

    private long total; //总记录条数
}
