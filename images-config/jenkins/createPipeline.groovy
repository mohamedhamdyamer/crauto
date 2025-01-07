import jenkins.model.*
import jenkins.branch.*
import org.jenkinsci.plugins.workflow.multibranch.*
import org.jenkinsci.plugins.github_branch_source.*

def pipelineName = "CR - Automate Recovery"
def pipelineDescription = "Cyber Recovery - Automating the recovery of Apps!"

def repoURL = System.getenv('Repo_URL')
def scriptPath = "pipelines/Jenkinsfile-app"
def repoCredsID = "github-creds"

def jenkins = Jenkins.get()

def pipeline = jenkins.getItemByFullName(pipelineName)

if (!pipeline) {
    pipeline = new WorkflowMultiBranchProject(jenkins, pipelineName)
    pipeline.setDisplayName(pipelineName)
    pipeline.setDescription(pipelineDescription)

    def repo = new GitHubSCMSource("", "", repoURL, true)
    repo.setCredentialsId(repoCredsID)

    def repoTrait = new BranchDiscoveryTrait(BranchDiscoveryTrait.ALL_BRANCHES)
    def traitsList = new ArrayList()
    traitsList.add(repoTrait)
    repo.setTraits(traitsList)

    def branchSource = new BranchSource(repo)
    def branchSourcesList = new ArrayList()
    branchSourcesList.add(branchSource)
    pipeline.setSourcesList(branchSourcesList)

    def projectFactory = new WorkflowBranchProjectFactory()
    projectFactory.setScriptPath(scriptPath)
    projectFactory.save()
    pipeline.setProjectFactory(projectFactory)
    pipeline.save()

    jenkins.add(pipeline, pipelineName)
    jenkins.save()
}
