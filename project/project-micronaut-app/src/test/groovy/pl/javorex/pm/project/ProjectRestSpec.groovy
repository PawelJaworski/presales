package pl.javorex.pm.project

import io.micronaut.data.model.query.QueryModel
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MicronautTest
import pl.javorex.pm.project.application.api.ProjectCommandFacade
import pl.javorex.pm.project.application.api.ProjectQueryFacade
import pl.javorex.pm.project.application.command.AddProjectCmd
import pl.javorex.pm.project.domain.model.ProjectInfo
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class ProjectRestSpec extends Specification {
    static final PROJECT_ID = "ID_of_Test_Project"
    static final PROJECT_NAME = "Test Project"
    static final PROJECT_DESC = "Description of Test Project"

    @Inject
    EmbeddedServer server;

    @Inject
    ProjectQueryFacade queryFacade

    @Inject
    ProjectCommandFacade commandFacade

    def "should create new project"() {
        when:
        AddProjectCmd cmd = new AddProjectCmd( PROJECT_ID, PROJECT_NAME, PROJECT_DESC )
        commandFacade.addProject(cmd)
        Optional<ProjectInfo> added = queryFacade.findProjectInfo(PROJECT_ID)
        then:
        added.isPresent()
        with(added.get()) {
            name == PROJECT_NAME
            description == PROJECT_DESC
        }
    }

    def "should throw exception when project added twice"() {
        when:
        AddProjectCmd cmd = new AddProjectCmd( PROJECT_ID, PROJECT_NAME, PROJECT_DESC )
        commandFacade.addProject(cmd)
        commandFacade.addProject(cmd)
        then:
        Exception thrown = thrown()
        thrown.message == "Cannot add project with ID ${PROJECT_ID}. Already exists."
    }
}
