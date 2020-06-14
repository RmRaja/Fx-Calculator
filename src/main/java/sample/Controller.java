package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private String x, y, operand, result = null;

    @FXML
    private JFXTextField resultText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void handleNumberClickEvent(ActionEvent event) {
        Button button = (Button) event.getSource();
        String input = button.getText();
        if (this.operand == null) {
            if (this.x == null) {
                this.x = input;
            } else {
                this.x += input;
            }
            resultText.setText(this.x);
        } else {
            if (this.y == null) {
                this.y = input;
            } else {
                this.y += input;
            }
            resultText.setText(this.y);
        }
    }

    @FXML
    private void handleActionClickEvent(ActionEvent event) {
        Button button = (Button) event.getSource();
        if (this.operand != null) {
            if (this.x != null && this.y != null) {
                String calcResult = calculate();
                resultText.setText(calcResult);
                this.x = calcResult;
                this.y = null;
            }
        }
        this.operand = button.getText();
    }

    private String calculate() {
        double a = Double.parseDouble(this.x);
        double b = Double.parseDouble(this.y);
        double output = 0.00;
        switch (this.operand) {
            case "+":
                output = a + b;
                break;
            case "-":
                output = a - b;
                break;
            case "/":
                output = a / b;
                break;
            case "*":
                output = a * b;
                break;
            default:
                break;
        }
        return new DecimalFormat("#.##").format(output);
    }

    @FXML
    private void resetCalculator() {
        this.x = null;
        this.y = null;
        this.operand = null;
        this.resultText.setText("0.00");
    }
}
