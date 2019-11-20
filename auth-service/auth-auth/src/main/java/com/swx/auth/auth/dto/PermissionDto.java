package com.swx.auth.auth.dto;

import lombok.Data;

@Data
public class PermissionDto {

    private String id;

    private String code;

    private String name;

    private String permission;

    private String type;

    private String sort;

}