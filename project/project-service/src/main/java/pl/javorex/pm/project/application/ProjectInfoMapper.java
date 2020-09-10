package pl.javorex.pm.project.application;

import pl.javorex.pm.project.application.api.response.ProjectInfoDto;
import pl.javorex.pm.project.domain.model.ProjectInfo;

final class ProjectInfoMapper {
    ProjectInfoDto map(ProjectInfo projectInfo) {
        return new ProjectInfoDto() {
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
