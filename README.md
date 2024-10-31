# TravelCompanyEshop

## Project Overview
The **TravelCompanyEshop** project is designed to manage customers, itineraries, and ticketing services for a travel company. It consists of multiple classes and services that allow for customer registration, itinerary management, and ticket issuance, along with exception handling for errors in these processes.

## Requirements
- **Java Development Kit (JDK)**: Version 23 or higher
- **IntelliJ IDEA** (recommended for development)

## Project Structure
The project is organized into several packages, each containing classes with specific responsibilities.

### Packages and Classes

1. **Domain (`domain`)**
    - **Customer**: Abstract class that represents a generic customer with attributes like `id`, `name`, `email`, `address`, and `nationality`.
    - **CustomerBusiness**: Extends `Customer` and represents a business customer `category`.
    - **CustomerIndividual**: Extends `Customer` and represents an individual customer `category`.
    - **Itinerary**: Represents an itinerary that includes travel details.
    - **Ticket**: Represents a ticket issued to a customer with a given itinerary.

2. **Enumerations (`enumeration`)**
    - **Airline**: Enum that represents different airlines.
    - **AirportCode**: Enum for airport codes.
    - **Category**: Enum for categorizing customers.
    - **Nationality**: Enum for customer nationality.
    - **PaymentMethod**: Enum for various payment methods.

3. **Exceptions (`exception`)**
    - **CustomerEmailException**: Thrown when a customer's email does not end with the required domain (e.g., `@travelcompany.com`).
    - **ItineraryAirportCodeException**: Thrown when an itinerary's airport code is invalid.
    - **TicketIssuingException**: Thrown when a customer or an itinerary given doesn't exist.
    - **IndexOutOfBoundsException**: Thrown when a List is out of index.

4. **Services (`service`)**
    - **CustomerService**: Interface for customer-related operations.
    - **CustomerServiceHandler**: Handles operations related to customers, such as loading customers and calculating ticket statistics.
    - **CustomerServiceImpl**: Concrete implementation for customer services.
    - **ItineraryService**: Interface for itinerary-related operations.
    - **ItineraryServiceHandler**: Handles loading and managing itineraries.
    - **ItineraryServiceImpl**: Concrete implementation for itinerary services.
    - **TicketService**: Service for handling ticket operations.
    - **TicketServiceHandler**: Handles ticket reporting.

## How to Run
1. Make sure JDK 23 or higher is installed.
2. Open the project in **IntelliJ IDEA**.
3. Run the `TravelCompanyEshop` main class to start the application.

## Usage
The program allows you to:
- Register customers and itineraries.
- Issue tickets for customers.
- Handle errors in customer email validation, airport code verification, and ticket issuance.

## Exception Handling
The project makes use of extensive `try-catch` blocks to ensure that the program continues running even if exceptions occur. This approach helps to process valid entries while skipping or logging erroneous ones.

## License
This project is intended for educational purposes.