import jenkins.model.*
import hudson.model.*
import hudson.tasks.*
import hudson.security.*

def instance = Jenkins.get()

def realm = instance.getSecurityRealm()
def realmType = realm.getClass().toString()

if (realmType != "class hudson.security.HudsonPrivateSecurityRealm") {

    realm = new HudsonPrivateSecurityRealm(false)

    def username = "admin"
    def password = "changeme"
    def userDescription = "Admin Account"
    def userEmail = "admin@cr.app"

    def user = realm.createAccount(username, password)
    user.setFullName(username)
    user.setDescription(userDescription)
    user.addProperty(new Mailer.UserProperty(userEmail))

    instance.setSecurityRealm(realm)

    def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
    strategy.setAllowAnonymousRead(false)
    instance.setAuthorizationStrategy(strategy)

    instance.save()
}
