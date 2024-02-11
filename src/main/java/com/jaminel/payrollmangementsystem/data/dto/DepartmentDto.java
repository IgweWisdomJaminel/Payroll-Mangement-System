package com.jaminel.payrollmangementsystem.data.dto;

import lombok.*;

@Getter
@Setter
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class DepartmentDto {

    private String departmentName;

}

}
