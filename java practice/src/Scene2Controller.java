import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Scene2Controller{

    @FXML
    private TextField calorieIntake;

    @FXML
    private TextField averageBMR;

    @FXML
    private TextField calorieBurn;

    @FXML
    private TextField calorieDeficit;

    @FXML
    private CheckBox rice;

    @FXML
    private CheckBox noodle;

    @FXML
    private CheckBox bread;

    @FXML
    private CheckBox chicken;

    @FXML
    private CheckBox fish;

    @FXML
    private CheckBox burger;

    @FXML
    private CheckBox tea;

    @FXML
    private CheckBox coffee;

    @FXML
    private CheckBox plainWater;

    @FXML
    private CheckBox walk;

    @FXML
    private CheckBox jog;

    @FXML
    private CheckBox swim;

    @FXML
    private CheckBox rope;

    @FXML
    private CheckBox bodybuild;

    @FXML
    private TextField riceQuantity;

    @FXML
    private TextField noodleQuantity;

    @FXML
    private TextField breadQuantity;

    @FXML
    private TextField chickenQuantity;

    @FXML
    private TextField fishQuantity;

    @FXML
    private TextField burgerQuantity;

    @FXML
    private TextField teaQuantity;

    @FXML
    private TextField coffeeQuantity;

    @FXML
    private Button calculateButton;

    @FXML
    private Label comment;

    double quantityOfRice;
    double quantityOfNoodle;
    double quantityOfBread;
    double quantityOfChicken;
    double quantityOfFish;
    double quantityOfBurger;
    double quantityOfTea;
    double quantityOfCoffee;
    double calAmount;
    double calBurn;

    public void avgBMR(Double BMR) {
        averageBMR.setText(Double.toString(BMR));
    }

    public void totalCaloriIntake(ActionEvent event) throws IOException {

        try {
            if (rice.isSelected() && riceQuantity != null) {
                calAmount += 206;
                quantityOfRice = Double.parseDouble(riceQuantity.getText());
                calAmount *= quantityOfRice;
            }
        }
        catch (NumberFormatException e) {
            quantityOfRice =1.0;
        }

        try {
            if (noodle.isSelected() && noodleQuantity != null) {
                calAmount += 221;
                quantityOfNoodle = Double.parseDouble(noodleQuantity.getText());
                calAmount *= quantityOfNoodle;
            }
        }
        catch (NumberFormatException e) {
            quantityOfNoodle =1.0;
        }

        try {
            if (bread.isSelected() && breadQuantity != null) {
                calAmount += 79;
                quantityOfBread = Double.parseDouble(breadQuantity.getText());
                calAmount *= quantityOfBread;
            }
        }
        catch (NumberFormatException e) {
            quantityOfBread =1.0;
        }

        try {
            if (chicken.isSelected() && chickenQuantity != null) {
                calAmount += 335;
                quantityOfChicken = Double.parseDouble(chickenQuantity.getText());
                calAmount *= quantityOfChicken;
            }
        }
        catch (NumberFormatException e) {
            quantityOfChicken =1.0;
        }

        try {
            if (fish.isSelected() && fishQuantity != null) {
                calAmount += 218;
                quantityOfFish = Double.parseDouble(fishQuantity.getText());
                calAmount *= quantityOfFish;
            }
        }
        catch (NumberFormatException e) {
            quantityOfFish =1.0;
            quantityOfCoffee =1.0;
        }

        try {
            if (burger.isSelected() && burgerQuantity != null) {
                calAmount += 426;
                quantityOfBurger = Double.parseDouble(burgerQuantity.getText());
                calAmount *= quantityOfBurger;
            }
        }
        catch(NumberFormatException e) {
            quantityOfBurger =1.0;
        }

        try {
            if (tea.isSelected() && teaQuantity != null) {
                calAmount += 30;
                quantityOfTea = Double.parseDouble(teaQuantity.getText());
                calAmount *= quantityOfTea;
            }
        }
        catch (NumberFormatException e) {
            quantityOfTea =1.0;
        }

        try {
            if (coffee.isSelected() && coffeeQuantity != null) {
                calAmount += 60;
                quantityOfCoffee = Double.parseDouble(coffeeQuantity.getText());
                calAmount *= quantityOfCoffee;
            }
        }
        catch (NumberFormatException e) {
        quantityOfCoffee =1.0;
        }
        System.out.println(calAmount);
        calorieIntake.setText(Double.toString(calAmount));
        calAmount = 0;


    }

    public void tocalCalorieBurn (ActionEvent event){

        if(walk.isSelected()){

            calBurn += 170;
        }

        if(jog.isSelected()){

            calBurn += 300;
        }

        if(swim.isSelected()){

            calBurn += 286;
        }

        if(rope.isSelected()){

            calBurn += 250;
        }

        if(bodybuild.isSelected()){

            calBurn += 230;
        }

        System.out.println(calBurn);
        calorieBurn.setText(Double.toString(calBurn));
        calBurn = 0;


    }

    /*public void setCalorieIntake(){

        calorieIntake.setText(Double.toString(calAmount));

    }*/

    /*public void setCalorieBurn (){

        calorieBurn.setText(Double.toString(calBurn));
    }*/

    public void calculateDeficit(ActionEvent event){


        double calIntake = Double.parseDouble(calorieIntake.getText());
        double calUsed = Double.parseDouble(calorieBurn.getText());
        double calBMR = Double.parseDouble(averageBMR.getText());
        double Deficit = calUsed + calBMR - calIntake;
        calorieDeficit.setText(Double.toString(Deficit));

        if(Deficit < 0){
            comment.setText("Cut down on food or exercise more");
        }
        else{
            comment.setText("Keep up the good work");
        }

    }



}
