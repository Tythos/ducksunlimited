FROM mcr.microsoft.com/devcontainers/java:17

# Install additional packages
RUN apt-get update && export DEBIAN_FRONTEND=noninteractive \
    && apt-get -y install --no-install-recommends \
    git \
    curl \
    unzip \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

# Set up non-root user
ARG USERNAME=vscode
ARG USER_UID=1000
ARG USER_GID=$USER_UID

# Create the user
RUN groupadd --gid $USER_GID $USERNAME \
    && useradd --uid $USER_UID --gid $USER_GID -m $USERNAME \
    && apt-get update \
    && apt-get install -y sudo \
    && echo $USERNAME ALL=\(root\) NOPASSWD:ALL > /etc/sudoers.d/$USERNAME \
    && chmod 0440 /etc/sudoers.d/$USERNAME

# Set the default user
USER $USERNAME

# Install Gradle
RUN curl -L https://services.gradle.org/distributions/gradle-8.5-bin.zip -o gradle.zip \
    && unzip gradle.zip \
    && mv gradle-8.5 /home/$USERNAME/gradle \
    && rm gradle.zip

# Add Gradle to PATH
ENV PATH=$PATH:/home/$USERNAME/gradle/bin

# Configure Gradle home
ENV GRADLE_USER_HOME=/home/$USERNAME/.gradle
RUN mkdir -p $GRADLE_USER_HOME \
    && chown -R $USERNAME:$USERNAME $GRADLE_USER_HOME