FROM jenkins/jenkins:lts-jdk17

# Environment variables
## Disable the initial Setup Wizard
ENV JAVA_OPTS=-Djenkins.install.runSetupWizard=false

# Recommended Plugins
RUN jenkins-plugin-cli --plugins cloudbees-folder
RUN jenkins-plugin-cli --plugins antisamy-markup-formatter
RUN jenkins-plugin-cli --plugins build-timeout
RUN jenkins-plugin-cli --plugins credentials-binding
RUN jenkins-plugin-cli --plugins timestamper
RUN jenkins-plugin-cli --plugins ws-cleanup
RUN jenkins-plugin-cli --plugins ant
RUN jenkins-plugin-cli --plugins gradle
RUN jenkins-plugin-cli --plugins workflow-aggregator
RUN jenkins-plugin-cli --plugins github-branch-source
RUN jenkins-plugin-cli --plugins pipeline-github-lib
RUN jenkins-plugin-cli --plugins pipeline-graph-view
RUN jenkins-plugin-cli --plugins git
RUN jenkins-plugin-cli --plugins ssh-slaves
RUN jenkins-plugin-cli --plugins matrix-auth
RUN jenkins-plugin-cli --plugins pam-auth
RUN jenkins-plugin-cli --plugins ldap
RUN jenkins-plugin-cli --plugins email-ext
RUN jenkins-plugin-cli --plugins mailer
RUN jenkins-plugin-cli --plugins dark-theme

# Additional Plugins
RUN jenkins-plugin-cli --plugins docker-workflow
RUN jenkins-plugin-cli --plugins ansible
RUN jenkins-plugin-cli --plugins terraform

# Groovy scripts to run as part of the setup
COPY --chown=jenkins:jenkins setUrl.groovy /usr/share/jenkins/ref/init.groovy.d/setUrl.groovy
COPY --chown=jenkins:jenkins executors.groovy /usr/share/jenkins/ref/init.groovy.d/executors.groovy
COPY --chown=jenkins:jenkins setupSecurity.groovy /usr/share/jenkins/ref/init.groovy.d/setupSecurity.groovy
COPY --chown=jenkins:jenkins setupCredentials.groovy /usr/share/jenkins/ref/init.groovy.d/setupCredentials.groovy
