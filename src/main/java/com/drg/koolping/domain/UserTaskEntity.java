package com.drg.koolping.domain;

import com.sun.javafx.beans.IDProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by durdan on 30/10/2015.
 */

@Data
@Document(collection="userTasks")
public class UserTaskEntity {
    @Id
    private long Id;
    private String userEmailId;
    private String taskType;
    private String taskDetail;
    private String postCodezipcode;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date submittedDate;
    private int isAutoRenewal;
}
