package pl.javorex.pm.project.application.jpa;

import pl.javorex.pm.project.domain.model.ProjectInfo;

import javax.persistence.*;

@Embeddable
class ProjectInfoJpa {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    ProjectInfoJpa(String name, String description) {
        this.name = name;
        this.description = description;
    }

    protected ProjectInfoJpa() {}

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

