package pl.javorex.pm.project.application.jpa;

import pl.javorex.pm.project.domain.model.Project;
import pl.javorex.pm.project.domain.model.ProjectInfo;

import javax.persistence.*;

@Entity
@Table(name = "project")
public class ProjectJpaEntity {
    @Id
    private String id;

    @Embedded
    private ProjectInfoJpa projectInfo;

    public static ProjectJpaEntity fromProject(Project project) {
        ProjectInfo projectInfo = project.getInfo();
        return new ProjectJpaEntity(
                project.getId(),
                projectInfo.getName(),
                projectInfo.getDescription()
        );
    }

    private ProjectJpaEntity(String id, String name, String description) {
        this.id = id;
        this.projectInfo = new ProjectInfoJpa(name, description);
    }

    protected ProjectJpaEntity() {}

    Project toProject() {
        return new Project(id, projectInfo.getName(), projectInfo.getDescription());
    }
}
