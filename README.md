# Notizen App

A simple web application for creating, editing, and deleting notes (“Notizen”), built with Spring Boot, Spring Data JPA, and H2.

---

## Features

- **Create** new notes with a title and description
- **Read** a list of all notes
- **Update** existing notes (edit title or description)
- **Delete** notes
- **Timestamps** for created_at and updated_at

---

## Tech Stack

- **Java 17** (or Java 11 with adjusted compiler settings)
- **Spring Boot** 3.x
- **Spring Data JPA** (Hibernate)
- **H2** in-memory database (for tests and “test” profile)
- **Lombok** for boilerplate reduction
- **JUnit 5** + **Mockito** for unit testing
- **Maven** for build and dependency management
- **GitHub Actions** for CI/CD

---

## Prerequisites

- JDK 17 (or JDK 11 if you set `<release>11</release>` in your `pom.xml`)
- Maven 3.8+
- Git

---

## Getting Started

1. **Clone the repo**
   ```bash
   git clone https://github.com/Wieser145/Raika_code_challenge.git
