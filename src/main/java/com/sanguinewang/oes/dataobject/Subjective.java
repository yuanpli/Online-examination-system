package com.sanguinewang.oes.dataobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @Description
 * @Author SanguineWang
 * @Date 2020-07-03 14:17
 */
@Data
@Entity
@NoArgsConstructor
public class Subjective {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //题目
    private String title;
    //答案
    private String answer;
    //分数
    private Float score;
    /**
     * 自动插入时间
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(columnDefinition = "timestamp default current_timestamp",
            insertable = false,
            updatable = false)
    private LocalDateTime insertTime;

    /**
     * 题目与考试多对一关系
     */
    @ManyToOne
    @ToString.Exclude
    private Exam exam;

}
