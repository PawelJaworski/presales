package pl.javorex.pm.project.application;

import pl.javorex.pm.project.application.api.response.ProjectInfoDto;
import pl.javorex.pm.project.domain.model.Project;
import pl.javorex.pm.project.domain.model.ProjectInfo;

final class ProjectInfoDtoFactory {
    ProjectInfoDto fromProject(Project project) {
        ProjectInfo projectInfo = project.getInfo();
        return new ProjectInfoDto() {
            @Override
            public String getID() {
                return project.getId();
            }

            @Override
            public String getName() {
                return projectInfo.getName();
            }

            @Override
            public String getDescription() {
                return projectInfo.getDescription();
            }
        };
    }
}
