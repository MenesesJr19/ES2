package com.es2.decorator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Cria a instância base de autenticação
            AuthInterface auth = new Auth();

            // Adiciona o decorador de validação de palavras comuns
            auth = new CommonWordsValidator(auth);

            // Testa a autenticação com uma senha comum
            System.out.println("Testando autenticação com uma senha comum:");
            auth.auth("admin", "password"); // Isso deve lançar AuthException

        } catch (AuthException e) {
            System.out.println("Autenticação falhou: Senha é uma palavra comum.");
        } catch (IOException e) {
            System.out.println("Erro de I/O: " + e.getMessage());
        }
    }
}