import org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject
import jenkins.branch.MultiBranchProject
import com.cloudbees.hudson.plugins.folder.properties.AuthorizationMatrixProperty
import org.jenkinsci.plugins.workflow.job.*
import com.cloudbees.hudson.plugins.folder.*
import hudson.security.Permission
import com.cloudbees.plugins.credentials.CredentialsProvider
import jenkins.model.*
import hudson.security.*

def env = System.getenv()
def jenkins = Jenkins.getInstance()

//Add a default user to the Jenkins Master
def rootUser = jenkins.getSecurityRealm().createAccount(env['DEFAULT_JENKINS_USER'], env['DEFAULT_JENKINS_PASSWORD'])
rootUser.save()

//Set user as admin
jenkins.getAuthorizationStrategy().add(Jenkins.ADMINISTER, env.JENKINS_USER)

jenkins.save()
