package com.works.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iid;

    private String username;
    private String roles;
    private String url;
    private String sessionID;
    private String time;
    private String userAgent;

    public Info(String username, String roles, String url, String sessionID, String time, String userAgent) {
        this.username = username;
        this.roles = roles;
        this.url = url;
        this.sessionID = sessionID;
        this.time = time;
        this.userAgent = userAgent;
    }
}
