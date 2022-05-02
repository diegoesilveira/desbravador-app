package br.com.desbravador.gestaoprojetosbackend.controller.v1.api;

import br.com.desbravador.gestaoprojetosbackend.controller.v1.adapter.MembroControllerAdapter;
import br.com.desbravador.gestaoprojetosbackend.controller.v1.dto.membro.MembrosDto;
import br.com.desbravador.gestaoprojetosbackend.controller.v1.dto.pessoa.PessoaDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@Api(value = "membro")
@RequestMapping(value = "/membros/v1")
public class MembroController {

    private final MembroControllerAdapter adapter;


    @ApiResponses(value = {
            @ApiResponse(code = 201, message = ""),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Failure", response = Exception.class)})
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MembrosDto> save(@RequestBody MembrosDto payload) {

        return new ResponseEntity<>(adapter.save(payload), HttpStatus.CREATED);
    }
}
