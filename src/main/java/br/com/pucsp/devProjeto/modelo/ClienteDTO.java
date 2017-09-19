package br.com.pucsp.devProjeto.modelo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Cliente")
public class ClienteDTO {
	 @ApiModelProperty(value = "Id do cliente.", required=true)
	   private Long id;
	 
	   @ApiModelProperty(value = "Nome do cliente.")
	   private String nome;
}
