package com.chinex.restendpoints.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class UserRequestDto {
    private String name;

    private String email;
}
