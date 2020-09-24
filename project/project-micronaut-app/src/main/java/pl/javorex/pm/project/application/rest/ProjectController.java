package pl.javorex.pm.project.application.rest;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import pl.javorex.pm.project.application.api.ProjectQueryFacade;
import pl.javorex.pm.project.application.response.ProjectInfoDto;

import java.util.List;
import java.util.Optional;

@Controller("/projects")
@Secured(SecurityRule.IS_ANONYMOUS)
public class ProjectController implements ProjectQueryFacade {
    private final ProjectQueryFacade queryFacade;

    ProjectController(ProjectQueryFacade queryFacade) {
        this.queryFacade = queryFacade;
    }

    @Get("/{projectId}")
    @Override
    public Optional<ProjectInfoDto> findProjectInfo(@PathVariable  String projectId) {
        return queryFacade.findProjectInfo(projectId);
    }

    @Get
    @Override
    public List<ProjectInfoDto> findAll() {
        return queryFacade.findAll();
    }
}
