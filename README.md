# URL Shortener

A full-stack URL shortener application built with React for the frontend and Spring Boot for the backend.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)

## Features

- Shorten long URLs with a simple user interface
- Efficient URL storage and retrieval
- Responsive design for mobile and desktop use
- Validation of URLs to ensure correctness
- High performance, handling up to 10,000 requests per second

## Technologies Used

- **Frontend:** React
- **Backend:** Spring Boot
- **Database:** H2 (for development), MySQL/PostgreSQL (for production)
- **Others:** Spring Data JPA, Axios, HTML, CSS

## Getting Started

Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Node.js and npm installed
- Java JDK 8 or later installed
- Maven installed

## Installation

### Backend

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/url-shortener.git
    cd url-shortener/backend
    ```

2. Update `application.properties` with your database configuration if using a database other than H2.

3. Build the project:
    ```bash
    mvn clean install
    ```

4. Run the Spring Boot application:
    ```bash
    mvn spring-boot:run
    ```

### Frontend

1. Navigate to the frontend directory:
    ```bash
    cd ../frontend
    ```

2. Install dependencies:
    ```bash
    npm install
    ```

3. Start the React application:
    ```bash
    npm start
    ```

## Usage

1. Open your web browser and go to `http://localhost:3000`.
2. Enter a long URL in the input field and click the "Shorten" button.
3. The shortened URL will be displayed below the input field.

## API Endpoints

- `POST /api/shorten` - Shorten a long URL
  - Request body: `{ "longUrl": "https://example.com" }`
  - Response: `{ "shortUrl": "http://localhost:8080/{hash}" }`

- `GET /{hash}` - Redirect to the original long URL
  - Path parameter: `hash` - The hash of the shortened URL
  - Response: Redirects to the long URL

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes. Ensure that your code follows the project's coding standards and includes appropriate tests.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
