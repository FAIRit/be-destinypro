package com.github.fairit.be_doyou_destinypro.dto.player;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Player {

    @NotBlank
    @Size(min = 3, max = 255)
    private String nickname;

    public String getNickname() {
        return nickname;
    }
}
