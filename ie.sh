#!/bin/bash

# List of extensions to install
extensions=(
    "adpyke.vscode-sql-formatter"
    "bmewburn.vscode-intelephense-client"
    "devsense.composer-php-vscode"
    "devsense.intelli-php-vscode"
    "devsense.phptools-vscode"
    "devsense.profiler-php-vscode"
    "eamodio.gitlens"
    "esbenp.prettier-vscode"
    "formulahendry.code-runner"
    "humao.rest-client"
    "moalamri.inline-fold"
    "ms-python.debugpy"
    "ms-python.python"
    "ms-python.vscode-pylance"
    "ms-vscode.cmake-tools"
    "ms-vscode.cpptools"
    "ms-vscode.cpptools-extension-pack"
    "ms-vscode.cpptools-themes"
    "ms-vscode.live-server"
    "ms-vsliveshare.vsliveshare"
    "phind.phind"
    "pkief.material-icon-theme"
    "prisma.prisma"
    "redhat.java"
    "ritwickdey.liveserver"
    "svelte.svelte-vscode"
    "twxs.cmake"
    "vscjava.vscode-gradle"
    "vscjava.vscode-java-debug"
    "vscjava.vscode-java-pack"
    "vscjava.vscode-java-test"
    "wallabyjs.console-ninja"
    "xabikos.javascriptsnippets"
)

# Loop through each extension and install it
for extension in "${extensions[@]}"; do
    echo "Installing $extension..."
    code --install-extension "$extension"
done

echo "All extensions installed!"

# Give permission to execute the file
# chmod +x install-extensions.sh

# To run the shell file
# ./install-extensions.sh
