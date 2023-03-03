package com.vytrack.pages.Notes;public class LinuxCode_EC_AWS {}/*



Isa Mammadov
Hi Isa
Dashboard
Courses
Bookmarks
Calendar
Provide Feedback
©2023 Cydeo - All Rights Reserved

Terms of Use | Privacy Policy

Search

CLASS NOTES 11/07/2020
Today is November 7, 2020

- Selenium Grid
NOTE: there are couple short videos about selenium grid on Canvas. Please check them on your spare time.

- AWS
- Docker

###########################################

Selenium Grid - used for remote test execution. The goal is to reduce execution time.

hub - manager, distributes tests
node - executes tests. Can be located on multiple servers (machines).

only 1 hub and 1 or more nodes.


Amazon Linux 2 AMI (HVM), SSD Volume Type - ami-0947d2ba12ee1ff75 (64-bit x86) / ami-007a607c4abd192db (64-bit Arm)


#!/bin/bash
sudo yum update -y &&
sudo amazon-linux-extras install -y docker &&
sudo service docker start &&
sudo usermod -a -G docker ec2-user &&
sudo chkconfig docker on &&
sudo yum install -y git &&
sudo curl -L https://github.com/docker/compose/releases/latest/download/docker-compose-$(uname -s)-$(uname -m) -o /usr/local/bin/docker-compose &&
sudo chmod +x /usr/local/bin/docker-compose &&
docker-compose version &&
sudo curl -L https://cybertek-shared.s3.amazonaws.com/docker-compose.yml -o /home/ec2-user/docker-compose.yml &&
sudo reboot



docker-compose scale chrome=25
docker-compose scale firefox=25

- created AWS EC2 instance

break until 3:30 EST

ls - view directory
pwd - print work directory
whoami - current user name
cat <file_name> - view the file, not modify
clear - delete console output

HINT: use tab to auto-complete file name

docker-compose up -d | to start docker containers

docker-compose down | to stop containers

docker ps | view list of running containers

-d | (detached mode) don't print output from container


*/



