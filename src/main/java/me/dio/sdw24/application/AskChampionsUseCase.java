package me.dio.sdw24.application;

import me.dio.sdw24.domain.exception.ChampionNotFoundException;
import me.dio.sdw24.domain.model.Champions;
import me.dio.sdw24.domain.ports.ChampionsRepository;



public record AskChampionsUseCase(ChampionsRepository repository) {

    public String askChampion(Long championId, String question) {

        Champions champion =repository.findById(championId)
                .orElseThrow(() -> new ChampionNotFoundException(championId));

        String championContext = champion.generateContextByQuestion(question);

        // TODO: Evoluir a lógica de negócio para considerar a integração com IAS Generativas.
        return championContext;

    }
}
