import jenkins.model.*
import io.jenkins.docker.client.*
import io.jenkins.docker.connector.*
import org.jenkinsci.plugins.docker.commons.credentials.*
import com.nirima.jenkins.plugins.docker.*

def dockerCloudName = "crauto-docker-host"
def dockerHostUri = "tcp://192.168.1.211:2375"
def imageName = "jenkins/inbound-agent:latest-jdk17"
def dockerTemplateName = "crauto-dockerized-jenkins-agent"

def jenkins = Jenkins.get()

def dockerCloud = jenkins.clouds.getByName(dockerCloudName)

if (!dockerCloud) {
    def dockerTemplateBase = new DockerTemplateBase(imageName)

    def connector = new DockerComputerAttachConnector()

    def dockerTemplate = new DockerTemplate(dockerTemplateBase, connector, dockerTemplateName, "")

    dockerTemplate.setName(dockerTemplateName)
    dockerTemplate.setMode(hudson.model.Node.Mode.EXCLUSIVE)
    dockerTemplate.setPullStrategy(DockerImagePullStrategy.PULL_NEVER)

    def dockerTemplatesList = new ArrayList()
    dockerTemplatesList.add(dockerTemplate)

    def dockerHost = new DockerServerEndpoint(dockerHostUri, null)
    def dockerApi = new DockerAPI(dockerHost)

    dockerCloud = new DockerCloud(dockerCloudName, dockerApi, dockerTemplatesList)
    jenkins.clouds.add(dockerCloud)
    jenkins.save()
}
