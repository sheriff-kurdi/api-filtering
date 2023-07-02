package com.kurdi.apifiltering.Specifications;

import com.kurdi.apifiltering.enums.SearchOperations;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequestDto {
    String column;
    String value;
    SearchOperations operation;
    String joinTable;
    SearchOperations joinTableOperation;



}
