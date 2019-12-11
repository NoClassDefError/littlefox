package org.cie.littlefox.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private String username;
    private String password;
    private boolean isManager;
    private boolean isClient;
}
