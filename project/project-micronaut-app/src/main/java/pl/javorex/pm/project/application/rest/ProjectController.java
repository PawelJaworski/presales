package pl.javorex.pm.project.application.rest;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import pl.javorex.pm.project.application.api.ProjectQueryFacade;
import pl.javorex.pm.project.application.api.response.ProjectInfoDto;
import pl.javorex.pm.project.domain.model.ProjectInfo;

import java.util.List;
import java.util.Optional;

@Controller("/projects")
@Secured(SecurityRule.IS_ANONYMOUS)
public class ProjectController implements ProjectQueryFacade {
    private final ProjectQueryFacade queryFacade;

    ProjectController(ProjectQueryFacade queryFacade) {
        this.queryFacade = queryFacade;
    }

    @Override
    public Optional<ProjectInfoDto> findProjectInfo(String projectID) {
        return queryFacade.findProjectInfo(projectID);
    }

    @Get
    @Override
    public List<ProjectInfoDto> findAll() {
        return queryFacade.findAll();
    }
}
