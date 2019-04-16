package DAO;

import java.util.List;

import model.Project;

public interface ProjectDAO {
	
	List<Project> readProject();
	void creatProject(Project p);
    void updateProject(Project p);
    void deleteProject(Project p);
    
	
}
