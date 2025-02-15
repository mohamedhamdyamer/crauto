FROM ubuntu:24.04

RUN apt-get update

RUN apt-get install --assume-yes yamllint
RUN apt-get install --assume-yes ansible-lint

RUN apt-get install --assume-yes python3-pip
RUN apt-get install --assume-yes pipx
RUN pipx install checkov
RUN pipx ensurepath

USER nobody

HEALTHCHECK NONE
