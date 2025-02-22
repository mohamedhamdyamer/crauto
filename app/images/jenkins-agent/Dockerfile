FROM jenkins/inbound-agent:latest-jdk17

# Using the root user to install packages ...
USER root

# Installing "expect" ...
RUN apt-get update
RUN apt-get install --assume-yes expect

# Installing "wget" ...
RUN apt-get update
RUN apt-get install --assume-yes wget

# Installing "gpg" ...
# RUN apt-get update
# RUN apt-get install --assume-yes gpg

# Installing "Ansible" ...
# RUN wget -O- "https://keyserver.ubuntu.com/pks/lookup?fingerprint=on&op=get&search=0x6125E2A8C77F2818FB7BD15B93C4A3FD7BB9C367" | gpg --dearmour -o /usr/share/keyrings/ansible-archive-keyring.gpg
# RUN echo "deb [signed-by=/usr/share/keyrings/ansible-archive-keyring.gpg] http://ppa.launchpad.net/ansible/ansible/ubuntu jammy main" | tee /etc/apt/sources.list.d/ansible.list
# RUN apt-get update
# RUN apt-get install --assume-yes ansible

# Installing pipx
RUN apt-get update
RUN apt-get install --assume-yes pipx
RUN pipx ensurepath

# Switching back to user "jenkins" ...
USER jenkins

# Installing ansible, version: 2.11.12 ...
RUN pipx install --include-deps ansible-core==2.11.12
RUN pipx ensurepath

# Installing the Ansible collection ...
COPY galaxy.yml .
COPY *.tar.gz .
RUN my_version=`cat galaxy.yml | grep -i version | awk '{print $2}'` && /home/jenkins/.local/bin/ansible-galaxy collection install crauto-crauto-$my_version.tar.gz

HEALTHCHECK NONE
