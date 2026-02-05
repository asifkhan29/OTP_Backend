                                                                         Secure OTP Generator System

                                                                         
🚀 Project Overview
This project is a full-stack real-time OTP (One-Time Password) generation system. It features a Spring Boot backend that streams numeric OTPs and an Angular frontend
that displays them with a live, modern circular countdown timer. The system is designed to demonstrate proficiency in reactive programming, API integration, 
and modern UI/UX design.

🛠 Technology Stack

Backend: Java 17, Spring Boot 3.x, Spring WebFlux.


Frontend: Angular 16+, TypeScript, Tailwind CSS.


API Communication: Server-Sent Events (SSE) for real-time streaming.


Tools: Maven, Node.js, NPM.

✨ Key Features

Dynamic OTP Generation: Supports 3, 4, 5, or 6-digit numeric OTPs based on user selection.


Real-time Auto-Refresh: The backend automatically pushes a new OTP every 30 seconds.


Modern UI/UX: A "classy" glassmorphism design featuring a circular countdown timer to indicate remaining validity.


Error & Loading States: Robust handling of connection losses and generation states.

📥 Installation & Setup
Prerequisites
JDK 17 or higher.

Node.js & NPM.

Maven.

1. Backend Setup (Spring Boot)
Navigate to the backend directory.

Build the project:

Bash
mvn clean install
Run the application:

Bash
mvn spring-boot:run
The API will be available at: http://localhost:8081/api/otp/generate.

2. Frontend Setup (Angular)
Navigate to the frontend directory.

Install dependencies:

Bash
npm install
Start the development server:

Bash
ng serve
Open your browser to: http://localhost:4200.

📡 API Documentation
Generate OTP Stream

Endpoint: /api/otp/generate 

Method: GET


Query Params: digits (Optional, default=6) 

Response Type: text/event-stream (SSE)

Payload Example:

JSON
{
  "otp": "482931",
  "digits": 6,
  "validForSeconds": 30,
  "createdAt": "2023-10-27T10:00:00"
}
📸 Application Screenshots

(Note: Replace these placeholders with your actual screenshots as required by the submission guidelines )

Initial State: Dropdown selection for OTP length.

Active Stream: Live OTP display with the circular countdown.

Error Handling: UI state when the backend server is disconnected.

📝 Assignment Requirements Checklist
[x] Task 1: Numeric OTP generation (3 or 6 digits).

[x] Task 2: Spring Boot REST API with Controller/Service layers.

[x] Task 3: Angular UI with dropdown and center display.

[x] Task 4: Full-stack integration with loading/error handling.
