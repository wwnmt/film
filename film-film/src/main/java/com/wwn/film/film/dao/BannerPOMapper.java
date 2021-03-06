package com.wwn.film.film.dao;

import com.wwn.film.film.entity.BannerPO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerPOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mooc_banner_t
     *
     * @mbg.generated Thu Aug 06 14:38:21 CST 2020
     */
    int deleteByPrimaryKey(Integer uuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mooc_banner_t
     *
     * @mbg.generated Thu Aug 06 14:38:21 CST 2020
     */
    int insert(BannerPO record);


    List<BannerPO> selectList();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mooc_banner_t
     *
     * @mbg.generated Thu Aug 06 14:38:21 CST 2020
     */
    int insertSelective(BannerPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mooc_banner_t
     *
     * @mbg.generated Thu Aug 06 14:38:21 CST 2020
     */
    BannerPO selectByPrimaryKey(Integer uuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mooc_banner_t
     *
     * @mbg.generated Thu Aug 06 14:38:21 CST 2020
     */
    int updateByPrimaryKeySelective(BannerPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mooc_banner_t
     *
     * @mbg.generated Thu Aug 06 14:38:21 CST 2020
     */
    int updateByPrimaryKey(BannerPO record);
}