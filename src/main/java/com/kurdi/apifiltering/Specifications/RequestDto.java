package com.kurdi.apifiltering.Specifications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {
    ArrayList<SearchRequestDto> searchRequestDtoList;
}
