package br.com.alura;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.service.AbrigoService;
import java.io.IOException;

public class ListarAbrigoCommand implements Command{

    @Override
    public void execute() {
        try {
            ClientHttpConfiguration clientHttpConfiguration = new ClientHttpConfiguration();
            AbrigoService abrigoService = new AbrigoService(clientHttpConfiguration);
            abrigoService.listarAbrigo();
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao listar abrigos: " + e.getMessage());
        }
    }
}
