package com.api.springboot.exception;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.NoSuchElementException;

@Component
public class GlobalExceptionFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (IllegalArgumentException ex) {
            logger.warn("Erro de validação: {}", ex.getMessage());
            response.sendError(HttpStatus.UNPROCESSABLE_ENTITY.value(), ex.getMessage());
        } catch (NoSuchElementException ex) {
            logger.warn("Recurso não encontrado: {}", ex.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        } catch (Exception ex) {
            logger.error("Erro interno do servidor: ", ex);
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erro interno de servidor");
        }
    }
}
