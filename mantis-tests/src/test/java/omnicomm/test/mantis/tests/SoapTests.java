package omnicomm.test.mantis.tests;

import omnicomm.test.mantis.model.Issue;
import omnicomm.test.mantis.model.Project;
import org.testng.annotations.Test;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

import static org.testng.AssertJUnit.assertEquals;

public class SoapTests extends TestBase {
  @Test
  public void testGetProjects() throws MalformedURLException, ServiceException, RemoteException {
    Set<Project> projects = app.soap().getProjects();
    System.out.println(projects.size());
    for (Project project : projects) {
      System.out.println(project.getName());
    }
  }

  @Test
  public void testCreateIssue() throws RemoteException, ServiceException, MalformedURLException {
    Project project = app.soap().getProjects().iterator().next();
    Issue issue = new Issue().withSubject("Test issue")
            .withDescription("Test issue description");
    Issue created = app.soap().addIssue(issue);
    assertEquals(issue.getSubject(), created.getSubject());
  }
}
