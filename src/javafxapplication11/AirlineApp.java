/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javafxapplication11;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class AirlineApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Airline Booking");
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        Label fromLabel = new Label("From:");
        ComboBox<String> fromComboBox = new ComboBox<>();
        fromComboBox.getItems().addAll("NewYork", "London", "Paris", "Tokyo");
        Label toLabel = new Label("To:");
        ComboBox<String> toComboBox = new ComboBox<>();
        toComboBox.getItems().addAll("NewYork", "London", "Paris", "Tokyo");
        Label departureLabel = new Label("Departure Date:");
        DatePicker departureDatePicker = new DatePicker();
        Label returnLabel = new Label("Return Date:");
        DatePicker returnDatePicker = new DatePicker();
        Label passengerLabel = new Label("Passenger Name:");
        TextField passengerTextField = new TextField();
        Button searchFlightsButton = new Button("Search Flight");
        TableView<Flight> flightsTable = new TableView<>();
        TableColumn<Flight, String> flightColumn = new TableColumn<>("Flight");
        flightColumn.setCellValueFactory(cellData -> cellData.getValue().flightProperty());
        TableColumn<Flight, String> departureColumn = new TableColumn<>("Departure");
        departureColumn.setCellValueFactory(cellData -> cellData.getValue().departureProperty());
        TableColumn<Flight, String> destinationColumn = new TableColumn<>("Destination");
        destinationColumn.setCellValueFactory(cellData -> cellData.getValue().destinationProperty());
        flightsTable.getColumns().addAll(flightColumn, departureColumn, destinationColumn);
        searchFlightsButton.setOnAction(event -> {
            flightsTable.getItems().setAll(
             new Flight("XYZ123", "JFK", "LHR"),
             new Flight("ABC456", "SFO", "ORD")
            );
        });
        //set up grid layout
        grid.add(fromLabel, 0, 0);
        grid.add(fromComboBox, 1, 0);
        grid.add(toLabel, 0, 1);
        grid.add(toComboBox, 1, 1);
        grid.add(departureLabel, 0, 2);
        grid.add(departureDatePicker, 1, 2);
        grid.add(returnLabel, 0, 3);
        grid.add(returnDatePicker, 1, 3);
        grid.add(passengerLabel, 0, 4);
        grid.add(passengerTextField, 1, 4);
        grid.add(searchFlightsButton, 0, 5);
        grid.add(flightsTable, 0, 6, 2, 1);
        Scene scene = new Scene(flightsTable, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static class Flight {
        private final String flight;
        private final String departure;
        private final String destination;
        public Flight(String flight, String departure, String destination){
            this.flight = flight;
            this.departure = departure;
            this.destination = destination;
        }
        public String getFlight(){
            return flight;
        }
        public String getDeparture(){
            return departure;
        }
        public String getDestination(){
            return destination;
        }
        public StringProperty flightProperty(){
            return new SimpleStringProperty(flight);
        }
        public StringProperty departureProperty(){
            return new SimpleStringProperty(departure);
        }
        public StringProperty destinationProperty(){
            return new SimpleStringProperty(destination);
        }
        
    }
}
    
    