package com.drg.koolping.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by durdan on 30/10/2015.
 */

@Data
@Document(collection = "taskCategories")
public class TaskCategoryEntity {

    @Id
    private String Id;
    private String taskType;
    private String taskDescription;
    private String taskImageName;


}
