FROM mcr.microsoft.com/devcontainers/java:21

# Install additional packages needed for Fabric development
RUN apt-get update && export DEBIAN_FRONTEND=noninteractive \
    && apt-get -y install --no-install-recommends \
        curl \
        unzip \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

# Install Gradle
# Note: we need a specific version to match our project's wrapper
RUN curl -L https://services.gradle.org/distributions/gradle-8.5-bin.zip -o gradle.zip \
    && unzip gradle.zip \
    && mv gradle-8.5 /opt/gradle \
    && rm gradle.zip

# Add Gradle to PATH
ENV PATH=$PATH:/opt/gradle/bin