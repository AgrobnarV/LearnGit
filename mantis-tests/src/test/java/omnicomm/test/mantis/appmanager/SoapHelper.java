package omnicomm.test.mantis.appmanager;

import biz.futureware.mantis.rpc.soap.client.*;
import omnicomm.test.mantis.model.Issue;
import omnicomm.test.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class SoapHelper {
  private ApplicationManager app;

  public SoapHelper(ApplicationManager app) {
    this.app = app;
  }

  public Set<Project> getProjects() throws MalformedURLException, ServiceException, RemoteException {
    MantisConnectPortType mc = getMantisConnect();
    ProjectData[] projects = mc.mc_projects_get_user_accessible("administrator", "123456");
    return Arrays.asList(projects).stream()
            .map((p) -> new Project().withId(p.getId().intValue()).withName(p.getName()))
            .collect(Collectors.toSet());
  }

  public Issue addIssue(Issue issue) throws MalformedURLException, ServiceException, RemoteException {
    MantisConnectPortType mc = getMantisConnect();
    String[] categories = mc.mc_project_get_categories("administrator", "123456", BigInteger.valueOf(issue.getId()));
    IssueData issueData = new IssueData();
    issueData.setSummary(issue.getSubject());
    issueData.setDescription(issue.getDescription());
    issueData.setProject(new ObjectRef(BigInteger.valueOf(issue.getId()), issue.getState_name()));
    issueData.setCategory(categories[0]);
    BigInteger issueId = mc.mc_issue_add("administrator", "123456", issueData);
    IssueData createdIssueData = mc.mc_issue_get("administrator", "123456", issueId);
    return new Issue().withId(createdIssueData.getId().intValue())
            .withSubject(createdIssueData.getSummary())
            .withDescription(createdIssueData.getDescription())
            .withId(createdIssueData.getProject().getId().intValue())
            .withState_name(createdIssueData.getProject().getName());
  }

  private MantisConnectPortType getMantisConnect() throws MalformedURLException, ServiceException {
    return new MantisConnectLocator()
            .getMantisConnectPort(new URL(app.getProperty("http://localhost/mantisbt-2.21.1/api/soap/mantisconnect.wsdl")));
  }

  public Issue issueStatus(int issueId) throws MalformedURLException, ServiceException, RemoteException {
    MantisConnectPortType mc = getMantisConnect();
    IssueData currentIssue = mc.mc_issue_get("administrator", "123456", BigInteger.valueOf(issueId));
    return new Issue().withState_name(currentIssue.getStatus().toString());
  }
}
