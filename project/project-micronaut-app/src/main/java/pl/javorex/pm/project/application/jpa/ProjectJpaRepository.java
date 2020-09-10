package pl.javorex.pm.project.application.jpa;

import pl.javorex.pm.project.domain.model.Project;
import pl.javorex.pm.project.domain.repository.ProjectRepository;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Singleton
public class ProjectJpaRepository implements ProjectRepository {
    private final EntityManager entityManager;

    public ProjectJpaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public Project save(Project project) {
        String projectID = project.getId();
        ProjectJpaEntity jpaEntity = entityManager.find( ProjectJpaEntity.class, projectID );
        if (jpaEntity == null) {
            entityManager.persist( ProjectJpaEntity.fromProject(project) );
        }


        return project;
    }

    @Override
    public List<Project> findAll() {
        return entityManager.createQuery("Select t from " + Project.class.getSimpleName() + " t")
                .getResultList();
    }

    @Override
    public Optional<Project> findProjectByID(String projectID) {
        return Optional
                .ofNullable(entityManager.find( ProjectJpaEntity.class, projectID ))
                .map(ProjectJpaEntity::toProject);
    }
}
