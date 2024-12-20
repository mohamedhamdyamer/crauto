import com.cloudbees.plugins.credentials.*

def credsInstance = SystemCredentialsProvider.getInstance()

def creds = credsInstance.getCredentials()

for (c in creds) {
    println(c.getId())
    println(c.getDescription())
    println(c.getUsername())
    println(c.getPassword())
}
