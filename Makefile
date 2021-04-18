include src/main/resources/application.properties
export

DOCKER_COMPOSE = cd docker && docker-compose -p history_application_backend

.PHONY: first
first: ## make env with example files
		cp ./src/main/resources/example.application.properties ./src/main/resources/application.properties
		cp ./docker/.env.example ./docker/.env
		mkdir -p ./src/main/resources/db/migration

.PHONY: flyway
flyway: ## run flyway, use 's' variable to select a service. make s=flywayInfo flyway
		./gradlew $(s)

.PHONY: start
start: erase build up ## clean current environment, recreate dependencies and spin up again

.PHONY: rebuild
rebuild: start ## same as start

.PHONY: erase
erase: ## stop and delete containers, clean volumes
		$(DOCKER_COMPOSE) stop
		$(DOCKER_COMPOSE) rm -v -f

.PHONY: build
build: ## build environment and initialize and project dependencies
		$(DOCKER_COMPOSE) build

.PHONY: up
up: ## spin up environment
		$(DOCKER_COMPOSE) up -d
