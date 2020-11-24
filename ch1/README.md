# open JDK 14 설치

``` C
sudo mv openjdk-14.0.1_osx-x64_bin.tar.gz /Library/Java/JavaVirtualMachines/
cd /Library/Java/JavaVirtualMachines/
sudo tar -xzf openjdk-14.0.1_osx-x64_bin.tar.gz
sudo rm openjdk-14.0.1_osx-x64_bin.tar.gz
``` 

``` C
$ /usr/libexec/java_home -v14
/Library/Java/JavaVirtualMachines/jdk-14.0.1.jdk/Contents/Home
```

``` C
echo -n "\nexport JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-14.0.1.jdk/Contents/Home" >> ~/.bash_profile
```

``` C
source ~/.bash_profile
```