package pl.javorex.pm.wbsdiagram.application.config;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import pl.javorex.pm.wbs.diagram.application.api.WbsDiagramCommandFacade;
import pl.javorex.pm.wbs.diagram.application.api.WbsDiagramQueryFacade;
import pl.javorex.pm.wbsdiagram.application.WbsDiagramServiceConfig;
import pl.javorex.pm.wbsdiagram.application.adapter.WbsDiagramRepositoryInMemoryImpl;

@Factory
class WbsDiagramServiceFactory {
    @Bean
    WbsDiagramQueryFacade projectQueryFacade() {
        return config().wbsDiagramQueryFacade;
    }

    @Bean
    WbsDiagramCommandFacade projectCommandFacade() {
        return config().wbsDiagramCommandFacade;
    }

    @Bean
    WbsDiagramServiceConfig config() {
        return new WbsDiagramServiceConfig(new WbsDiagramRepositoryInMemoryImpl());
    }
}
