import jenkins.model.*
import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.domains.*
import com.cloudbees.plugins.credentials.impl.*

def newCredsID = "github-creds"
def newCredsDescription = "GitHub Credentials"
def newCredsUsername = ""
def newCredsPassword = ""

def jenkins = Jenkins.get()

def credsInstance = SystemCredentialsProvider.getInstance()

def creds = credsInstance.getCredentials()

def githubCredsFound = false

for (c in creds) {
    if (c.getId() == "github-creds") {
        githubCredsFound = true
    }
}

if (!githubCredsFound) {
    def domain = Domain.global()
    def store = jenkins.getExtensionList('com.cloudbees.plugins.credentials.SystemCredentialsProvider')[0].getStore()
    def newCreds = new UsernamePasswordCredentialsImpl(CredentialsScope.GLOBAL, newCredsID, newCredsDescription, newCredsUsername, newCredsPassword)
    store.addCredentials(domain, newCreds)

    jenkins.save()
}
