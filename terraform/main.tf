provider "aws" {
  region = "eu-west-1"
}
terraform {
  backend "s3" {
    bucket = "consumer-service-tf"
    region = "eu-west-1"
    key    = "staging/consumer-service-state"
  }
}
variable "memory" {
  type = number
}
variable "memory_reservation" {
  type = number
}
variable "desired_count" {
  type = number
}

variable "cluster_name" {
  type = string
}

variable "IMAGE_TAG" {
  type = string
}

data "template_file" "task-def" {
  template = file("task-definition.json")

  vars = {
    memory             = var.memory
    memory_reservation = var.memory_reservation
    image_tag          = var.IMAGE_TAG
  }
}

resource "aws_ecs_task_definition" "consumer_service_task_def" {
  task_role_arn            = "arn:aws:iam::538653532257:role/ecs-task-default-role"
  requires_compatibilities = ["FARGATE"]
  network_mode             = "awsvpc"
  container_definitions    = data.template_file.task-def.rendered
  family                   = "consumer-service"
  memory                   = var.memory
  cpu                      = 256
  execution_role_arn       = "arn:aws:iam::538653532257:role/ecsTaskExecutionRole"
}

resource "aws_ecs_service" "consumer_service" {
  name            = "consumer-service"
  task_definition = aws_ecs_task_definition.consumer_service_task_def.arn
  desired_count   = var.desired_count
  cluster         = var.cluster_name
  launch_type     = "FARGATE"
  network_configuration {
    subnets         = ["subnet-178fd771", "subnet-af2144f5", "subnet-e1517aa9"]
    security_groups = ["sg-0b6c758f00d70d9a5", "sg-0f0b61f6ea9f636fb"]
  }
  load_balancer {
    target_group_arn = "arn:aws:elasticloadbalancing:eu-west-1:538653532257:targetgroup/consumer-service-target/398d6c2abaf384b3"
    container_name   = "consumer-service"
    container_port   = 8080
  }
}
