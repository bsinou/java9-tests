# HowTos for Java 9

## Install java 9 on centOs

Download java9 from [Oracle website](http://www.oracle.com/technetwork/java/javase/downloads/index-jsp-138363.html)
 
```cd ~/Downloads
tar -zxvf jdk-9.0.1_linux-x64_bin.tar.gz 
sudo mv jdk-9.0.1 /opt/
# update alternative 
 sudo alternatives --install /usr/bin/java java /opt/jdk-9.0.1/bin/java 3
# insure the correct java is used
alternatives --config java
```

 