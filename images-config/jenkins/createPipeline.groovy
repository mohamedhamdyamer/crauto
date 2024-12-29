import jenkins.model.*
import jenkins.branch.*
import org.jenkinsci.plugins.workflow.multibranch.*
import org.jenkinsci.plugins.github_branch_source.*

def jenkinsInstance = Jenkins.get()

def pipeline = jenkinsInstance.getItemByFullName("CR - Automate Recovery")

if (!pipeline) {

    def pipelineName = "CR - Automate Recovery"
    def pipelineDescription = "Cyber Recovery - Automating the recovery of Apps!"
    pipeline = new WorkflowMultiBranchProject(jenkinsInstance, pipelineName)
    pipeline.setDisplayName(pipelineName)
    pipeline.setDescription(pipelineDescription)

    def repoURL = "https://github.com/mohamedhamdyamer/crauto"
    def repoCredsID = "github-creds"
    def repo = new GitHubSCMSource("", "", repoURL, true)
    repo.setCredentialsId(repoCredsID)

    def trait = new BranchDiscoveryTrait(0)
    def traitsList = new ArrayList()
    traitsList.add(trait)
    repo.setTraits(traitsList)

    def branchSource = new BranchSource(repo)
    def branchSourcesList = new ArrayList()
    branchSourcesList.add(branchSource)
    pipeline.setSourcesList(branchSourcesList)

    def scriptPath = "pipelines/Jenkinsfile-app"
    def projectFactory = new WorkflowBranchProjectFactory()
    projectFactory.setScriptPath(scriptPath)
    pipeline.setProjectFactory(projectFactory)

    jenkinsInstance.add(pipeline, pipelineName)
    jenkinsInstance.save()
}
