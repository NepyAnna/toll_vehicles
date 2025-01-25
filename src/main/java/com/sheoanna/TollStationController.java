package com.sheoanna;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sheoanna.vehicles.Car;
import com.sheoanna.vehicles.Motorcycle;
import com.sheoanna.vehicles.Truck;
import com.sheoanna.vehicles.Vehicle;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class TollStationController {

    private final TollStationService tollStationService;

    public TollStationController(TollStationService tollStationService) {
        this.tollStationService = tollStationService;
    }

    public void startServer() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/toll-station/name", this::handleGetName);
        server.createContext("/toll-station/city", this::handleGetCity);
        server.createContext("/toll-station/total-toll", this::handleGetTotalToll);
        server.createContext("/toll-station/reports", this::handleGetReports);
        server.createContext("/toll-station/calculate-toll", this::handleCalculateToll);
        server.createContext("/toll-station/report", this::handleGenerateReport);

        server.setExecutor(null);
        server.start();
        System.out.println("Server is running on http://localhost:8080");
    }

    private void handleGetName(HttpExchange exchange) throws IOException {
        if ("GET".equals(exchange.getRequestMethod())) {
            String response = tollStationService.getName();
            sendResponse(exchange, response);
        } else {
            sendResponse(exchange, "Method not allowed", 405);
        }
    }

    private void handleGetCity(HttpExchange exchange) throws IOException {
        if ("GET".equals(exchange.getRequestMethod())) {
            String response = tollStationService.getCity();
            sendResponse(exchange, response);
        } else {
            sendResponse(exchange, "Method not allowed", 405);
        }
    }

    private void handleGetTotalToll(HttpExchange exchange) throws IOException {
        if ("GET".equals(exchange.getRequestMethod())) {
            String response = String.valueOf(tollStationService.getTotalToll());
            sendResponse(exchange, response);
        } else {
            sendResponse(exchange, "Method not allowed", 405);
        }
    }

    private void handleGetReports(HttpExchange exchange) throws IOException {
        if ("GET".equals(exchange.getRequestMethod())) {
            String response = String.join("\n", tollStationService.getReports());
            sendResponse(exchange, response);
        } else {
            sendResponse(exchange, "Method not allowed", 405);
        }
    }

    private void handleCalculateToll(HttpExchange exchange) throws IOException {
        if ("POST".equals(exchange.getRequestMethod())) {
            String body = new String(exchange.getRequestBody().readAllBytes());
            Vehicle vehicle = parseVehicleFromBody(body);
            tollStationService.calculateToll(vehicle);
            sendResponse(exchange, "Toll calculated for vehicle: " + vehicle.getLicenseNumber());
        } else {
            sendResponse(exchange, "Method not allowed", 405);
        }
    }

    private void handleGenerateReport(HttpExchange exchange) throws IOException {
        if ("GET".equals(exchange.getRequestMethod())) {
            String response = tollStationService.generateReport();
            sendResponse(exchange, response);
        } else {
            sendResponse(exchange, "Method not allowed", 405);
        }
    }

    private Vehicle parseVehicleFromBody(String body) {
        // парсинг даних з тіла запиту (очікується формат: тип,номер,ось)
        String[] parts = body.split(",");
        String type = parts[0];
        String licenseNumber = parts[1];
        switch (type) {
            case "Car":
                return new Car(licenseNumber);
            case "Motorcycle":
                return new Motorcycle(licenseNumber);
            case "Truck":
                int axlesNumber = Integer.parseInt(parts[2]);
                return new Truck(licenseNumber, axlesNumber);
            default:
                throw new IllegalArgumentException("Invalid vehicle type: " + type);
        }
    }

    private void sendResponse(HttpExchange exchange, String response) throws IOException {
        sendResponse(exchange, response, 200);
    }

    private void sendResponse(HttpExchange exchange, String response, int statusCode) throws IOException {
        exchange.sendResponseHeaders(statusCode, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
