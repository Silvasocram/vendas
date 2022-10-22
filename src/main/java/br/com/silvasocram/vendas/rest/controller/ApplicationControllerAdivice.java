package br.com.silvasocram.vendas.rest.controller;

import br.com.silvasocram.vendas.exception.RegraDeNegocioException;
import br.com.silvasocram.vendas.rest.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdivice {

    /* Vamos caputar a exception RegraDeNegocioException, toda vez que ela ocorrer,
    e vamos adicionar na nossa lista de exception.
    * */
    @ExceptionHandler(RegraDeNegocioException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleRegraNegocioException(RegraDeNegocioException regraDeNegocioException){

        String mensagemErro = regraDeNegocioException.getMessage();
        return new ApiErrors(mensagemErro);
    }
}
