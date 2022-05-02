package br.com.desbravador.gestaoprojetosbackend.controller.v1.api;

import br.com.desbravador.gestaoprojetosbackend.controller.v1.adapter.PessoaControllerAdapter;
import br.com.desbravador.gestaoprojetosbackend.controller.v1.dto.pessoa.PessoaDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@Api(value = "pessoa")
@RequestMapping(value = "/pessoa/v1")
public class PessoaController {

    private final PessoaControllerAdapter adapter;

    @ApiResponses(value = {
            @ApiResponse(code = 201, message = ""),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Failure", response = Exception.class)})
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PessoaDto> save(@RequestBody PessoaDto payload) {

        return new ResponseEntity<>(adapter.save(payload), HttpStatus.CREATED);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = PessoaDto.class),
            @ApiResponse(code = 404, message = "Project not found"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Failure", response = Exception.class)})
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PessoaDto> update(@RequestBody PessoaDto payload) {

        return new ResponseEntity<>(adapter.update(payload), HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = PessoaDto.class),
            @ApiResponse(code = 404, message = "Project not found"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Failure", response = Exception.class)})
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {

        adapter.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Project not found"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Failure", response = Exception.class)})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PessoaDto>> findAll() {

        return new ResponseEntity<>(adapter.findAll(), HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Project not found"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Failure", response = Exception.class)})
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PessoaDto> findById(@PathVariable Long id) {

        return new ResponseEntity<>(adapter.findById(id), HttpStatus.OK);
    }







}
