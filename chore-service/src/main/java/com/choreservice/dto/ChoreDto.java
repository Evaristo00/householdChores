package com.choreservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChoreDto {
    private Integer point;
    private Boolean done;
    private Integer userId;
    private Integer homeId;
}
