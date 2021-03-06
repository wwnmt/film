package com.wwn.film.film.dao;

import com.wwn.film.film.entity.FilmPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FilmPOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mooc_film_t
     *
     * @mbg.generated Thu Aug 06 14:38:21 CST 2020
     */
    int deleteByPrimaryKey(Integer uuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mooc_film_t
     *
     * @mbg.generated Thu Aug 06 14:38:21 CST 2020
     */
    int insert(FilmPO record);

    List<FilmPO> findByPager(Map<String, Object> params);

    List<FilmPO> getAllFilmByPage(@Param("currPage")Integer pageNo, @Param("pageSize")Integer pageSize);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mooc_film_t
     *
     * @mbg.generated Thu Aug 06 14:38:21 CST 2020
     */
    int insertSelective(FilmPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mooc_film_t
     *
     * @mbg.generated Thu Aug 06 14:38:21 CST 2020
     */
    FilmPO selectByPrimaryKey(Integer uuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mooc_film_t
     *
     * @mbg.generated Thu Aug 06 14:38:21 CST 2020
     */
    int updateByPrimaryKeySelective(FilmPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mooc_film_t
     *
     * @mbg.generated Thu Aug 06 14:38:21 CST 2020
     */
    int updateByPrimaryKey(FilmPO record);
}