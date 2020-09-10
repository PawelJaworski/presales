package pl.javorex.pm.project.application.config;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import pl.javorex.pm.project.application.ProjectServiceConfig;
import pl.javorex.pm.project.application.adapter.ProjectRepositoryInMemoryImpl;
import pl.javorex.pm.project.application.api.ProjectCommandFacade;
import pl.javorex.pm.project.application.api.ProjectQueryFacade;
import pl.javorex.pm.project.application.jpa.ProjectJpaRepository;

@Factory
class ProjectServiceFactory {
//    private final ProjectJpaRepository projectRepository;
//
//    ProjectServiceFactory(ProjectJpaRepository projectRepository) {
//        this.projectRepository = projectRepository;
//    }

    @Bean
    ProjectQueryFacade projectQueryFacade() {
        return config().projectQueryFacade;
    }

    @Bean
    ProjectCommandFacade projectCommandFacade() {
        return config().projectCommandFacade;
    }

    @Bean
    ProjectServiceConfig config() {
        return new ProjectServiceConfig(new ProjectRepositoryInMemoryImpl());
    }
}
