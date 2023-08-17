package com.example.tutorialv2.data.vo.v1;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class PerfilVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private long idPerfil;
    private String nome;

}
