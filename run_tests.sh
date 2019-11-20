#!/bin/bash
cd src
javac -cp "lib/*:." test/*.java
java -cp "lib/*:." org.junit.platform.console.ConsoleLauncher --disable-ansi-colors --details=tree -p=test
