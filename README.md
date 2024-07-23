# SkillHub

SkillHub is a communication and exchange community platform designed to bridge information gaps and unify the platform for users. It enables users to enhance their knowledge, brush up on weak interview topics, practice with exercises, simulate interviews, and analyze resumes to improve their interview skills as programmers.

## Technical Architecture

SkillHub is built using a mainstream microservices framework and a contemporary client-side technology stack. The architecture includes:

- **SpringBoot**
- **SpringCloud Alibaba**
- **SSM**
- **MySQL**
- **Redis**
- **Nacos**
- **Gateway**
- **Minio**

## Key Features

- **Microservices Design**: 
  - The project is divided into four microservices using domain-driven design principles, ensuring business decoupling and focused responsibilities.
- **Service Registration and Discovery**: 
  - Nacos is used for service registration and discovery, and for dynamic configuration switching.
- **Authentication Framework**: 
  - Satoken is chosen over traditional security frameworks to improve development efficiency and ease of use.
- **Unified Authentication and Session Sharing**: 
  - Implemented using Gateway and Redis, with global exception handling at the gateway layer.
- **Automated Deployment**: 
  - Jenkins and shell scripts automate multi-machine deployment, addressing the pain point of manually dragging and dropping jar files.
- **Containerization**: 
  - Docker is used to containerize middleware, with data mounting for important data separation.
- **Model Building and Code Generation**: 
  - Metadata modeling with EasyCode enhances modeling efficiency and code generation.
- **WeChat Integration**: 
  - A dedicated WeChat microservice handles WeChat callbacks and SDK integration, providing a business-agnostic WeChat service.
- **Code Refactoring**: 
  - Utilized factory and strategy patterns to decouple WeChat message handling, and adapter pattern for OSS integration.
- **Environment Setup**: 
  - Independently set up the project environment and dependencies on cloud servers from scratch.

## Performance Enhancements

- **Concurrent Querying**: 
  - FutureTask and CompletableFuture are used for concurrent querying of classification tags, improving performance by 80%.
- **Custom Thread Factory**: 
  - Implemented to distinguish logs between thread pools, improving log tracing efficiency.
- **Thread Pool Stress Testing**: 
  - Collaborated with testers to determine optimal thread pool sizes and explore the relationship between thread pools and CPU.
- **Global User Context**: 
  - Utilized ThreadLocal with gateway and Feign interceptors to encapsulate a global user context tool.
- **High-Concurrency Interface Optimization**: 
  - Used Guava local cache with functional programming and generic local cache tools to enhance performance and generality.
- **Custom ES Client**: 
  - Supports multi-cluster and multi-index switching, and implements high-light search functionality.
- **Real-Time Leaderboard**: 
  - Implemented using Redis ZSet to overcome traditional database interaction bottlenecks.
- **Code Generator Component**: 
  - Developed to generate a complete set of base code from controller to DAO, improving development efficiency.
- **Like and Collect Functionality**: 
  - Implemented using XXL-Job with Redis hash interface for data persistence, reducing database interaction pressure.

## Getting Started

To get started with SkillHub, please follow the instructions below:

### Prerequisites

- Docker
- Jenkins
- MySQL
- Redis
- Nacos
- Minio

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/ShawnJeffersonWang/SkillHub.git
    ```

2. Navigate to the project directory:
    ```sh
    cd SkillHub
    ```

3. Set up Docker containers for middleware:
    ```sh
    docker-compose up -d
    ```

4. Configure Jenkins for automated deployment.

5. Start the microservices:
    ```sh
    ./start_services.sh
    ```

## Contributing

We welcome contributions! Please read our [Contributing Guidelines](CONTRIBUTING.md) for more information.

## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.
