package br.com.alura.adopet.api.service.validacoes;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import br.com.alura.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ValidacaoPetComAdocaoEmAndamento implements ValidacaoSolicitacaoAdocao{

    @Autowired
    private AdocaoRepository adocaoRepository;

    @Autowired
    private PetRepository petRepository;

    public void validar(SolicitacaoAdocaoDTO dto){
        List<Adocao> adocoes = adocaoRepository.findAll();
        Pet pet = petRepository.getReferenceById(dto.idPet());

        for(Adocao adocao : adocoes){
            if(adocao.getPet() == pet && adocao.getStatus() == StatusAdocao.AGUARDANDO_AVALIACAO){
                throw new ValidacaoException("Pet já está aguardando avaliação para ser adotado!");
            }
        }
    }
}
